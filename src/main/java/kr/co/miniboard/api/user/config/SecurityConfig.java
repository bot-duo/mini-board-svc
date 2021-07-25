package kr.co.miniboard.api.user.config;

import kr.co.miniboard.api.user.dto.RoleDto;
import kr.co.miniboard.api.user.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//스프링 시큐리티 설정
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기위해 해당 기능들을 꺼줌

                .and()
                .authorizeRequests() //URL별 권환 관리를 설정하는 옵션의 시작 antMatchers 옵션 사용하기 이해
                //권한 관리 대상을 지정 메스드별로 관리가 가능
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2/**", "/h2-console/**").permitAll() // url:/ 는 모두 열람 가능
                .antMatchers("/api/v1/**").hasRole(RoleDto.USER.name())        // 해당 url는 USER 권한이 있어야 가능
                .anyRequest().authenticated()

                .and()
                .logout().clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/")//로그아웃시 이동할 주소

                .and()
                //OAuth2 로그인 기능에 대한 설정의 진입점 소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록하는 곳이 UserService
                //사용자 정보를 가져온 후 진행하고싶은 기능을 명시
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
