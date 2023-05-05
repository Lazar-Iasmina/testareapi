package com.example.proiectcolectiv.controller;
import com.example.proiectcolectiv.model.*;
import com.example.proiectcolectiv.repository.CommentRepository;
import com.example.proiectcolectiv.repository.LabelRepository;
import com.example.proiectcolectiv.repository.PostRepository;
import com.example.proiectcolectiv.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LabelRepository labelRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions/{start}/{end}")
    @Transactional
    public List<QuestionPremium> getPost(@PathVariable("start") Integer start, @PathVariable("end") Integer end) {
        List<QuestionPremium> result = new ArrayList<>();
        try {
            List<Post> posts = postRepository.getQuestion();
          //  List<QuestionPremium> result = new ArrayList<>();
            Integer contor = 0;
            for (Post i : posts) {
                if (contor >= start && contor <= end) {
                    QuestionPremium q = new QuestionPremium();
                    q.setQuestionID(i.getPostID());
                    UserNewAdd u = new UserNewAdd();
                    u.setUid(i.getUserID());
                    u.setDisplayName(userRepository.getUserDisplayName(i.getUserID()));
                    u.setPhotoURL(userRepository.getUserURL(i.getUserID()));
                    q.setUser(u);
                    List<String> label = labelRepository.getPostbyID(i.getPostID());
                    q.setQuestionLabels(label);
                    q.setQuestionContent(i.getQuestionContent());
                    q.setQuestionTitle(i.getQuestionTitle());
                    q.setLikes(i.getLikes());
                    q.setDislikes(i.getDisikes());
                    q.setCategory(i.getCategory());
                    q.setCode(i.getQuestionCode());
                    List<Comment> comment = commentRepository.getPostbyID(i.getPostID());
                    List<Answer> answers = new ArrayList<>();
                    for (Comment c : comment) {
                        Answer answer = new Answer();
                        answer.setCode(c.getCommentCode());
                        User1 user1 = new User1();
                        user1.setPhotoURL(userRepository.getUserURL(c.getUserID()));
                        user1.setDisplayName(userRepository.getUserDisplayName(c.getUserID()));
                        answer.setUser(user1);
                        answer.setAnswerTitle(c.getCommentTitle());
                        answer.setAnswerDetails(c.getContent());
                        answers.add(answer);
                    }
                    q.setAnswers(answers);
                    result.add(q);

                }
                contor++;
                if (contor > end)
                    break;
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/questions")
    @Transactional
    public ResponseEntity<String> createQuestion(@RequestBody QuestionPremium newPost){
        //System.out.println("am intrat in POST");
       // User a = new User(newUser.getUid(),newUser.getDisplayName(),newUser.getPhotoURL(),null,null,newUser.getJoinDate(),null);
        // System.out.println("Acum se salveaza");
      //  Post p=new Post(newPost.getQuestionID(),newPost.getUser().getUid(),newPost.getQuestionTitle(),newPost.getQuestionContent(),newPost.getLikes(),newPost.getDislikes(),newPost.getDate(),newPost.getCategory(),newPost.getCode());
         postRepository.saveQuestion(newPost.getQuestionID(),newPost.getUser().getUid(),newPost.getQuestionTitle(),newPost.getQuestionContent(),newPost.getLikes(),newPost.getDislikes(),newPost.getDate(),newPost.getCategory(),newPost.getCode());
         return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/questions/{id}")
    @Transactional
    public ResponseEntity<String> deleteQuestion(@PathVariable ("id") Integer id){
        postRepository.deleteQuestion(id);
        return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be DELETED (CODE 200)\n");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions/{id}")
    @Transactional
    public QuestionPremium showQuestion(@PathVariable ("id") Integer id){
        Post p= postRepository.getID(id);
        Post i = p;
        QuestionPremium q = new QuestionPremium();
        q.setQuestionID(i.getPostID());
        UserNewAdd u = new UserNewAdd();
        u.setUid(i.getUserID());
        u.setDisplayName(userRepository.getUserDisplayName(i.getUserID()));
        u.setPhotoURL(userRepository.getUserURL(i.getUserID()));
        q.setUser(u);
        List<String> label = labelRepository.getPostbyID(i.getPostID());
        q.setQuestionLabels(label);
        q.setQuestionContent(i.getQuestionContent());
        q.setQuestionTitle(i.getQuestionTitle());
        q.setLikes(i.getLikes());
        q.setDislikes(i.getDisikes());
        q.setCategory(i.getCategory());
        q.setCode(i.getQuestionCode());
        List<Comment> comment = commentRepository.getPostbyID(i.getPostID());
        List<Answer> answers = new ArrayList<>();
        for (Comment c : comment) {
            Answer answer = new Answer();
            answer.setCode(c.getCommentCode());
            User1 user1 = new User1();
            user1.setPhotoURL(userRepository.getUserURL(c.getUserID()));
            user1.setDisplayName(userRepository.getUserDisplayName(c.getUserID()));
            answer.setUser(user1);
            answer.setAnswerTitle(c.getCommentTitle());
            answer.setAnswerDetails(c.getContent());
            answers.add(answer);
        }
        q.setAnswers(answers);

        return  q;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/categories")
    @Transactional
    public List<String> getCategories(){
        List<String> result=new ArrayList<>();
        result=postRepository.getCategory();
        return result;
    }

}
