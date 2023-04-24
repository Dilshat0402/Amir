package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Post;
import com.amir.Diploma.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post apartment) {
        return postRepository.save(apartment);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
