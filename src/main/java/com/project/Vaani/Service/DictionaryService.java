package com.project.Vaani.Service;

import com.project.Vaani.Model.Dictionary;
import com.project.Vaani.Repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DictionaryService {

    @Autowired
    private DictionaryRepo dictionaryRepository;

    public List<Dictionary> searchByTitle(String query) {
        return dictionaryRepository.findByTitleContainingIgnoreCase(query);
    }

    public List<Dictionary> getAllEntries() {
        return dictionaryRepository.findAll();
    }

    public Dictionary addEntry(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    // New method for getting a random word
    public Dictionary getRandomWord() {
        List<Dictionary> allEntries = dictionaryRepository.findAll();
        if (allEntries.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allEntries.size());
        return allEntries.get(randomIndex);
    }
}