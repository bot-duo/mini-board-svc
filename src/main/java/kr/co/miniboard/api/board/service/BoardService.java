package kr.co.miniboard.api.board.service;

import kr.co.miniboard.api.board.entity.BoardEntity;
import kr.co.miniboard.api.board.dto.BoardDto;
import kr.co.miniboard.api.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //전체 조회
    public List<BoardDto> getBoardList(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        System.out.println(boardDtoList.toString());
        for( BoardEntity boardEntity : boardEntities){
            BoardDto boardDTO = BoardDto.builder()
                    .boardId(boardEntity.getBoardId())
                    .userId(boardEntity.getUserId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    /*.createdDate(boardEntity.getCreatedDate())
                    .modifiedDate(boardEntity.getModifiedDate())*/
                    .build();
            boardDtoList.add(boardDTO);
        }
        return boardDtoList;
    }

    //게시판번호별 조회
    public List<BoardDto> getSelectBoardList(Long boardId){
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(boardId);
        BoardEntity boardEntity = boardEntityWrapper.get();
        List<BoardDto> boardDtoList = new ArrayList<>();
        
        BoardDto boardDTO = BoardDto.builder()
                .userId(boardEntity.getUserId())
                .boardId(boardEntity.getBoardId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                /*.createdDate(boardEntity.getCreatedDate())*/
                .build();
        boardDtoList.add(boardDTO);
        return boardDtoList;
    }


    //추가,수정
    public Long updateBoard(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getBoardId();
    }

    //삭제
    public void deletePost(Long boardId){
        boardRepository.deleteById(boardId);
    }

    //RESPONSE RETURN Create JSONObject
    /*
    {
        "message" : "success",
        "data"    : [
                        {
                         }
                     ]
     */
    public JSONObject createJSONObject(List<BoardDto> data){
        JSONObject mainObj = new JSONObject();
        mainObj.put("message", "success");
        mainObj.put("data",data);

        return mainObj;
    }
}
