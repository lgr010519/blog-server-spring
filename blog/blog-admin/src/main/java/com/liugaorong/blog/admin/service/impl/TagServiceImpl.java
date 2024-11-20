package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.mapper.TagMapper;
import com.liugaorong.blog.admin.service.TagService;
import com.liugaorong.blog.model.entity.Tags;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【tag】的数据库操作Service实现
 * @createDate 2024-11-20 11:19:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tags>
  implements TagService {
  
}




