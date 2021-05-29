package kr.co.miniboard.api.user.service;

import kr.co.miniboard.api.user.domain.UserEntity;

/**
 * 사용자 Service
 * @author gyujin
 */
public interface UserService {

    public UserEntity getIdByName(String name);

}
