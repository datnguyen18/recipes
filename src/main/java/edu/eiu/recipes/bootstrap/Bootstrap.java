package edu.eiu.recipes.bootstrap;

import edu.eiu.recipes.entity.*;
import edu.eiu.recipes.repository.CategoryRepository;
import edu.eiu.recipes.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public Bootstrap(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initGuacamole();
    }

    private void initGuacamole() {
        String direction= "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "";
        Recipe guacamole = new Recipe("Perfect Guacamole",10,null,"2-4","Simply Recipes",
                "http://www.simplyrecipes.com/recipes/perfect_guacamole/",direction, Difficulty.EASY);
        Notes notes = new Notes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n" +
                "\n" +
                "\n" );
        guacamole.setNotes(notes);

        Ingredient avocados = new Ingredient("ripe avocados", new BigDecimal(2));
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByDescriptionIgnoreCase("each");
        if(!eachOptional.isPresent()){
            throw new RuntimeException("Unit of measure 'each' not found");
        }
        avocados.setUnitOfMeasure(eachOptional.get());
        System.out.print("aa");
    }

    private void initUnitOfMeasures() {
//        unitOfMeasureRepository.saveAll(Arrays.asList(
//                new UnitOfMeasure("Teaspoon"),
//                new UnitOfMeasure("Tablespoon"),
//                new UnitOfMeasure("Cup"),
//                new UnitOfMeasure("Pinch"),
//                new UnitOfMeasure("Ounce")
//        ));
    }

}
