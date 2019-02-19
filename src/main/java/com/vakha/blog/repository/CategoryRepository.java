package com.vakha.blog.repository;

import com.vakha.blog.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-02-01
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNm(String categoryNm);
}
