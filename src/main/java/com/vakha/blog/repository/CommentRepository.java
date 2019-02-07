package com.vakha.blog.repository;

import com.vakha.blog.model.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-01-27
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
