package br.com.institutogloria.institutoGloria.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutogloria.institutoGloria.models.ProjectsModel;
import br.com.institutogloria.institutoGloria.repositories.ProjectsRepository;

@RestController
@RequestMapping("/projetos")
public class ProjectsController {

    @Autowired
    private ProjectsRepository repository;


    
    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<ProjectsModel> getProjectsById(@RequestParam("id") Integer id){
    	
    	ProjectsModel project  = repository.findById(id).get();
    	
    	return new ResponseEntity<ProjectsModel>(project, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarNome")
    @ResponseBody
    public ResponseEntity<List<ProjectsModel>> getProjectsByName(@RequestParam("name") String name){
    	
    	List<ProjectsModel> project = repository.getProjectsByName(name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<ProjectsModel>>(project, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarTodos")
    @ResponseBody
    public Iterable<ProjectsModel> getAllProjects(){
    	return repository.findAll();
    }
    
    
    @GetMapping(path = "/selecionarPag/{pageNumber}")
    public Iterable<ProjectsModel> getProjectsPage(@PathVariable int pageNumber){
    	Pageable page = PageRequest.of(pageNumber, 20);
    	return repository.findAll(page);
    }
    
    
    
    @PostMapping("/salvar")
    public @ResponseBody ProjectsModel newCollaborator(@Valid
    		@RequestParam String title, 
    		@RequestParam String subtext, 
    		@RequestParam String text, 
    		@RequestParam String photoLink, 
    		@RequestParam String content) {
    	ProjectsModel project = new ProjectsModel(title, subtext, text, photoLink, content);
        repository.save(project);
        return project;
    }
    

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attProjects(@RequestBody ProjectsModel project) {
        
    	if(project.getId() == null) {
    		
    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
    	}
    	ProjectsModel prj = repository.save(project);
        
        return new ResponseEntity<ProjectsModel>(prj, HttpStatus.OK);
    }
    


    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Projeto deletado com sucesso", HttpStatus.OK);
    }
}
