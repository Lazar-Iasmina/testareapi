package com.example.proiectcolectiv.controller;


import com.example.proiectcolectiv.model.Badges;
import com.example.proiectcolectiv.repository.BadgesRepository;
import com.example.proiectcolectiv.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("")
public class BadgesController {
    @Autowired
    private BadgesRepository badgesRepository;
}
