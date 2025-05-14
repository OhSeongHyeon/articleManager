package articleManager.article;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import articleManager.article.dto.ArticleDto;
import articleManager.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    
    @GetMapping("/article/list")
    public String getArticles(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
//        List<ArticleDto> articleList = articleService.getArticleList();
//        model.addAttribute("articles", articleList);
        log.info("pageNum: {}, pageSize: {}", pageNum, pageSize);
        model.addAttribute("articles", null);
        return "/article/list";
    }
}
