package com.it_academyproject.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.it_academyproject.domains.Project;
import com.it_academyproject.exceptions.ResourceNotFoundException;
import com.it_academyproject.repositories.IterationRepository;
import com.it_academyproject.repositories.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	IterationRepository iterationRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/api/projects")
	public List<Map<String, Object>> getAllProjectsByIterations() {
		List<Map<String, Object>> projects = projectRepository.findAllByIterations();
		return projects;
	}

	@GetMapping("api/projects/{id}")
	Project one(@PathVariable Long id) {
	//
	return projectRepository.findById(id)

	.orElseThrow(() -> new ResourceNotFoundException("project not found "+ id));
	

	}
	
	@PostMapping("/api/projects")                                  
	public Project createProject(@Valid @RequestBody Project project) throws Exception {
		boolean isFound=false;
		List <Project> checkProject=  projectRepository.findAll();
		
		
		//foreach loop to check if the new project is already in the repository
		for (Project one : checkProject) {
			
			
			boolean isSame=false;
			
			if ((project.getName().equals(one.getName()) )) {
				isFound=true;
	
							
			}
		}
			
		//if the new project is found, an exception will be thrown.
		if (isFound) {
			throw new Exception("This project is already set up");
		}else{
			return projectRepository.save(project);
		}
	
	}
}	
