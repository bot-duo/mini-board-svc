package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc Unauthorized Exception 정의
 */
public class UnauthorizedException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public UnauthorizedException(String message) {
        super(message);
    }
}
