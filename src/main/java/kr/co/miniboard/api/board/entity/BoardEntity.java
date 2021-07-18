package kr.co.miniboard.api.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity{ //extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="board_ID")
    private Long boardId;

    @Column(nullable = false, name="user_ID")
    private Long userId;

    @Column(name="board_title")
    private String title;

    @Column(name="board_content")
    private String content;

    @Column(name="board_like")
    private Long like;

    @Builder
    public BoardEntity(Long boardId, Long userId, String title, String content, Long like){
        this.boardId = boardId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.like = like;
    }
}
