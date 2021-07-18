package kr.co.miniboard.api.board.controller;

import kr.co.miniboard.api.board.service.BoardService;
import kr.co.miniboard.api.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@AllArgsConstructor
@Slf4j
@Controller

@RestController
public class BoardController {
    private BoardService boardService;

    //게시판 전체 조회
    @RequestMapping("/board/viewBoard")
    public JSONObject viewBoardList(ModelAndView model){
        System.out.println("**************START viewBoardList *******************");
        System.out.println(boardService.toString());
        List<BoardDto> boardList = boardService.getBoardList();
        for(BoardDto data : boardList){
            System.out.println(data);
        }
        JSONObject jsObj = boardService.createJSONObject(boardList);
        return jsObj;
    }

    @RequestMapping("/board/viewSelectBoard")
    public List<BoardDto> viewSelectBoard(@RequestBody JSONObject json){
        System.out.println("**************START viewSelectBoard *******************");
        System.out.println(boardService.toString());
        System.out.println(json.get("boardId"));
        String boardId = json.getAsString("boardId");

        List<BoardDto> boardList = boardService.getSelectBoardList(Long.parseLong(boardId));
        for(BoardDto data : boardList){
            System.out.println(data);
        }
        return boardList;
    }

    @RequestMapping("/board/addBoard")
    public String addBoard(@RequestBody BoardDto boardDto){
        System.out.println("**************START Boardwrite *******************");
        boardService.updateBoard(boardDto);

        return "success Add to" + boardDto;
    }

    @RequestMapping("/board/deleteBoard")
    public String deleteBoard(@RequestBody JSONObject json){
        System.out.println("**************START deleteBoard *******************");
        String boardId = json.getAsString("boardId");
        boardService.deletePost(Long.parseLong(boardId));

        return "success delete to boardId" + boardId;
    }
}
