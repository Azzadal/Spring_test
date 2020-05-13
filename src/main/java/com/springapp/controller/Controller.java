package com.springapp.controller;

import com.springapp.Repos.ArtefactRepository;
import com.springapp.Repos.CommentRepository;
import com.springapp.model.Artefact;
import com.springapp.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class Controller {
    @Autowired
    private ArtefactRepository repository;
    @Autowired
    private CommentRepository commentRepository;
    private Artefact artefact = new Artefact();
    private Comment comment = new Comment();


    @GetMapping(value = "/")
    public String hello(){
        return "hello";
    }

    @PostMapping(value = "/arr/{category},{userId}")
    public void test(@PathVariable ("category") String category, @PathVariable ("userId") String userid){
        artefact.setCategory(category);
        artefact.setUserId(userid);
        repository.save(artefact);
    }

    @PostMapping(value = "/com/{content},{userId}")
    public void test_com(@PathVariable ("content") String content, @PathVariable ("userId") String userid){
        //artefact = repository.findById(03cae86c-db1a-4ac2-b71c-baf3f7a178e4);
        comment.setArtefact(artefact);
        comment.setContent(content);
        comment.setUserId(userid);
        commentRepository.save(comment);
    }

    @RequestMapping("/com")
    public @ResponseBody Iterable<Comment> greeting() {
        return commentRepository.findAll(Sort );
    }
    @RequestMapping("/arr")
    public @ResponseBody Iterable<Artefact> greeting1() {
        return repository.findAll();
    }

}