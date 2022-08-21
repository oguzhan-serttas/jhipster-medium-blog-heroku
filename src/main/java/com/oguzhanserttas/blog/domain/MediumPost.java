package com.oguzhanserttas.blog.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MediumPost {

    private String title;
    private String contentFormat;
    private String content;
    private String publishStatus;
}
