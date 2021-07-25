package kr.co.miniboard.api.comment.repository;

import kr.co.miniboard.api.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
