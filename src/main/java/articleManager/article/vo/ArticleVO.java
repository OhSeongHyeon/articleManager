package articleManager.article.vo;

import articleManager.article.dto.ArticleDto;
import articleManager.utils.AMUtils;
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
public class ArticleVO {
    private Long id;
    private String regDate;
    private String updateDate;
    private Long memberId;
    private String title;
    private String body;
    
    // extra__ : join column
    private String loginId;
    private String authLevel;
    private String name;
    private String nickname;
    private String cellphoneNum;
    private String email;
    private String memberDelStatus;
    private String memberDelDate;
    private String boardId;
    private String boardCode;
    private String boardName;
    private String boardDelStatus;
    private String boardDelDate;
    
    public static ArticleVO from(ArticleDto article) {
        return ArticleVO.builder()
            .id(article.getId())
            .regDate(AMUtils.dateFormat(article.getRegDate()))
            .updateDate(AMUtils.dateFormat(article.getUpdateDate()))
            .memberId(article.getMemberId())
            .title(article.getTitle())
            .body(article.getBody())
            .loginId(article.getLoginId())
            .authLevel(article.getAuthLevel())
            .name(article.getName())
            .nickname(article.getNickname())
            .cellphoneNum(article.getCellphoneNum())
            .email(article.getEmail())
            .memberDelStatus(article.getMemberDelStatus())
            .memberDelDate(article.getMemberDelDate())
            .boardId(article.getBoardId())
            .boardCode(article.getBoardCode())
            .boardName(article.getBoardName())
            .boardDelStatus(article.getBoardDelStatus())
            .boardDelDate(article.getBoardDelDate())
            .build();
    }
}
























