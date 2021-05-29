package kr.co.miniboard.api.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 * 사용자 응답 DTO
 * @author gyujin
 */
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRspDto {

    // ID
    private String id;

    // 사용자 이름
    private String name;

    // 사용자 비밀번호
    private String password;

    // 나이
    private Integer age;

    // 주소
    private String address;

}
