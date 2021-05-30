package kr.co.miniboard.api.user.domain;

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

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 이름
    @Column(length = 10, nullable = false)
    private String name;

    // 사용자 비밀번호
    @Column(length = 50, nullable = false)
    private String password;

    // 나이
    @Column(length = 10, nullable = true)
    private Integer age;

    // 주소
    @Column(length = 100, nullable = true)
    private String address;

}
