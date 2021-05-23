package com.example.mini_board.repository;

import com.example.mini_board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> { //Entity 클래스와 해당 클래스이 ID 타입



}
