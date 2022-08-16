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

import br.com.institutogloria.institutoGloria.models.AdminModel;
import br.com.institutogloria.institutoGloria.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	   @Autowired
	    private AdminRepository repository;

	    //CRUD

	    @GetMapping("/selecionarId")
	    @ResponseBody
	    public ResponseEntity<AdminModel> getAdminById(@RequestParam("id") Integer id){
	    	
	    	AdminModel admin = repository.findById(id).get();
	    	
	    	return new ResponseEntity<AdminModel>(admin, HttpStatus.OK);
	    }
	    
	    @GetMapping("/selecionarNome")
	    @ResponseBody
	    public ResponseEntity<List<AdminModel>> getAdminByName(@RequestParam("name") String name){
	    	
	    	List<AdminModel> admin = repository.getAdminByName(name.trim().toUpperCase());
	    	
	    	return new ResponseEntity<List<AdminModel>>(admin, HttpStatus.OK);
	    }
	    
	    @GetMapping("/selecionar/todos")
	    @ResponseBody
	    public ResponseEntity<List<AdminModel>> adminList(){
	    	List<AdminModel> admin = repository.findAll();
	    	
	    	return new ResponseEntity<List<AdminModel>>(admin, HttpStatus.OK);
	    }
	    

	    
	    @PostMapping("/salvar")
	    public @ResponseBody AdminModel newAdmin(
	            @RequestParam String name,
	            @RequestParam String email,
	            @RequestParam String password) {
	    	AdminModel admin = new AdminModel(name, email, password);
	        repository.save(admin);
	        return admin;
	    }
	    

	    @PutMapping("/atualizar")
	    @ResponseBody
	    public ResponseEntity<?> attAdmin(@RequestBody AdminModel admin) {
	        
	    	if(admin.getId() == null) {
	    		
	    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
	    	}
	    	AdminModel adm = repository.saveAndFlush(admin);
	        
	        return new ResponseEntity<AdminModel>(adm, HttpStatus.OK);
	    }
	    


	    @DeleteMapping("/apagar")
	    @ResponseBody
	    public ResponseEntity<String> delete(@RequestParam Integer id) {
	    	
	    	repository.deleteById(id);
	    	
	    	return new ResponseEntity<String>("Colaborador deletado com sucesso", HttpStatus.OK);
	    }
}
