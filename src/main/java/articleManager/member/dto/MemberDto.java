package articleManager.member.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String loginId;
    private String loginPw;
    private Integer authLevel;
    private String name;
    private String nickname;
    private String cellphoneNum;
    private String email;
    private Boolean delStatus;
    private LocalDateTime delDate;

}
