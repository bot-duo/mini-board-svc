package kr.co.miniboard.api.sample.service.impl;

import kr.co.miniboard.api.sample.model.SampleReqDTO;
import kr.co.miniboard.api.sample.service.SampleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SampleServiceImpl implements SampleService {

    public String getSampleText(SampleReqDTO reqDto) {

        return "";
    }
}
