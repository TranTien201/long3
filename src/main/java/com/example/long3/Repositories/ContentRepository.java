package com.example.long3.Repositories;

import com.example.long3.Model.Content;
import com.example.long3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {
    @Query(value = "SELECT u FROM Content u WHERE u.authorID = :authorID")
    List<Content> listAllContentByID(@Param("authorID") String authorID);
}
