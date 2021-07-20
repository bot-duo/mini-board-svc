package kr.co.miniboard.api.comment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.co.miniboard.api.comment.entity.CommentEntity;
import lombok.Builder;
import lombok.Getter;

/**
 * 댓글 응답 DTO
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentRspDto {

    private Long commentNo;         // 댓글 ID
    private Long boardNo;           // 게시글 ID
    private String userEmail;       // 사용자 이메일
    private String commentContent;  // 댓글 내용
    private int commentLike;        // 댓글 좋아요 수

    public CommentRspDto(CommentEntity commentEntity) {
        this.commentNo = commentEntity.getCommentNo();
        this.boardNo = commentEntity.getBoardNo();
        this.userEmail = commentEntity.getUserEmail();
        this.commentContent = commentEntity.getCommentContent();
        this.commentLike = commentEntity.getCommentLike();
    }

}
