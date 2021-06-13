package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc NotFound Exception 정의
 */
public class NotFoundException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
