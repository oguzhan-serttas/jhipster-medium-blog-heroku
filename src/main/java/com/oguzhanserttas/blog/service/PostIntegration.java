package com.oguzhanserttas.blog.service;

import com.oguzhanserttas.blog.domain.Post;

public interface PostIntegration {
    void sendPost(Post post);
}
