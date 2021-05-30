package kr.co.miniboard.api.user.service;

import kr.co.miniboard.api.user.domain.UserEntity;
import kr.co.miniboard.api.user.model.UserReqDto;
import kr.co.miniboard.api.user.model.UserRspDto;
import kr.co.miniboard.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 사용자 Service
 * @author gyujin
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Id로 사용자 조회
     * @param reqDto
     * @return
     */
    public UserRspDto getUserById(UserReqDto reqDto) {

        log.info("*** findUserById ***");
        UserEntity userEntity = userRepository.findUserById(reqDto.getId());
        UserRspDto rspDto = new UserRspDto(userEntity);

        if(null == rspDto) {
//            throw ...
        }

        return rspDto;
    }
}
