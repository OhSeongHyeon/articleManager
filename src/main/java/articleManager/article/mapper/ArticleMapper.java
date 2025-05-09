package articleManager.article.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import articleManager.article.dto.ArticleDto;

@Mapper
public interface ArticleMapper {

    List<ArticleDto> getArticleList();
    
    Optional<ArticleDto> findArticleById(long id);

}
