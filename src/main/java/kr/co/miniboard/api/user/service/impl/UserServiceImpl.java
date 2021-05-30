package kr.co.miniboard.api.user.service.impl;

import kr.co.miniboard.api.user.domain.UserEntity;
import kr.co.miniboard.api.user.domain.UserRepository;
import kr.co.miniboard.api.user.model.UserReqDto;
import kr.co.miniboard.api.user.model.UserRspDto;
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

    private final UserRepository userRepository;

    public UserRspDto getIdByName(UserReqDto reqDto) {

        UserEntity userEntity = userRepository.findById(reqDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("DB 오류"));

        UserRspDto rspDto = new UserRspDto(userEntity);

        return rspDto;
    }
}
