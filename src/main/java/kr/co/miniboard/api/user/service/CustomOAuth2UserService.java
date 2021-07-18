package kr.co.miniboard.api.user.service;

import kr.co.miniboard.api.user.domain.UserEntity;
import kr.co.miniboard.api.user.model.OAuthAttributes;
import kr.co.miniboard.api.user.model.SessionUserDto;
import kr.co.miniboard.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();

        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        System.out.println("token = " + userRequest.getAccessToken());
        OAuth2AccessToken token = userRequest.getAccessToken();
        for (String authority : token.getScopes()) {
            System.out.println("TOKEN_KEY" + authority);
        }
        //현재 로그인 진행 중인 서비스를 구분하는 코드
        String registrationId = userRequest
                .getClientRegistration()
                .getRegistrationId();

        // oauth2 로그인 진행 시 키가 되는 필드값
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        String access_token = userRequest.getAccessToken().toString();

        System.out.println("token = " + access_token);
        // OAuthAttributes: attribute를 담을 클래스 (개발자가 생성)
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,access_token, oAuth2User.getAttributes());

        UserEntity user = saveOrUpdate(attributes);

        //SessionUser: 세션에 사용자 정보를 저장하기 위한 DTO 클래스 (개발자가 생성)
        httpSession.setAttribute("user", new SessionUserDto(user));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }

    //우리 테이블에 없는 정보면 insert 기존의 회원 정보가 변경되어있으면 우리 테이블 데이터 update
    private UserEntity saveOrUpdate(OAuthAttributes attributes){
        UserEntity user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture(), attributes.getAccess_tokne()))
                .orElse(attributes.toEntity());
        return userRepository.save(user);
    }
}
