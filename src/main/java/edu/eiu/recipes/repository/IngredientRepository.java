package edu.eiu.recipes.repository;

import edu.eiu.recipes.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
