package com.liugaorong.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.pojo.Headline;
import com.liugaorong.blogserver.service.HeadlineService;
import com.liugaorong.blogserver.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-04-25 17:07:38
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




