package edu.eiu.recipes.controller;

import edu.eiu.recipes.entity.Category;
import edu.eiu.recipes.entity.UnitOfMeasure;
import edu.eiu.recipes.repository.CategoryRepository;
import edu.eiu.recipes.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public IndexController(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(){
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescriptionIgnoreCase("teaspoon");
        Optional<Category> category = categoryRepository.findByNameIgnoreCase("American");
        return "index";
    }
}
