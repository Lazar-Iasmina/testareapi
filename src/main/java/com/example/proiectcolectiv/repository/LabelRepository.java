package com.example.proiectcolectiv.repository;
import com.example.proiectcolectiv.model.Badges;
import com.example.proiectcolectiv.model.Label;
import com.example.proiectcolectiv.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, String> {
    @Query(value = "select labelID  from label where postID = :uid",nativeQuery = true)
    public List<String> getPostbyID(@Param("uid") int id);
    @Modifying
    @Query(value = "insert into label (labelID,postID) values(:labelID,:postID) on duplicate Key update labelID=:labelID,postID=:postID",nativeQuery = true)
    public void saveLabel(@Param("labelID") String labelID, @Param("postID") Integer postID);
    @Modifying
    @Query(value = "delete   from label where postID = :uid",nativeQuery = true)
    public void deleteQuestion(@Param("uid") Integer id);

}
