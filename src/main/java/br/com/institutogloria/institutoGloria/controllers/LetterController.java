package br.com.institutogloria.institutoGloria.controllers;

import java.util.List;

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

import br.com.institutogloria.institutoGloria.models.LetterModel;
import br.com.institutogloria.institutoGloria.models.UserModel;
import br.com.institutogloria.institutoGloria.repositories.LetterRepository;

@RestController
@RequestMapping("/cartas")
public class LetterController {

	@Autowired
	private LetterRepository repository;
	
    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<LetterModel> getLetterById(@RequestParam("id") Integer id){
    	
    	LetterModel letter = repository.findById(id).get();
    	
    	return new ResponseEntity<LetterModel>(letter, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarTitulo")
    @ResponseBody
    public ResponseEntity<List<LetterModel>> getByTitle(@RequestParam("letterTitle") String lettlerTitle){
    	
    	List<LetterModel> letter = repository.getByTitle(lettlerTitle.trim().toUpperCase());
    	
    	return new ResponseEntity<List<LetterModel>>(letter, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarTodos")
    @ResponseBody
    public Iterable<LetterModel> getAllLetter(){
    	return repository.findAll();
    }
    
    @GetMapping(path = "/selecionarPag/{pageNumber}")
    public Iterable<LetterModel> getLetterPage(@PathVariable int pageNumber){
    	Pageable page = PageRequest.of(pageNumber, 20);
    	return repository.findAll(page);
    }
    
    @PostMapping("/salvar")
    public @ResponseBody LetterModel newLetter(
            @RequestParam UserModel user,
            @RequestParam String titleLetter,
            @RequestParam String letter) {
        LetterModel let= new LetterModel(user, titleLetter, letter);
        repository.save(let);
        return let;
    }
    
    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attLetter(@RequestBody LetterModel letter) {
        
    	if(letter.getId() == null) {
    		
    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
    	}
    	LetterModel let = repository.save(letter);
        
        return new ResponseEntity<LetterModel>(let, HttpStatus.OK);
    }
    
    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Carta deletado com sucesso", HttpStatus.OK);
    }
}
