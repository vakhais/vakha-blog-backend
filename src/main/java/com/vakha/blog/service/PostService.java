package com.vakha.blog.service;

import com.vakha.blog.model.domain.Category;
import com.vakha.blog.model.domain.Post;
import com.vakha.blog.model.domain.User;
import com.vakha.blog.model.dto.PostDto;
import com.vakha.blog.repository.CategoryRepository;
import com.vakha.blog.repository.PostRepository;
import com.vakha.blog.repository.UserRepository;
import com.vakha.blog.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-01-27
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    public PostDto registerPost(PostDto postDto, UserPrincipal currentUser) {
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setBody(postDto.getBody());
        //newPost.setUser(new User(1L)); // temporary code

        // User set
        User user = userRepository.getOne(currentUser.getId());
        newPost.setUser(user);

        Category category = categoryRepository.getOne(postDto.getCategoryId());
        newPost.setCategory(category);
        System.out.println("AAAAAAAAAAAAAAAAAA:" + category.toString());

        return new PostDto(postRepository.save(newPost));
    }

    public Optional<PostDto> editPost(PostDto editPostDto) {
        return this.findForId(editPostDto.getId())
                .map(p -> {
                    p.setTitle(editPostDto.getTitle());
                    p.setBody(editPostDto.getBody());
                    return p;
                })
                .map(PostDto::new);
    }

//    public Page<Post> findByUserOrderedByCreatedDatePageable(User user, Pageable pageable) {
//        return postRepository.findByUserOrderByCreatedDateDesc(user, pageable);
//    }

    public Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    public void deletePost(Long id) {
        postRepository.findById(id).ifPresent(post -> {
            postRepository.delete(post);
        });
    }

    public Page<Post> findForCategoryIdOrderByCreatedDateDescPageable(Long id, Pageable pageable) {
        return postRepository.findByCategoryIdOrderByCreatedDateDesc(id, pageable);
    }

    public Page<Post> findForCategoryNmOrderByCreatedDateDescPageable(String name, Pageable pageable) {
        return postRepository.findByCategoryNmOrderByCreatedDateDesc(name, pageable);
    }
}