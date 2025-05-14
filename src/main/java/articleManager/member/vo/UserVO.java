package articleManager.member.vo;

import java.time.LocalDateTime;

import articleManager.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UserVO {
    //private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String loginId;
    //private String loginPw;
    private Integer authLevel;
    private String name;
    private String nickname;
    private String cellphoneNum;
    private String email;
    private Boolean delStatus;
    private LocalDateTime delDate;
    
    public static UserVO from(MemberDto member) {
        UserVO user = UserVO.builder()
            .regDate(member.getRegDate())
            .updateDate(member.getUpdateDate())
            .loginId(member.getLoginId())
            .authLevel(member.getAuthLevel())
            .name(member.getName())
            .nickname(member.getNickname())
            .cellphoneNum(member.getCellphoneNum())
            .email(member.getEmail())
            .delStatus(member.getDelStatus())
            .delDate(member.getDelDate())
            .build();
        return user;
    }
}
