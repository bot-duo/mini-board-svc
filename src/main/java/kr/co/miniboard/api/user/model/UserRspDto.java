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
    // 이름
    private String name;
    // 이메일
    private String email;
    // 사진
    private String picture;
    // 권한
    private RoleDto role;


    // 응답Dto 생성과 동시에 Entity값 삽입
    public UserRspDto(UserEntity entity) {

        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
    }

}
