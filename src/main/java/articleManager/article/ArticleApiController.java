package articleManager.article;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import articleManager.article.dto.ArticleDto;
import articleManager.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    @GetMapping("/api/article/list")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        List<ArticleDto> articleList = articleService.getArticleList();
        return ResponseEntity.status(HttpStatus.OK).body(articleList);
    }

    @GetMapping("/api/article")
    public ResponseEntity<ArticleDto> getArticleById(@RequestParam Long id) {
        log.info("id: {}", id);
        ArticleDto article = articleService.findArticleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

}
