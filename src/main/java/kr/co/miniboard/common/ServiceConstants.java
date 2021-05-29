package kr.co.miniboard.common;

/**
 * 서비스 상수 모음
 * @author gyujin
 */
public class ServiceConstants {

    /**
     * 응답 메시지
     */
    public class ResponseMessage {

        public static final String FAIL                     = "FAIL";
        public static final String SUCCESS                  = "SUCCESS";

        // CRUD 관련
        public static final String ERR_DBMS_001             = "ERR_DBMS_001";       // INSERT ERROR
        public static final String ERR_DBMS_002             = "ERR_DBMS_002";       // SELECT ERROR
        public static final String ERR_DBMS_003             = "ERR_DBMS_003";       // UPDATE ERROR
        public static final String ERR_DBMS_004             = "ERR_DBMS_004";       // DELETE ERROR

    }

}
