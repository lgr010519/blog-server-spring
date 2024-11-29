package com.liugaorong.blog.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liugaorong.blog.admin.dto.article.ArticleDto;
import com.liugaorong.blog.admin.dto.article.ArticleQueryDto;
import com.liugaorong.blog.admin.vo.article.ArticleVo;
import com.liugaorong.blog.model.entity.Article;

/**
 * @author admin
 * @description 针对表【article】的数据库操作Service
 * @createDate 2024-11-27 11:05:17
 */
public interface ArticleService extends IService<Article> {
  
  void saveOrUpdateArticle(ArticleDto articleDto);
  
  Page<ArticleVo> getList(Page<ArticleVo> page, ArticleQueryDto queryDto);
}
