package com.project.Vaani.Service;

import com.project.Vaani.Model.Lesson;
import com.project.Vaani.Repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepo lessonRepo;

    public Lesson getLessonById(Long id){
        return lessonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id " + id));
    }

    public List<Lesson> getLessonsByModuleId(Long moduleId) {
        return lessonRepo.findByModuleId(moduleId);
    }
    public Lesson saveLesson(Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    // Alternative method name if you prefer
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepo.save(lesson);
    }
}
