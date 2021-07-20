package kr.co.miniboard.api.comment.dto;

import lombok.Data;

/**
 * 댓글 요청 DTO
 */
@Data
public class CommentReqDto {

    private Long boardNo;           // 게시글 ID
    private String userEmail;       // 사용자 이메일
    private String commentContent;  // 댓글 내용
    private int commentLike;        // 좋아요 수

}
