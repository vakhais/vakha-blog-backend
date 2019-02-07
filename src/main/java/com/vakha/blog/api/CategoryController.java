package com.vakha.blog.api;

import com.vakha.blog.model.domain.Category;
import com.vakha.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-02-01
 */
@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/api/categorys")
    public ResponseEntity<?> getCategoryList() {
        List<Category> list = categoryRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
