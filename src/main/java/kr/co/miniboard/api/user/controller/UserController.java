package kr.co.miniboard.api.user.controller;

import kr.co.miniboard.api.user.model.SessionUserDto;
import kr.co.miniboard.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView login(Model model){
        SessionUserDto user = (SessionUserDto) httpSession.getAttribute("user");
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login.html");

        if(user != null){
            mv.addObject("userName", user.getName());
            mv.addObject("userImg", user.getPicture());

        }
        return mv;
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
