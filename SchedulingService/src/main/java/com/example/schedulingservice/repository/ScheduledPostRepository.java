package com.example.schedulingservice.repository;


import com.example.schedulingservice.model.ScheduledPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledPostRepository extends JpaRepository<ScheduledPost, Long> {
}
