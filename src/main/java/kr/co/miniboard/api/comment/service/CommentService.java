package kr.co.miniboard.api.comment.service;

import kr.co.miniboard.api.comment.dto.CommentReqDto;
import kr.co.miniboard.api.comment.dto.CommentRspDto;
import kr.co.miniboard.api.comment.entity.Comment;
import kr.co.miniboard.api.comment.repository.CommentRepository;
import kr.co.miniboard.common.ServiceConstants;
import kr.co.miniboard.common.exception.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 댓글 Service
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * 댓글 조회
     * @param reqDto
     * @return
     */
    public CommentRspDto getComment(CommentReqDto reqDto) {
        log.info("*** findCommentByBoardNo ***");
//        Comment comment = commentRepository.findByBoardNo(reqDto.getBoardNo()).orElse(null);

        CommentRspDto rspDto = null;

//        if(comment != null) {
//            rspDto = new CommentRspDto(comment);
//        }
//
//        if(null == rspDto) { // 예외 처리
//            throw new InternalServerErrorException(ServiceConstants.ResponseMessage.ERR_DBMS_002);
//        }

        return rspDto;
    }

    /**
     * 댓글 등록
     * @param reqDto
     */
    public void createComment(CommentReqDto reqDto) {

        CommentRspDto rspDto = null;

        log.info("*** insertComment ***");
        Comment reqEntity = new Comment(reqDto);
        Comment comment = commentRepository.save(reqEntity);

        rspDto = new CommentRspDto(comment);

        if(rspDto == null) { // 예외 처리
            throw new InternalServerErrorException(ServiceConstants.ResponseMessage.ERR_DBMS_001);
        }
    }

    /**
     * 댓글 수정
     * @param reqDto
     */
    public void modifyComment(CommentReqDto reqDto) {

        CommentRspDto rspDto = null;

        log.info("*** updateComment ***");
        Comment reqEntity = new Comment(reqDto);
        Comment comment = commentRepository.save(reqEntity);

        rspDto = new CommentRspDto(comment);

        if(rspDto == null) { // 예외 처리
            throw new InternalServerErrorException(ServiceConstants.ResponseMessage.ERR_DBMS_003);
        }
    }

    /**
     * 댓글 삭제
     * @param reqDto
     */
    public void removeComment(CommentReqDto reqDto) {

        CommentRspDto rspDto = null;
        reqDto.setDelYn("Y");

        log.info("*** deleteComment ***");
        Comment reqEntity = new Comment(reqDto);
        Comment comment = commentRepository.save(reqEntity);

        rspDto = new CommentRspDto(comment);

        if(rspDto == null) { // 예외 처리
            throw new InternalServerErrorException(ServiceConstants.ResponseMessage.ERR_DBMS_004);
        }
    }
}
