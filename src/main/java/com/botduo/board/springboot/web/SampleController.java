package com.botduo.board.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON OBJ를 반환하는 컨트롤러로 생성해주는 어노테이션 (이전의 @ResponseBody 와 같은 어노테이션 기능 포함)
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
