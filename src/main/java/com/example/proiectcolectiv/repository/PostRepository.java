package com.example.proiectcolectiv.repository;



import com.example.proiectcolectiv.model.Post;
import com.example.proiectcolectiv.model.UserPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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
    @Query(value = "select *  from post order by date desc, postID desc",nativeQuery = true)
    public List<Post> getQuestion();
    @Query(value = "select distinct(category)  from post ",nativeQuery = true)
    public List<String> getCategory();
    @Query(value = "select *  from post where postID = :uid",nativeQuery = true)
    public Post getID(@Param("uid") Integer id);
    @Modifying
    @Query(value = "insert into post (postID,userID,questionTitle,questionContent,likes,dislikes,date,category,questionCode) values(:postID,:userID,:questionTitle,:questionContent,:likes,:dislikes,:date,:category,:questionCode) on duplicate Key update postID=:postID,userID=:userID,questionTitle=:questionTitle,questionContent=:questionContent,likes=:likes,dislikes=:dislikes,date=:date,category=:category,questionCode=:questionCode",nativeQuery = true)
    public void saveQuestion(@Param("postID") Integer postID,@Param("userID") String userID,@Param("questionTitle") String questionTitle,@Param("questionContent") String questionContent,@Param("likes") Integer likes,@Param("dislikes") Integer dislikes,@Param("date") Date date,@Param("category") String category,@Param("questionCode") String questionCode);
    @Modifying
    @Query(value = "delete   from post where postID = :uid",nativeQuery = true)
    public void deleteQuestion(@Param("uid") Integer id);
    @Query(value = "select max(postID) from post",nativeQuery = true)
    public Integer getMaxPost();


}
