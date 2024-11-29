package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.dto.article.ArticleDto;
import com.liugaorong.blog.admin.dto.article.ArticleQueryDto;
import com.liugaorong.blog.admin.mapper.ArticleMapper;
import com.liugaorong.blog.admin.service.ArticleService;
import com.liugaorong.blog.admin.vo.article.ArticleVo;
import com.liugaorong.blog.model.entity.Article;
import com.liugaorong.blog.model.entity.Category;
import com.liugaorong.blog.model.entity.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author admin
 * @description 针对表【article】的数据库操作Service实现
 * @createDate 2024-11-27 11:05:17
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
  implements ArticleService {
  
  @Autowired
  private ArticleMapper mapper;
  
  @Override
  public void saveOrUpdateArticle(ArticleDto articleDto) {
    
    if (articleDto.getId() == null) {
      mapper.insertArticle(articleDto);
    } else {
      mapper.updateArticle(articleDto);
      mapper.deleteOldTagIdByArticleId(articleDto.getId());
    }
    
    Date createTime = new Date();
    
    for (Long tagId :
      articleDto.getTagIdList()) {
      mapper.insertArticleIdAndTagId(articleDto.getId(), tagId, createTime);
    }
  }
  
  @Override
  public Page<ArticleVo> getList(Page<ArticleVo> page, ArticleQueryDto queryDto) {
    
    Page<ArticleVo> articleVoPage = mapper.selectArticlePage(page, queryDto);
    
    for (ArticleVo articleVo :
      articleVoPage.getRecords()) {
      Category category = mapper.selectCategoryName(articleVo.getCategoryId());
      articleVo.setCategoryName(category.getName());
      
      Tags tags = mapper.selectTagName(articleVo.getId());
      articleVo.setTags(tags);
    }
    
    return null;
  }
}




