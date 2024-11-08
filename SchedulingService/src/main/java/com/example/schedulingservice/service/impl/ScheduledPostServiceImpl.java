package com.example.schedulingservice.service.impl;


import com.example.schedulingservice.model.ScheduledPost;
import com.example.schedulingservice.repository.ScheduledPostRepository;
import com.example.schedulingservice.service.ScheduledPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduledPostServiceImpl implements ScheduledPostService {

    @Autowired
    private ScheduledPostRepository scheduledPostRepository;

    @Override
    public ScheduledPost addScheduledPost(ScheduledPost post) {
        // Add any business logic if needed
        return scheduledPostRepository.save(post);
    }

    @Override
    public List<ScheduledPost> getScheduledPosts() {
        return scheduledPostRepository.findAll();
    }
}
