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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
//@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;
    /*private final ClientRegistrationRepository clientRegistrationRepository;*/

    @GetMapping("/")
    public String login(Model model){
        SessionUserDto user = (SessionUserDto) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());

        }
        return "login.html";
    }
//    @GetMapping("/test")
//    public String test() {
//        return "index";
//    }

    /*@GetMapping("/{id}")
    public ResponseObject getUserById(@PathVariable("id") Long id){
        Optional<User> userOptional = userRepository.findById(id); //optional NPE를 피하기위해서 사용

        UserReqDto reqDto = new UserReqDto();
        reqDto.setId(id);
        log.info("*** getUserById ***");
        log.info("id : {}", id);

        return ResponseObject.builder(HttpStatus.OK, userService.getUserById(reqDto), ServiceConstants.ResponseMessage.SUCCESS).build();
    }*/


}
