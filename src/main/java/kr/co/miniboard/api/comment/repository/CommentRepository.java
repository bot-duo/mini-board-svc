package kr.co.miniboard.api.comment.repository;

import kr.co.miniboard.api.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
