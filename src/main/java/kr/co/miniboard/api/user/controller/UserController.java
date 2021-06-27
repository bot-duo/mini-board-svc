package kr.co.miniboard.api.user.controller;

import kr.co.miniboard.api.user.model.SessionUserDto;
import kr.co.miniboard.api.user.model.UserReqDto;
import kr.co.miniboard.api.user.service.UserService;
import kr.co.miniboard.common.ResponseObject;
import kr.co.miniboard.common.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Controller
//@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;
    /*private final ClientRegistrationRepository clientRegistrationRepository;*/

    @GetMapping("/")
    public ModelAndView login(ModelAndView model){
        SessionUserDto user = (SessionUserDto) httpSession.getAttribute("user");
        model.setViewName("login.html");
        if(user != null){
            model.addObject("userName", user.getName());
            model.addObject("userImg", user.getPicture());
            System.out.println("profile = " + user.getPicture());
            System.out.println("userNAme = " + user.getName());
        }
        return model;
    }

    @GetMapping("/exit")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request,null,null);
        try{
            response.sendRedirect(request.getHeader("referer"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
