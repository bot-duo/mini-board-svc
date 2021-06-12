package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc Forbidden Exception 정의
 */
public class ForbiddenException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public ForbiddenException(String message) {
        super(message);
    }
}
