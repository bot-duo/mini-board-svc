package kr.co.miniboard.api.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.miniboard.api.user.domain.UserEntity;
import lombok.Getter;

/**
 * 사용자 응답 DTO
 * @author gyujin
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRspDto {

    // ID
    private Long id;

    // 사용자 이름
    private String name;

    // 사용자 비밀번호
    private String password;

    // 나이
    private Integer age;

    // 주소
    private String address;

    // 응답Dto 생성과 동시에 Entity값 삽입
    public UserRspDto(UserEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.age = entity.getAge();
        this.address = entity.getAddress();
    }

}
