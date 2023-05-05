package com.example.proiectcolectiv.repository;
import com.example.proiectcolectiv.model.Badges;
import com.example.proiectcolectiv.model.Label;
import com.example.proiectcolectiv.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, String> {
    @Query(value = "select labelID  from label where postID = :uid",nativeQuery = true)
    public List<String> getPostbyID(@Param("uid") int id);

}
