package kr.co.miniboard.common.exception;

import kr.co.miniboard.common.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.ServiceUnavailableException;

/**
 * @author gjlee
 * @desc REST API 에 대한 Exception 처리
 */
@Slf4j
@ControllerAdvice
@Controller
public class ApiExceptionHandler {

    /**
     * 지정하지 않은 Exception 발생 시 500
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject> handleException(Exception ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error("Exception: {}", message);
        ex.printStackTrace();
        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * Bad Request Exception 발생 시 400
     * @param ex
     * @return
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseObject> handleBadRequestException(BadRequestException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * Unauthorized Exception 발생 시 401
     * @param ex
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(UnauthorizedException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;

        log.error("UnauthorizedException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * Forbidden Exception 발생 시 403
     * @param ex
     * @return
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(ForbiddenException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.FORBIDDEN;

        log.error("ForbiddenException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * Not Found Exception 발생 시 404
     * @param ex
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        log.error("NotFoundException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * Conflict 발생 시 409
     * @param ex
     * @return
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handleConflictException(ConflictException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.CONFLICT;

        log.error("ConflictException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * 외부 API 호출 오류 발생 시 Internal Server Error로 처리 500
     * @param ex
     * @return
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> handleInternalServerErrorException(InternalServerErrorException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error("InternalServerErrorException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * ServiceUnavailable 발생 시 503
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<?> handleServiceUnavailableException(ServiceUnavailableException ex) {

        final String message = ex.getMessage();
        final HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;

        log.error("ServiceUnavailableException: {}", message);

        ResponseObject errorObject = ResponseObject.builder(httpStatus, null, filterMessage(message)).build();

        return new ResponseEntity<ResponseObject>(errorObject, httpStatus);
    }

    /**
     * message size 25 이상일 경우 message filter 처리
     * @param message
     * @return
     */
    private String filterMessage(String message) {

        if (!Strings.isEmpty(message) && 25 <= message.length()) {
            message = null;
        }

        return message;
    }

}
