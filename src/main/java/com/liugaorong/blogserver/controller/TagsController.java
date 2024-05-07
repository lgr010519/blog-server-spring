package com.liugaorong.blogserver.controller;

import com.liugaorong.blogserver.pojo.Tags;
import com.liugaorong.blogserver.service.TagsService;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tags")
@CrossOrigin
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @PostMapping
    public Result add(@RequestBody Tags tags) {
        return tagsService.add(tags);
    }

    @GetMapping
    public Result get(@RequestParam int pageNum, int pageSize, String name) {
        return tagsService.get(pageNum, pageSize, name);
    }

    @PutMapping
    public Result update(@RequestBody Tags tags) {
        return tagsService.update(tags);
    }

    @PutMapping("/status")
    public Result updateStatus(@RequestBody Tags tags) {
        return tagsService.updateStatus(tags);
    }

    @DeleteMapping("/{id}")
    public Result remove(@PathVariable int id) {
        return tagsService.remove(id);
    }
}
