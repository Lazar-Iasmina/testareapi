package com.example.proiectcolectiv.repository;



import com.example.proiectcolectiv.model.Post;
import com.example.proiectcolectiv.model.UserPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select count(postID) AS \"questions\" from post where userID = :uid",nativeQuery = true)
    public Integer getUserQuestions(@Param("uid") String id);
    @Query(value = "select sum(likes) AS \"likes\" from post where userID = :uid",nativeQuery = true)
    public Integer getUserLikes(@Param("uid") String id);

    @Query(value = "select sum(dislikes) AS \"likes\" from post where userID = :uid",nativeQuery = true)
    public Integer getUserDislikes(@Param("uid") String id);

    @Query(value = "select *  from post where userID = :uid",nativeQuery = true)
    public List<Post> getPostbyID(@Param("uid") String id);
    @Query(value = "select *  from post order by date desc",nativeQuery = true)
    public List<Post> getQuestion();
    @Query(value = "select distinct(category)  from post ",nativeQuery = true)
    public List<String> getCategory();


}
