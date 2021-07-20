package kr.co.miniboard.api.comment.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "comment_no")
    private Long commentNo;         // 댓글 ID

    @Column(nullable = false, name = "board_no")
    private Long boardNo;            // 게시글 ID

    @Column(nullable = false, name = "user_email")
    private String userEmail;       // 사용자 이메일

    @Column(nullable = false, length = 200, name = "comment_content")
    private String commentContent;  // 댓글 내용

    @Column(nullable = false, name = "comment_like")
    private int commentLike;        // 좋아요 수

    @Builder
    public CommentEntity(Long boardNo, String userEmail, String commentContent, int commentLike) {
        this.boardNo = boardNo;
        this.userEmail = userEmail;
        this.commentContent = commentContent;
        this.commentLike = commentLike;
    }
}
