package com.vakha.blog.model.dto;

import com.vakha.blog.model.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-01-27
 */
@Data
public class PostDto {

    private Long id;
    private String title;
    private String body;
    private Long userId;
    private Long categoryId;
    private String categoryNm;
    //private String userName;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public PostDto () {}

    public PostDto (Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.createdBy = post.getCreatedBy();
        this.createdDate = post.getCreatedDate();
        this.lastModifiedBy = post.getLastModifiedBy();
        this.lastModifiedDate = post.getLastModifiedDate();
        this.userId = post.getUser().getId();
        this.categoryId = post.getCategory().getId();
        this.categoryNm = post.getCategory().getNm();
        //this.userName = post.getUser().getUserName();
    }
}