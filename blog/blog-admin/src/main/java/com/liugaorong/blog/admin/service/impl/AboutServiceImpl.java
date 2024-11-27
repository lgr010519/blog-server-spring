package com.liugaorong.blog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liugaorong.blog.admin.About;
import com.liugaorong.blog.admin.dto.about.AboutDto;
import com.liugaorong.blog.admin.mapper.AboutMapper;
import com.liugaorong.blog.admin.service.AboutService;
import com.liugaorong.blog.admin.vo.about.AboutImgVo;
import com.liugaorong.blog.admin.vo.about.AboutVo;
import com.liugaorong.blog.admin.vo.about.TagCloudVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @description 针对表【about】的数据库操作Service实现
 * @createDate 2024-11-25 11:49:18
 */
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About>
  implements AboutService {
  
  @Autowired
  private AboutMapper aboutMapper;
  
  @Override
  public List<AboutVo> getList() {
    
    List<About> aboutList = aboutMapper.selectAll();
    
    List<AboutVo> aboutVoList = new ArrayList<>();
    
    for (About about :
      aboutList) {
      List<TagCloudVo> tagCloudList = aboutMapper.selectTagCloudList(about.getId());
      List<AboutImgVo> aboutImgList = aboutMapper.selectAboutImgList(about.getId());
      
      AboutVo aboutVo = new AboutVo();
      
      BeanUtils.copyProperties(about, aboutVo);
      aboutVo.setTagCloudList(tagCloudList);
      aboutVo.setAboutImgList(aboutImgList);
      
      aboutVoList.add(aboutVo);
    }
    
    return aboutVoList;
  }
  
  @Override
  public void saveOrUpdateAbout(AboutDto aboutDto) {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String updateTime = sdf.format(new Date());
    aboutMapper.updateAboutById(aboutDto.getId(), aboutDto.getDescription(), updateTime);
    
    aboutMapper.deleteAboutImg(aboutDto.getId());
    
    aboutMapper.deleteTagCloud(aboutDto.getId());
    
    for (String imgUrl :
      aboutDto.getAboutImgList()) {
      aboutMapper.insertAboutImg(aboutDto.getId(), imgUrl);
    }
    
    for (String name :
      aboutDto.getTagCloudList()) {
      aboutMapper.insertTagCloud(aboutDto.getId(), name);
    }
  }
}




