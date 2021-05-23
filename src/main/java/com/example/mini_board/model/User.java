package com.example.mini_board.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //해당 클래스를 데이터베이스 테이블 -> 객체로 지정
@Data //롬복의 어노테이션ㅇ로 Getter와 Setter를 손쉽게 사용할 수 있음
public class User {

    @Id //데이터베이스의 PriaryKey에 해당하는 컬럼을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB의 AUTO INCREAMENT를 사용하기 위해 사용
    private Long id;

    private String username;

    private String password;
}
