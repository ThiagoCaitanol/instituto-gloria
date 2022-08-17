package br.com.institutogloria.institutoGloria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.institutogloria.institutoGloria.models.CollaboratorModel;
import br.com.institutogloria.institutoGloria.models.UserModel;
import br.com.institutogloria.institutoGloria.repositories.UserRepository;


@RestController
@RequestMapping("/usuario")
public class UserController {


    @Autowired
    private UserRepository repository;

    

    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<UserModel> getUserById(@RequestParam("id") Integer id){
    	
    	UserModel user= repository.findById(id).get();
    	
    	return new ResponseEntity<UserModel>(user, HttpStatus.OK);
    }

    @GetMapping("/selecionarNome")
    @ResponseBody
    public ResponseEntity<List<UserModel>> getUserByName(@RequestParam("name") String name){
    	
    	List<UserModel> user = repository.getUserrByName(name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<UserModel>>(user, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarTodos")
    @ResponseBody
    public ResponseEntity<List<UserModel>> UserList(){
    	List<UserModel> user = repository.findAll();
    	
    	return new ResponseEntity<List<UserModel>>(user, HttpStatus.OK);
    }
    
    @PostMapping("/salvar")
    public @ResponseBody UserModel newUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String cpf) {
        UserModel user = new UserModel(name, email, cpf);
        repository.save(user);
        return user;
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attUser(@RequestBody UserModel user) {
        
    	if(user.getId() == null) {
    		
    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
    	}
    	UserModel us = repository.saveAndFlush(user);
        
        return new ResponseEntity<UserModel>(us, HttpStatus.OK);
    }

    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Colaborador deletado com sucesso", HttpStatus.OK);
    }

}
