package kr.co.miniboard.api.user.dto;

import kr.co.miniboard.api.user.domain.UserEntity;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUserDto implements Serializable {

    // 이름
    private String name;
    // 이메일
    private String email;
    // 사진
    private String picture;

    public SessionUserDto(UserEntity userEntity) {
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.picture = userEntity.getPicture();
    }
}
