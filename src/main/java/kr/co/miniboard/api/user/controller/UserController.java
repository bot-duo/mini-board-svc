package kr.co.miniboard.api.user.controller;

import kr.co.miniboard.api.user.service.UserService;
import kr.co.miniboard.common.ResponseObject;
import kr.co.miniboard.common.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/name")
    public ResponseObject getIdByName(@RequestParam(required = true) String name) {

        log.info("*** getIdByName ***");
        log.info("name : {}", name);

        return ResponseObject.builder(HttpStatus.OK, userService.getIdByName(name), ServiceConstants.ResponseMessage.SUCCESS).build();
    }

}
