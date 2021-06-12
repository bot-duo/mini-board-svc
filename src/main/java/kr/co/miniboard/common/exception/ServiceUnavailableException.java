package kr.co.miniboard.common.exception;

/**
 * @author gjlee
 * @desc ServiceUnavailable Exception 정의
 */
public class ServiceUnavailableException extends RuntimeException {

    /**
     * 생성자
     * @param message
     */
    public ServiceUnavailableException(String message) {
        super(message);
    }
}
