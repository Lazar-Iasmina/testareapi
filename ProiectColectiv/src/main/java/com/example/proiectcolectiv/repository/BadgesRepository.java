package com.example.proiectcolectiv.repository;

import com.example.proiectcolectiv.model.Badges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgesRepository  extends JpaRepository<Badges, Integer> {
    @Query(value = "select *  from badges where userID = :uid",nativeQuery = true)
    public List<Badges> getUserBadges(@Param("uid") String id);
}
