package org.socialmediaintegrationservice.controller;

import org.socialmediaintegrationservice.model.Post;
import org.socialmediaintegrationservice.model.SocialAccount;
import org.socialmediaintegrationservice.service.PostServiceImpl;
import org.socialmediaintegrationservice.service.SocialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social")
public class SocialMediaController {

    @Autowired
    private SocialAccountService socialAccountService;

    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/connectAccount")
    public SocialAccount connectAccount(@RequestBody SocialAccount account) {
        return socialAccountService.connectAccount(account);
    }

    @GetMapping("/getAccounts")
    public List<SocialAccount> getAllAccounts() {
        return socialAccountService.getAllAccounts();
    }

    @GetMapping("/getPosts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/createPost")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
