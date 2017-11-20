package edu.eiu.recipes.repository;

import edu.eiu.recipes.entity.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
