package com.liugaorong.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liugaorong.blog.admin.dto.article.ArticleDto;
import com.liugaorong.blog.admin.dto.article.ArticleQueryDto;
import com.liugaorong.blog.admin.vo.article.ArticleDetailVo;
import com.liugaorong.blog.admin.vo.article.ArticleVo;
import com.liugaorong.blog.model.entity.Article;
import com.liugaorong.blog.model.entity.Category;
import com.liugaorong.blog.model.entity.Tags;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @description 针对表【article】的数据库操作Mapper
 * @createDate 2024-11-27 11:05:17
 * @Entity com.liugaorong.blog.model.entity.Article
 */
public interface ArticleMapper extends BaseMapper<Article> {
  
  Long insertArticle(ArticleDto articleDto);
  
  void insertArticleIdAndTagId(Long articleId, Long tagId, Date createTime);
  
  void updateArticle(ArticleDto articleDto);
  
  void deleteOldTagIdByArticleId(Long articleId);
  
  Page<ArticleVo> selectArticlePage(Page<ArticleVo> page, ArticleQueryDto queryDto, List<Long> categoryIdList);
  
  Category selectCategoryName(Long categoryId);
  
  List<Tags> selectTagList(Long articleId);
  
  ArticleDetailVo selectArticleDetail(Long id);
  
  void updateCollectBatch(Integer isCollect);
}




