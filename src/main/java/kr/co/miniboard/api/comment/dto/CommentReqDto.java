package kr.co.miniboard.api.comment.dto;

import lombok.Data;

/**
 * 댓글 요청 DTO
 */
@Data
public class CommentReqDto {

    private Long commentNo;         // 댓글 ID
    private Integer boardNo;        // 게시글 ID
    private String userEmail;       // 사용자 이메일
    private String commentContent;  // 댓글 내용
    private int commentLike;        // 좋아요 수
    private String delYn;           // 삭제 여부

}
