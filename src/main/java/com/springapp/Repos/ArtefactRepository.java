package com.springapp.Repos;

import com.springapp.model.Artefact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.UUID;

public interface ArtefactRepository extends JpaRepository<Artefact, UUID> {


    Iterable<Artefact> findByCategory(String category);
    Iterable<Artefact> findByUserId(String userId);
    Iterable<Artefact> findByDescription(String description);

    Iterable<Artefact> findByCategoryOrderByDateAsc(Date date);
    Iterable<Artefact> findByCategoryOrderByCategoryAsc(String category);
    Iterable<Artefact> findByCategoryOrderByUserIdAsc(String userId);


}
