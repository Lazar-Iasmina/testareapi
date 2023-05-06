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
import java.util.NoSuchElementException;

@RestController
@RequestMapping("")
public class PostController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private PostRepository postRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions/{start}/{end}")
    @Transactional
    public Object getPost(@PathVariable("start") Integer start, @PathVariable("end") Integer end) {
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
            if(result.isEmpty()){
                throw  new NoSuchElementException("Nu-i element") ;
            }
            List<Object> l=new ArrayList<>();
            l.addAll(result);
            JsonFormat x=new JsonFormat(l);
            return x;

        } catch (Exception e) {
           ResponseEntity.status(HttpStatus.NOT_FOUND);
           return new Eroare();
        }

    }



    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/questions")
    @Transactional
    public Object createQuestion(@RequestBody QuestionPremium newPost){
        //System.out.println("am intrat in POST");
       // User a = new User(newUser.getUid(),newUser.getDisplayName(),newUser.getPhotoURL(),null,null,newUser.getJoinDate(),null);
        // System.out.println("Acum se salveaza");
      //  Post p=new Post(newPost.getQuestionID(),newPost.getUser().getUid(),newPost.getQuestionTitle(),newPost.getQuestionContent(),newPost.getLikes(),newPost.getDislikes(),newPost.getDate(),newPost.getCategory(),newPost.getCode());
         postRepository.saveQuestion(newPost.getQuestionID(),newPost.getUser().getUid(),newPost.getQuestionTitle(),newPost.getQuestionContent(),newPost.getLikes(),newPost.getDislikes(),newPost.getDate(),newPost.getCategory(),newPost.getCode());
         ResponseEntity.status(HttpStatus.CREATED);
         return new ReturnMessage("HTTP status will be  CREATED");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/questions/{id}")
    @Transactional
    public Object deleteQuestion(@PathVariable ("id") Integer id){
        postRepository.deleteQuestion(id);
        ResponseEntity.status(HttpStatus.OK);
        return new ReturnMessage("HTTP status will be  DELETED");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions/{id}")
    @Transactional
    public Object showQuestion(@PathVariable ("id") Integer id){
        try {
            Post p = postRepository.getID(id);
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
            if(q==null){
                throw new NoSuchElementException("Nu i element");
            }
            return q;
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Eroare());

        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/categories")
    @Transactional
    public Object getCategories(){
        try {
            List<String> result = new ArrayList<>();
            result = postRepository.getCategory();
            if (result.isEmpty()) {
                throw new NoSuchElementException("Nu-i element");
            }
            List<Object> l = new ArrayList<>();
            l.addAll(result);
            JsonFormat d = new JsonFormat(l);
            return d;
        }
        catch(Exception e){
            ResponseEntity.status(HttpStatus.NOT_FOUND);
            return new Eroare();
        }

    }

}
