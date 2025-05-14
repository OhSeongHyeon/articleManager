package articleManager.article.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
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
}
