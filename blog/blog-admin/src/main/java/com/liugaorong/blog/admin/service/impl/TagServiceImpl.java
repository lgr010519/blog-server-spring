package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.TagMapper;
import com.liugaorong.blog.admin.service.TagService;
import com.liugaorong.blog.admin.vo.tags.TagsVo;
import com.liugaorong.blog.model.entity.Tags;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
  public Page<TagsVo> getList(Page<Tags> page, Page<TagsVo> pageVo, String name, Integer status) {
    
    LambdaQueryWrapper<Tags> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.like(name != null, Tags::getName, name)
      .eq(status != null, Tags::getStatus, status);
    Page<Tags> result = page(page, queryWrapper);
    
    List<TagsVo> tagsVoList = new ArrayList<>();
    
    for (Tags tags :
      result.getRecords()) {
      TagsVo tagsVo = new TagsVo();
      BeanUtils.copyProperties(tags, tagsVo);
      Long count = mapper.selectArticleCount(tags.getId());
      tagsVo.setArticleNum(count);
      tagsVoList.add(tagsVo);
    }
    
    pageVo.setRecords(tagsVoList);
    
    return pageVo;
  }
}




