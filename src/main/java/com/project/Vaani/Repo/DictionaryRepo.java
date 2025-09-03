package com.project.Vaani.Repo;

import com.project.Vaani.Model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepo extends JpaRepository<Dictionary, Long> {

    // Your existing method
    List<Dictionary> findByTitleContainingIgnoreCase(String title);

    // Additional methods for better search functionality
    List<Dictionary> findByTitleIgnoreCase(String title);

    List<Dictionary> findByTitleStartingWithIgnoreCase(String title);

    // Custom query for more flexible search
    @Query("SELECT d FROM Dictionary d WHERE LOWER(d.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Dictionary> searchByTitleCustom(@Param("query") String query);
}