package com.springapp.controller;

import com.springapp.Repos.CommentRepository;
import com.springapp.model.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentRestController extends AbstractRestController<Comment, CommentRepository> {
    public CommentRestController(CommentRepository repo) {
        super(repo);
    }
}
