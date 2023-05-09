package com.example.proiectcolectiv.controller;

import com.example.proiectcolectiv.exceptions.UserUnknownException;
import com.example.proiectcolectiv.model.*;
import com.example.proiectcolectiv.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BadgesRepository badgesRepository;
    @Autowired
    private LabelRepository labelRepository;



    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/answers/{id}")
    @Transactional
    public Object postComment(@PathVariable("id") Integer id,@RequestBody Answer2 answer){
        try {
            Comment c = new Comment();
            System.out.println(answer.toString() + "\n" + 45 + "\n");
            c.setCommentID(commentRepository.getCommentID() + 1);
            if (answer.getUser().getUid() == null) {
                c.setUserID("");
            } else {
                c.setUserID(answer.getUser().getUid());
            }
            c.setParentPostID(id);
            c.setLikes(0);
            c.setDislikes(0);
            c.setDate(null);
            if (answer.getAnswerTitle() == null) {
                c.setCommentTitle("");
            } else {
                c.setCommentTitle(answer.getAnswerTitle());
            }
            if (answer.getAnswerDetails() == null) {
                c.setContent("");
            } else {
                c.setContent(answer.getAnswerDetails());
            }
            if (answer.getAnswerTitle() == null) {
                c.setCommentTitle("");
            } else {
                c.setCommentTitle(answer.getAnswerTitle());
            }
            if (answer.getCode() == null) {
                c.setCommentCode("");
            } else {
                c.setCommentCode(answer.getCode());
            }
            if (userRepository.getUID(c.getUserID()) == null) {
                throw new UserUnknownException();
            }
            else {
                commentRepository.saveComment1(c.getCommentID(), c.getUserID(), c.getParentPostID(), c.getParentCommID(), c.getContent(), c.getLikes(), c.getDislikes(), c.getDate(), c.getCommentTitle(), c.getCommentCode());
                return new ResponseEntity<>(new ReturnMessage("HTTP status will be CREATED"), HttpStatus.CREATED);
            }
        }catch(UserUnknownException e){
            return new ResponseEntity<>(new Eroare("Unkwnown user"), HttpStatus.NOT_ACCEPTABLE);
        }


    }
}
