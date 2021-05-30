package kr.co.miniboard.api.user.repository;

import kr.co.miniboard.api.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //소셜 로그인으로 반환되는 값 중 email을 통해 기존 사용자인지 처음 가입하는 사용자인지 판단하기 위해
    Optional<UserEntity> findByEmail(String email);
    public UserEntity findUserById(Long id);
}
