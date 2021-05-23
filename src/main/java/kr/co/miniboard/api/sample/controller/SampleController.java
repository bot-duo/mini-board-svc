package kr.co.miniboard.api.sample.controller;

import kr.co.miniboard.api.sample.model.SampleReqDTO;
import kr.co.miniboard.api.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON OBJ를 반환하는 컨트롤러로 생성해주는 어노테이션 (이전의 @ResponseBody 와 같은 어노테이션 기능 포함)
@RequestMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성한다
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/{text}")
    public String getText(@PathVariable(required = true) String text) {

        SampleReqDTO reqDto = new SampleReqDTO();

        reqDto.setText(text);

        return sampleService.getSampleText(reqDto);
    }
}
