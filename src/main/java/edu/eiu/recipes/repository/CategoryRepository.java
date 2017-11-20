package edu.eiu.recipes.repository;

import edu.eiu.recipes.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByNameIgnoreCase(String name);
}
