package kr.co.miniboard.api.sample.service;

import kr.co.miniboard.api.sample.model.SampleReqDTO;
import org.springframework.stereotype.Service;

public interface SampleService {
    public String getSampleText(SampleReqDTO reqDto);
}
