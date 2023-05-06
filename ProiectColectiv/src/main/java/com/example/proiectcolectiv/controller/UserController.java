package com.example.proiectcolectiv.controller;

import com.example.proiectcolectiv.model.*;
import com.example.proiectcolectiv.model.Eroare;
import com.example.proiectcolectiv.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BadgesRepository badgesRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping("/getStefan")
    @Transactional
    public User getDummyUser(){
        User a = new User();
        a.setUid("1");
        a.setEmail("stefan@uvt.ro");
        return a;
    }

    @GetMapping("/saveIasmina")
    @Transactional
    public User saveIasminaToDb(){


        User a = new User();
        a.setUid( "3");
        a.setEmail("iasmina@uvt.ro");
       // userRepository.save(a);
        return userRepository.save(a);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllUsers")
    @Transactional
    public List<User> getAllUsers(){

        return  userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{id}")
    @Transactional
    public Object getDummyUserPremium(@PathVariable("id") String id) {
        try {
            UserPremium a = new UserPremium();
            User user = userRepository.getUserID(id);
            a.setUid(user.getUid());
            a.setPhotoURL(user.getPhotoURL());
            UserPremium.Stats stats = new UserPremium.Stats(postRepository.getUserQuestions(id), postRepository.getUserLikes(id), postRepository.getUserDislikes(id));
            a.setStats(stats);
            List<Badges> b = badgesRepository.getUserBadges(id);
            Map<String, List<String>> m = new HashMap<>();
            for (Badges i : b) {
                if (m.containsKey(i.getBadgeType())) {
                    List<String> l = new ArrayList<>();
                    l.addAll(m.get(i.getBadgeType()));
                    l.add(i.getIdBadges());
                    m.put(i.getBadgeType(), l);

                } else {
                    List<String> list = new ArrayList<>();
                    list.add(i.getIdBadges());
                    m.put(i.getBadgeType(), list);
                }
            }
            a.setBadges(m);

            List<Question> questions = new ArrayList<>();
            //questions.setQuestionID();
            List<Post> post = postRepository.getPostbyID(id);
            //System.out.println("A");
            for (Post i : post) {
                Question q = new Question();
                q.setQuestionID(i.getPostID());
                User1 u = new User1();
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
                questions.add(q);
            }
            a.setQuestions(questions);
            return a;
        } catch (Exception e) {
            //HttpStatus.NOT_FOUND, "entity not found"
            ResponseEntity.status(HttpStatus.NOT_FOUND);
            return new Eroare();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users")
    @Transactional
    public Object createUser(@RequestBody User newUser){
        //System.out.println("am intrat in POST");
        User a = new User(newUser.getUid(),newUser.getDisplayName(),newUser.getPhotoURL(),null,null,newUser.getJoinDate(),null);
       // System.out.println("Acum se salveaza");
        userRepository.saveUser(a.getUid(),a.getDisplayName(),a.getPhotoURL(),a.getJoinDate());
        ResponseEntity.status(HttpStatus.CREATED);
        return new ReturnMessage("HTTP status will be  CREATED");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/users/{uid}")
    @Transactional
    public Object alterUser(@RequestBody User alterUser){
        User a=new User(alterUser.getUid(),alterUser.getDisplayName(),alterUser.getPhotoURL(),alterUser.getEmail(),alterUser.getPassword(),alterUser.getJoinDate(),alterUser.getPosition());
        userRepository.saveUser(a.getUid(),a.getDisplayName(),a.getPhotoURL(),a.getJoinDate());
        ResponseEntity.status(HttpStatus.OK);
        return new ReturnMessage("HTTP status will be  PATCHED");

    }



}
