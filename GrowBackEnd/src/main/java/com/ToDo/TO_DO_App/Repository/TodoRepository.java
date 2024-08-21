package com.ToDo.TO_DO_App.Repository;

import com.ToDo.TO_DO_App.Models.ToDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDO, Long> {

//    @Query("SELECT t FROM Todo t ORDER BY t.createdAt DESC")
    List<ToDO> findAllByOrderByCreatedAtDesc();
}
