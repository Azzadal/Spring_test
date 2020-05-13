package com.springapp.Repos;

import com.springapp.model.Artefact;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ArtefactRepository extends CrudRepository<Artefact, UUID> {
    Iterable<Artefact> findByCategory(String category);
    Iterable<Artefact> findByUserId(String userId);
    Iterable<Artefact> findByDescription(String description);

    Iterable<Artefact> findByCategoryOrderByDate(String category);


}
