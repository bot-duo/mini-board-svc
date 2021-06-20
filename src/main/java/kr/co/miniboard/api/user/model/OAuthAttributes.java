package kr.co.miniboard.api.user.model;

import kr.co.miniboard.api.user.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;

    private String nameAttributeKey;

    private String name;

    private String email;

    private String picture;

    private String access_tokne;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, String access_token){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.access_tokne = access_token;
    }

    //OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야함
    public static OAuthAttributes of(String registrationId, String userNameAttributeName,String access_token, Map<String, Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .access_token((String) attributes.get("access_token"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //User 엔티티 생성, 처음 가입때만
    //가입할떄 기본권한을 GUEST로 부여,
    //OAuthAttribute클래스 생성이 끝나면 같은 페키지에 SessionUser 클래스 생성
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(RoleDto.GUEST)
                .build();
    }
}
