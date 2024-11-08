package com.example.schedulingservice.controller;

import com.example.schedulingservice.model.ScheduledPost;
import com.example.schedulingservice.service.ScheduledPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class SchedulingController {

    @Autowired
    private ScheduledPostService scheduledPostService;

    @PostMapping("/addScheduledPost")
    public ScheduledPost addScheduledPost(@RequestBody ScheduledPost post) {
        return scheduledPostService.addScheduledPost(post);
    }

    @GetMapping("/getScheduledPosts")
    public List<ScheduledPost> getScheduledPosts() {
        return scheduledPostService.getScheduledPosts();
    }

}

