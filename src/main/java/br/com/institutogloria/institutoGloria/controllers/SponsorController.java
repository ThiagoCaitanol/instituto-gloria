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

import br.com.institutogloria.institutoGloria.models.SponsorModel;
import br.com.institutogloria.institutoGloria.repositories.SponsorRepository;

@RestController
@RequestMapping("/parceiros")
public class SponsorController {

	@Autowired
	private SponsorRepository repository;
	
    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<SponsorModel> getSponsorById(@RequestParam("id") Integer id){
    	
    	SponsorModel sponsor = repository.findById(id).get();
    	
    	return new ResponseEntity<SponsorModel>(sponsor, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarNome")
    @ResponseBody
    public ResponseEntity<List<SponsorModel>> getSponsorByName(@RequestParam("name") String name){
    	
    	List<SponsorModel> sponsor = repository.getSponsorByName(name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<SponsorModel>>(sponsor, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarTodos")
    @ResponseBody
    public Iterable<SponsorModel> getAllSponsor(){
    	return repository.findAll();
    }
    
    @GetMapping(path = "/selecionarPag/{pageNumber}")
    public Iterable<SponsorModel> getSponsorPage(@PathVariable int pageNumber){
    	Pageable page = PageRequest.of(pageNumber, 20);
    	return repository.findAll(page);
    }
    
    @PostMapping("/salvar")
    public @ResponseBody SponsorModel newSponsor(
            @RequestParam String name,
            @RequestParam String imageLink,
            @RequestParam String externalLink,
            @RequestParam String description) {
        SponsorModel sponsor = new SponsorModel(name, imageLink, externalLink, description);
        repository.save(sponsor);
        return sponsor;
    }
    
    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attSponsor(@RequestBody SponsorModel sponsor) {
        
    	if(sponsor.getId()== null) {
    		
    		return new ResponseEntity<String>("Id incorreto", HttpStatus.OK);
    	}
    	SponsorModel spn = repository.save(sponsor);
        
        return new ResponseEntity<SponsorModel>(spn, HttpStatus.OK);
    }
    
    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Parceiro deletado com sucesso", HttpStatus.OK);
    }
}
