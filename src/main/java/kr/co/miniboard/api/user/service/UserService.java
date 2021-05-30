package kr.co.miniboard.api.user.service;

import kr.co.miniboard.api.user.model.UserReqDto;
import kr.co.miniboard.api.user.model.UserRspDto;

/**
 * 사용자 Service
 * @author gyujin
 */
public interface UserService {

    public UserRspDto getIdByName(UserReqDto reqDto);

}
