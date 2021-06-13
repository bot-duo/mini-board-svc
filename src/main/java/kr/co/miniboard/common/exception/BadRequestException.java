package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc BadRequest Exception 정의
 */
public class BadRequestException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public BadRequestException(String message) {
        super(message);
    }
}
