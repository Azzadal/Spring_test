package com.springapp.controller;

import com.springapp.Repos.ArtefactRepository;
import com.springapp.model.Artefact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artefact")
public class ArtefactRestController extends AbstractRestController<Artefact, ArtefactRepository> {
    public ArtefactRestController(ArtefactRepository repo) {
        super(repo);
    }

}
