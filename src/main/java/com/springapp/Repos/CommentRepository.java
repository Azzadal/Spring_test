package com.springapp.Repos;

import com.springapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Object> {

}
