package com.project.Vaani.Service;

import com.project.Vaani.Model.Module;
import com.project.Vaani.Repo.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository repo;

    public List<Module> getAllModules() {
        return repo.findAll();
    }

    public Module getModuleById(Long id){
        return repo.findById(id)
        .orElseThrow(()->new RuntimeException("Module not found with id " + id));
    }


}


