package com.example.schedulingservice.service;


import com.example.schedulingservice.model.ScheduledPost;
import java.util.List;

public interface ScheduledPostService {
    ScheduledPost addScheduledPost(ScheduledPost post);
    List<ScheduledPost> getScheduledPosts();
}

