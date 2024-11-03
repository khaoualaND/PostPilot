package org.socialmediaintegrationservice.service;

import org.socialmediaintegrationservice.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPosts();
}
