package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Post;
import com.amir.Diploma.models.User;
import com.amir.Diploma.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(new Post(0L, "NO TITLE", "NO CONTENT", new Timestamp(System.currentTimeMillis()), null, new User()));
    }
}
