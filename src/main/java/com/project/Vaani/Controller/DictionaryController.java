package com.project.Vaani.Controller;

import com.project.Vaani.Model.Dictionary;
import com.project.Vaani.Service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary") // Added /vaani prefix to match your other endpoints
@CrossOrigin(origins = "http://localhost:5173")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    // Endpoint to get all dictionary entries
    @GetMapping
    public ResponseEntity<List<Dictionary>> getAll() {
        try {
            List<Dictionary> entries = dictionaryService.getAllEntries();
            return ResponseEntity.ok(entries);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Endpoint to search by word
    @GetMapping("/search")
    public ResponseEntity<List<Dictionary>> search(@RequestParam("query") String query) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<Dictionary> results = dictionaryService.searchByTitle(query.trim());
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Optional: Add new dictionary entry
    @PostMapping
    public ResponseEntity<Dictionary> addEntry(@RequestBody Dictionary dictionary) {
        try {
            Dictionary savedEntry = dictionaryService.addEntry(dictionary);
            return ResponseEntity.ok(savedEntry);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Get a random word for "Word of the Day"
    @GetMapping("/random")
    public ResponseEntity<Dictionary> getRandomWord() {
        try {
            Dictionary randomWord = dictionaryService.getRandomWord();
            if (randomWord != null) {
                return ResponseEntity.ok(randomWord);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}