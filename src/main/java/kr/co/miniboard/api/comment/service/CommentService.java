package kr.co.miniboard.api.comment.service;

import kr.co.miniboard.api.comment.entity.CommentEntity;
import kr.co.miniboard.api.comment.dto.CommentReqDto;
import kr.co.miniboard.api.comment.dto.CommentRspDto;
import kr.co.miniboard.api.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 댓글 Service
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * 댓글 조회
     * @param reqDto
     * @return
     */
    public CommentRspDto getComment(CommentReqDto reqDto) {
        log.info("*** findCommentByBoardNo ***");
        CommentEntity commentEntity = commentRepository.findById(reqDto.getBoardNo());

        CommentRspDto rspDto = new CommentRspDto(commentEntity);

        if(null == rspDto) {
//            throw ...
        }

        return rspDto;
    }

    /**
     * 댓글 등록
     * @param reqDto
     */
    public void createComment(CommentReqDto reqDto) {

    }

    /**
     * 댓글 수정
     * @param reqDto
     */
    public void modifyComment(CommentReqDto reqDto) {

    }

    /**
     * 댓글 삭제
     * @param reqDto
     */
    public void removeComment(CommentReqDto reqDto) {

    }
}
