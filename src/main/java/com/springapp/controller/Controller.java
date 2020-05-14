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

    //тестовые запросы

    @PostMapping(value = "/arr/{category},{userId}")
    public void test(@PathVariable ("category") String category, @PathVariable ("userId") String userid){
        artefact.setCategory(category);
        artefact.setUserId(userid);
        repository.save(artefact);
    }


    @PostMapping(value = "/com/{content},{userId}")
    public void test_com(@PathVariable ("content") String content, @PathVariable ("userId") String userid){
        comment.setArtefact(artefact);
        comment.setContent(content);
        comment.setUserId(userid);
        commentRepository.save(comment);
    }

    @GetMapping("/com")
    public @ResponseBody Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }
    @GetMapping("/arr")
    public @ResponseBody Iterable<Artefact> getArtefacts() {
        return repository.findAll();
    }

}