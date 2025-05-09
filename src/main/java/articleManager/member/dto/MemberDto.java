package articleManager.member.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String loginId;
    private String loginPw;
    private int authLevel;
    private String name;
    private String nickname;
    private String cellphoneNum;
    private String email;
    private boolean delStatus;
    private LocalDateTime delDate;

    // 패스워드는 없어야됨
    public Map<String, String> asMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("regDate", delDate == null ? null : regDate.toString());
        map.put("updateDate", delDate == null ? null : updateDate.toString());
        map.put("loginId", loginId);
        map.put("authLevel", String.valueOf(authLevel));
        map.put("name", name);
        map.put("nickname", nickname);
        map.put("cellphoneNum", cellphoneNum);
        map.put("email", email);
        map.put("delStatus", String.valueOf(delStatus));
        map.put("delDate", delDate == null ? null : delDate.toString());
        return map;
    }
}
