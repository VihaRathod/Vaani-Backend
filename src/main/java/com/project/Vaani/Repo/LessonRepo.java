package com.project.Vaani.Repo;

import com.project.Vaani.Model.Lesson;
import com.project.Vaani.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson,Long> {
    List<Lesson> findByModuleId(Long moduleId);
}
