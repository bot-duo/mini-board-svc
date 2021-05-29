package kr.co.miniboard.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 결과 리턴용 Object
 * @author gyujin
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "responseObjectBuilder")
public class ResponseObject {

    private HttpStatus resultCode;
    private Object resultData;
    private String resultMessage;

    public static ResponseObjectBuilder builder(HttpStatus resultCode) {

        if (null == resultCode) {
            throw new IllegalArgumentException("resultCode Missing");
        }
        return responseObjectBuilder().resultCode(resultCode);
    }

    public static ResponseObjectBuilder builder(HttpStatus resultCode, Object resultData, String resultMessage) {

        if (null == resultCode) {
            throw new IllegalArgumentException("resultCode Missing");
        }
        return responseObjectBuilder().resultCode(resultCode).resultData(resultData).resultMessage(resultMessage);
    }

}
