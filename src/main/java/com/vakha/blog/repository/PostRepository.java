package com.vakha.blog.repository;

import com.vakha.blog.model.domain.Post;
import com.vakha.blog.model.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-01-27
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUserOrderByCreatedDateDesc(User user, Pageable pageable);

    Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);

    void delete(Post post);

    Page<Post> findByCategoryIdOrderByCreatedDateDesc(Long id, Pageable pageable);

    Page<Post> findByCategoryNmOrderByCreatedDateDesc(String name, Pageable pageable);
}
