package kr.co.miniboard.api.user.dto;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

@Getter
@RequiredArgsConstructor
public enum RoleDto {

    GUEST("ROLE_GUEST", "손님"),  //권한코드앞에 무조건 ROLE_ 해당 코드가 앞에있어야함
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;

}
