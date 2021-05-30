package kr.co.miniboard.api.user.domain;

import kr.co.miniboard.api.user.model.RoleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 사용자 Entity
 * @author gyujin
 */
@Getter
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id //데이터베이스의 PriaryKey에 해당하는 컬럼을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB의 AUTO INCREAMENT를 사용하기 위해 사용
    private Long id;

    @Column(nullable = false , name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // 기본적으로 int로 된 숫자가 저장되기때문에 식별하기위해 문자열로 수정
    private RoleDto role;

    @Builder
    public UserEntity(Long id, String name, String email, String picture, RoleDto role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public UserEntity update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
