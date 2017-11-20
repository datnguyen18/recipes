package edu.eiu.recipes.repository;

import edu.eiu.recipes.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
