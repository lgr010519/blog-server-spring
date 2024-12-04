package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.TagMapper;
import com.liugaorong.blog.admin.service.TagService;
import com.liugaorong.blog.admin.vo.tags.TagsVo;
import com.liugaorong.blog.model.entity.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【tag】的数据库操作Service实现
 * @createDate 2024-11-20 11:19:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tags>
  implements TagService {
  
  @Autowired
  private TagMapper mapper;
  
  @Override
  public Page<TagsVo> getList(Page<TagsVo> page, String name, Integer status) {
    
    Page<TagsVo> tagsVoPage = mapper.selectTagsPage(page, name, status);
    for (TagsVo tagsVo :
      tagsVoPage.getRecords()) {
      Long articleNum = mapper.selectArticleCount(tagsVo.getId());
      tagsVo.setArticleNum(articleNum);
    }
    
    return tagsVoPage;
  }
}




