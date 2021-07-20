package kr.co.miniboard.api.comment.controller;

import kr.co.miniboard.api.comment.dto.CommentReqDto;
import kr.co.miniboard.api.comment.service.CommentService;
import kr.co.miniboard.common.ResponseObject;
import kr.co.miniboard.common.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 댓글 Controller
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 조회
     * @param boardNo
     * @param userEmail
     * @return
     */
    @GetMapping("/")
    public ResponseObject getComment(@RequestParam(required = false) Long boardNo,
                                     @RequestParam(required = false) String userEmail) {

        log.info("*** getComment ***");
        log.info("* boardNo   : {}", boardNo);
        log.info("* userEmail : {}", userEmail);

        CommentReqDto reqDto = new CommentReqDto();
        reqDto.setBoardNo(boardNo);
        reqDto.setUserEmail(userEmail);

        return ResponseObject.builder(HttpStatus.OK, commentService.getComment(reqDto), ServiceConstants.ResponseMessage.SUCCESS).build();
    }

    /**
     * 댓글 등록
     * @param reqDto
     * @return
     */
    @PostMapping("/")
    public ResponseObject createComment(@RequestBody CommentReqDto reqDto) {

        log.info("*** createComment ***");
        commentService.createComment(reqDto);

        return ResponseObject.builder(HttpStatus.OK, null, ServiceConstants.ResponseMessage.SUCCESS).build();
    }

    /**
     * 댓글 수정
     * @param reqDto
     * @return
     */
    @PutMapping("/modify")
    public ResponseObject modifyComment(@RequestBody CommentReqDto reqDto) {

        log.info("*** modifyComment ***");
        commentService.modifyComment(reqDto);

        return ResponseObject.builder(HttpStatus.OK, null, ServiceConstants.ResponseMessage.SUCCESS).build();
    }

    /**
     * 댓글 삭제
     * @param reqDto
     * @return
     */
    @DeleteMapping("/remove")
    public ResponseObject removeComment(@RequestBody CommentReqDto reqDto) {

        log.info("*** removeComment ***");
        commentService.removeComment(reqDto);

        return ResponseObject.builder(HttpStatus.OK, null, ServiceConstants.ResponseMessage.SUCCESS).build();
    }

//    /**
//     * 댓글 좋아요 CountUp
//     * @param reqDto
//     * @return
//     */
//    @PostMapping("/like")
//    public ResponseObject modifyCommentLike(@RequestBody CommentReqDto reqDto) {
//
//        log.info("*** modifyCommentLike ***");
//        commentService.modifyCommentLike(reqDto);
//
//        return ResponseObject.builder(HttpStatus.OK, null, ServiceConstants.ResponseMessage.SUCCESS).build();
//    }

}
