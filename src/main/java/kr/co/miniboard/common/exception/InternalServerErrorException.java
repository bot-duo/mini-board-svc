package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc Internal Server Error Exception 정의
 */
public class InternalServerErrorException extends RuntimeException {

    Object data;

    /**
     * 생성자
     * @param message
     */
    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Object data) {
        super(message);
        this.data = data;
    }
}
