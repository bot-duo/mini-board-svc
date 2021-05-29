package kr.co.miniboard.api.user.service.impl;

import kr.co.miniboard.api.user.domain.UserEntity;
import kr.co.miniboard.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 ServiceImpl
 * @author gyujin
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public UserEntity getIdByName(String name) {
        UserEntity rspDto = null;

        if(null == rspDto) {
            // 예외처리 정의 클래스 추가 필요
            // throw ...
        }

        return rspDto;
    }
}
