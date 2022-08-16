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
import br.com.institutogloria.institutoGloria.models.PhotosModel;
import br.com.institutogloria.institutoGloria.repositories.PhotoRepository;

@RestController
@RequestMapping("/fotos")
public class PhotoController {

    @Autowired
    private PhotoRepository repository;

    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<PhotosModel> getPhotoById(@RequestParam("id") Integer id){
    	
    	PhotosModel photo = repository.findById(id).get();
    	
    	return new ResponseEntity<PhotosModel>(photo, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarLink")
    @ResponseBody
    public ResponseEntity<List<PhotosModel>> getLink(@RequestParam("name") String name){
    	
    	List<PhotosModel> photo = repository.getLink (name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<PhotosModel>>(photo, HttpStatus.OK);
    }
    
    @GetMapping("/selecionar/todos")
    @ResponseBody
    public ResponseEntity<List<PhotosModel>> photoList(){
    	List<PhotosModel> photo = repository.findAll();
    	
    	return new ResponseEntity<List<PhotosModel>>(photo, HttpStatus.OK);
    }
    

    @PostMapping("/salvar")
    public @ResponseBody PhotosModel newPhoto(
            @RequestParam CollaboratorModel collaborator,
            @RequestParam String description,
            @RequestParam String link) {
        PhotosModel photo = new PhotosModel(collaborator, description, link);
        repository.save(photo);
        return photo;
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> attPhoto(@RequestBody PhotosModel photo) {
        
    	if(photo.getLink() == null) {
    		
    		return new ResponseEntity<String>("link incorreto", HttpStatus.OK);
    	}
    	PhotosModel pht = repository.saveAndFlush(photo);
        
        return new ResponseEntity<PhotosModel>(pht, HttpStatus.OK);
    }

    @DeleteMapping("/apagar")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Integer id) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity<String>("Colaborador deletado com sucesso", HttpStatus.OK);
    }

}
