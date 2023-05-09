package com.example.proiectcolectiv.repository;


import com.example.proiectcolectiv.model.Comment;
import com.example.proiectcolectiv.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select *  from comment where parentPostID = :uid",nativeQuery = true)
    public List<Comment> getPostbyID(@Param("uid") Integer id);
    @Query(value = "select max(commentID)  from comment ",nativeQuery = true)
    public Integer getCommentID();
    @Modifying
    @Transactional
    @Query(value = "insert into comment (commentID,userID,parentPostID,parentCommID,content,likes,dislikes,date,commentTitle,commentCode) " +
            "values(:commentID,:userID,:parentPostID,:parentCommID,:content,:likes,:dislikes,:date,:commentTitle,:commentCode) ",nativeQuery = true)
    public void saveComment1(@Param("commentID") Integer commentID, @Param("userID") String userID, @Param("parentPostID") Integer parentPostID, @Param("parentCommID") Integer parentCommID, @Param("content") String content, @Param("likes") Integer likes, @Param("dislikes") Integer dislikes,@Param("date") Date date,@Param("commentTitle") String commentTitle,@Param("commentCode") String commentCode);


}
