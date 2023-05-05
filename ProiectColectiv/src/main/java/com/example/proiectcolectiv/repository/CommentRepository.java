package com.example.proiectcolectiv.repository;


import com.example.proiectcolectiv.model.Comment;
import com.example.proiectcolectiv.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select *  from comment where parentPostID = :uid",nativeQuery = true)
    public List<Comment> getPostbyID(@Param("uid") Integer id);

}
