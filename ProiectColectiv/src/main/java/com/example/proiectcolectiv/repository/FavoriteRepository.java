package com.example.proiectcolectiv.repository;


import com.example.proiectcolectiv.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
