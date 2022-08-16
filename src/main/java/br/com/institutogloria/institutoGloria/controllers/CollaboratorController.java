package br.com.institutogloria.institutoGloria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutogloria.institutoGloria.models.CollaboratorModel;
import br.com.institutogloria.institutoGloria.repositories.CollaboratorRepository;

@RestController
@RequestMapping("/colaboradores")
public class CollaboratorController {

    @Autowired
    private CollaboratorRepository repository;


    
    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<CollaboratorModel> getCollaboratorById(@RequestParam("id") Integer id){
    	
    	CollaboratorModel collaborator = repository.findById(id).get();
    	
    	return new ResponseEntity<CollaboratorModel>(collaborator, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarNome")
    @ResponseBody
    public ResponseEntity<List<CollaboratorModel>> getCollaboratorByName(@RequestParam("name") String name){
    	
    	List<CollaboratorModel> collaborator = repository.getCollaboratorByName(name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<CollaboratorModel>>(collaborator, HttpStatus.OK);
    }
    
    @GetMapping("/selecionar/todos")
    @ResponseBody
    public ResponseEntity<List<CollaboratorModel>> collaboratorList(){
    	List<CollaboratorModel> collaborators = repository.findAll();
    	
    	return new ResponseEntity<List<CollaboratorModel>>(collaborators, HttpStatus.OK);
    }
    

    
    @PostMapping("/salvar")
    public @ResponseBody CollaboratorModel newCollaborator(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String ocupation) {
        CollaboratorModel collaborator = new CollaboratorModel(name, email, password, ocupation);
        repository.save(collaborator);
        return collaborator;
    }
    

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attCollaborator(@RequestBody CollaboratorModel collaborator) {
        
    	if(collaborator.getId() == null) {
    		
    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
    	}
    	CollaboratorModel collab = repository.saveAndFlush(collaborator);
        
        return new ResponseEntity<CollaboratorModel>(collab, HttpStatus.OK);
    }
    


    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Colaborador deletado com sucesso", HttpStatus.OK);
    }
    
//  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
//  public @ResponseBody CollaboratorModel saveCollaborator(@Valid CollaboratorModel collaborator) {
//  	
//  	repository.save(collaborator);
//  	return collaborator;
//  }
//  @PutMapping
//  public CollaboratorModel attCollaborator(CollaboratorModel collaborator) {
//  	
//  	repository.save(collaborator);
//  	return collaborator;
//  }
//
//  @GetMapping("/selecionar/{id}")
//  public Optional<CollaboratorModel> getCollaboratorById(@PathVariable int id) {
//      return repository.findById(id);
//  }
}    
