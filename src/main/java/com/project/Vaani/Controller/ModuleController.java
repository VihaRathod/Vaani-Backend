package com.project.Vaani.Controller;

import org.springframework.security.core.Authentication;
import com.project.Vaani.Model.Module;
import com.project.Vaani.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/modules")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ModuleController {

    @Autowired
    private ModuleService service;

    @GetMapping
    public List<Module> getModules() {
        return service.getAllModules();
    }

    @GetMapping("/{id}")
    public Module getModuleById(@PathVariable Long id){
        return service.getModuleById(id);
    }

    @GetMapping("/vaani/modules")
    public String getModules(Authentication authentication) {
        String firebaseUid = (String) authentication.getPrincipal();
        return "Modules for user: " + firebaseUid;
    }

}



