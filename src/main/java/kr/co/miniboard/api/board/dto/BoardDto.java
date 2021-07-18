package kr.co.miniboard.api.board.dto;

import kr.co.miniboard.api.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long boardId;
    private Long userId;
    private String title;
    private String content;
    private Long like;
    /*private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;*/

    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder()
                .boardId(boardId)
                .userId(userId)
                .title(title)
                .content(content)
                .like(like)
                .build();
        return boardEntity;
    }

    @Builder

    public BoardDto(Long boardId, Long userId, String title, String content, Long like, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.boardId = boardId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.like = like;
        /*this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;*/
    }
}
