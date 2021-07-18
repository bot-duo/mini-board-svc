package kr.co.miniboard.api.user.handler;

import kr.co.miniboard.api.user.model.OAuth2AuthenticationDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class logoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication){
        Object details = authentication.getDetails();
        System.out.println(details);

        String token = ((OAuth2AuthenticationDetails)details).getTokenValue();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/token/revoke?token=" + token;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
        ResponseEntity<Boolean> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }
}
