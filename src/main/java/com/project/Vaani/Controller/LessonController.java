package com.project.Vaani.Controller;

import java.util.Date;
import com.project.Vaani.Model.Lesson;
import com.project.Vaani.Repo.LessonRepo;
import com.project.Vaani.Service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = "http://localhost:5173")
public class LessonController {

    @Autowired
    private LessonService lessonService;
    private LessonRepo repo;

    // Get one lesson by ID
    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    // Get lessons by module ID
    @GetMapping("/module/{moduleId}")
    public List<Lesson> getLessonsByModuleId(@PathVariable Long moduleId) {
        return lessonService.getLessonsByModuleId(moduleId);
    }
    // Add this method to your LessonsController.java file

    @PutMapping("/{lessonId}/complete")
    public ResponseEntity<?> completeLesson(@PathVariable Long lessonId) {
        try {
            Lesson lesson = lessonService.getLessonById(lessonId);
            if (lesson == null) {
                return ResponseEntity.notFound().build();
            }

            // Mark lesson as completed
            lesson.setCompleted(true);
            lesson.setCompletedAt(new Date());
            lessonService.saveLesson(lesson); // Or whatever your save method is called

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error completing lesson: " + e.getMessage());
        }
    }


}
