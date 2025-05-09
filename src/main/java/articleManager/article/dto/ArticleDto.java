package articleManager.article.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String title;
    private String content;
}
