package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc Conflict Exception 정의
 */
public class ConflictException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public ConflictException(String message) {
        super(message);
    }
}
