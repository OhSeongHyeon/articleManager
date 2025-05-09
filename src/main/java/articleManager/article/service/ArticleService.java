package articleManager.article.service;

import java.util.List;

import org.springframework.stereotype.Service;

import articleManager.article.dto.ArticleDto;
import articleManager.article.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleMapper articleMapper;

    public List<ArticleDto> getArticleList() {
        return articleMapper.getArticleList();
    }

    public ArticleDto findArticleById(Long id) {
        return articleMapper.findArticleById(id).orElseGet(null);
    }

}
