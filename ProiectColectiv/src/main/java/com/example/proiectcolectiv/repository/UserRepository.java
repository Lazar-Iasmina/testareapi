package com.example.proiectcolectiv.repository;

import com.example.proiectcolectiv.model.Badges;
import com.example.proiectcolectiv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select photoURL  from user where userID = :uid",nativeQuery = true)
    public String getUserURL(@Param("uid") String id);
    @Query(value = "select displayName  from user where userID = :uid",nativeQuery = true)
    public String getUserDisplayName(@Param("uid") String id);
    @Query(value = "select *  from user where userID = :uid",nativeQuery = true)
    public User getUserID(@Param("uid") String id);
    @Modifying
    @Query(value = "insert into user (userID,displayName,photoURL,joinDate) values(:uid,:displayName,:photoURL,:joinDate) on duplicate Key update displayName=:displayName,photoURL=:photoURL,joinDate=:joinDate",nativeQuery = true)
    public void saveUser(@Param("uid") String uid,@Param("displayName") String displayName,@Param("photoURL") String photoURL,@Param("joinDate") Date joinDate);
}
