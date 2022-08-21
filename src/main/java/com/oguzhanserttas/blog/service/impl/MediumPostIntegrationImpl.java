package com.oguzhanserttas.blog.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.oguzhanserttas.blog.config.MediumProperties;
import com.oguzhanserttas.blog.domain.MediumPost;
import com.oguzhanserttas.blog.domain.Post;
import com.oguzhanserttas.blog.service.PostIntegration;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MediumPostIntegrationImpl implements PostIntegration {

    private final MediumProperties mediumProperties;
    private final RestTemplate restTemplate;

    public MediumPostIntegrationImpl(MediumProperties mediumProperties, RestTemplate restTemplate) {
        this.mediumProperties = mediumProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendPost(Post post) {
        try {
            final String mediumAccessToken = mediumProperties.getAccessToken();
            final HttpHeaders headersForUserIdRequest = new HttpHeaders();
            headersForUserIdRequest.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            final String urlForUserIdRequest = mediumProperties.getBaseUrl() + "/me?accessToken=" + mediumAccessToken;

            HttpEntity requestEntityForUserId = new HttpEntity<>(headersForUserIdRequest);
            ResponseEntity<JsonNode> response = restTemplate.exchange(
                urlForUserIdRequest,
                HttpMethod.GET,
                requestEntityForUserId,
                JsonNode.class
            );

            final String mediumUserId = response.getBody().get("data").get("id").asText();
            final String urlForMediumPost =
                mediumProperties.getBaseUrl() + "/users/" + mediumUserId + "/posts?accessToken=" + mediumAccessToken;

            final MediumPost mediumPost = MediumPost
                .builder()
                .content("<h1>" + post.getTitle() + "</h1><p>" + post.getContent() + "</p>")
                .title(post.getTitle())
                .contentFormat("html")
                .publishStatus("public")
                .build();

            final HttpHeaders headersForMediumPost = new HttpHeaders();
            headersForMediumPost.setContentType(MediaType.APPLICATION_JSON);
            headersForMediumPost.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            final HttpEntity<MediumPost> request = new HttpEntity<>(mediumPost, headersForMediumPost);
            restTemplate.postForEntity(urlForMediumPost, request, MediumPost.class);
        } catch (Exception ex) {
            System.err.println("Medium integration error: " + Arrays.toString(ex.getStackTrace()));
        }
    }
}
