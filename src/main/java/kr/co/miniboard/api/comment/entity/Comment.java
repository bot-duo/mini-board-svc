package kr.co.miniboard.api.comment.entity;

import kr.co.miniboard.api.comment.dto.CommentReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@DynamicInsert  // 삽입 시 null 인 값 제외
@DynamicUpdate  // 수정 시 null 인 값 제외
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "comment_no")
    private Long commentNo;         // 댓글 ID

    @Column(nullable = false, name = "board_no")
    private Integer boardNo;        // 게시글 ID

    @Column(nullable = false, name = "user_email")
    private String userEmail;       // 사용자 이메일

    @Column(nullable = false, length = 200, name = "comment_content")
    private String commentContent;  // 댓글 내용

    @Column(nullable = false, name = "comment_like")
    private int commentLike;        // 좋아요 수

    @Column(nullable = false, name = "del_yn")
    private String delYn;           // 삭제 여부

    public Comment(CommentReqDto reqDto) {
        this.boardNo = reqDto.getBoardNo();
        this.userEmail = reqDto.getUserEmail();
        this.commentContent = reqDto.getCommentContent();
        this.commentLike = reqDto.getCommentLike();
        this.delYn = reqDto.getDelYn();
    }
}
