package kr.co.miniboard.api.user.dto;

import lombok.Data;

/**
 * 사용자 요청 DTO
 * @author gyujin
 */
@Data
public class UserReqDto {

    // ID
    private Long id;

    // 사용자 이름
    private String name;

}
