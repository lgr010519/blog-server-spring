package com.liugaorong.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blogserver.pojo.Type;
import com.liugaorong.blogserver.service.TypeService;
import com.liugaorong.blogserver.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-04-25 17:07:38
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




