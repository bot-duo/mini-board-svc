package com.example.mini_board.cotroller;

import com.example.mini_board.model.User;
import com.example.mini_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//RestController -> view를 리턴하는것이 아닌 JSON 데이터 리턴. 유사 ResponseBody
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "index";
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable("id") Long id){
        Optional<User> userOptional = userRepository.findById(id); //optional NPE를 피하기위해서 사용
        userOptional.ifPresent(System.out::println);
        return "successfully executed";
    }

    @GetMapping("/user/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userRepository.deleteById(id); //optional NPE를 피하기위해서 사용
    }
}
