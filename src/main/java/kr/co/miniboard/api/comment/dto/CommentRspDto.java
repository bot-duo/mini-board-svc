package kr.co.miniboard.api.comment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.miniboard.api.comment.entity.Comment;
import lombok.Getter;

/**
 * 댓글 응답 DTO
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentRspDto {

    private Long commentNo;         // 댓글 ID
    private Integer boardNo;        // 게시글 ID
    private String userEmail;       // 사용자 이메일
    private String commentContent;  // 댓글 내용
    private Integer commentLike;    // 댓글 좋아요 수
    private String delYn;           // 삭제 여부

    public CommentRspDto(Comment comment) {
        this.commentNo = comment.getCommentNo();
        this.boardNo = comment.getBoardNo();
        this.userEmail = comment.getUserEmail();
        this.commentContent = comment.getCommentContent();
        this.commentLike = comment.getCommentLike();
        this.delYn = comment.getDelYn();
    }

}
