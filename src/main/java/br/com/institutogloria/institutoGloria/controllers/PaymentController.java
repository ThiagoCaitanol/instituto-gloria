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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutogloria.institutoGloria.models.PaymentModel;
import br.com.institutogloria.institutoGloria.repositories.PaymentRepository;

@RestController
@RequestMapping("/pagamento")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    //CRUD

    @GetMapping("/selecionarId")
    @ResponseBody
    public ResponseEntity<PaymentModel> getPaymentById(@RequestParam("id") Integer id){
    	
    	PaymentModel payments = repository.findById(id).get();
    	
    	return new ResponseEntity<PaymentModel>(payments, HttpStatus.OK);
    }
    
    @GetMapping("/selecionarNome")
    @ResponseBody
    public ResponseEntity<List<PaymentModel>> getPaymentByName(@RequestParam("name") String name){
    	
    	List<PaymentModel> payments = repository.getPaymentsByName(name.trim().toUpperCase());
    	
    	return new ResponseEntity<List<PaymentModel>>(payments, HttpStatus.OK);
    }

    @GetMapping("/selecionarTodos")
    @ResponseBody
    public Iterable<PaymentModel> getAllPayment(){
    	return repository.findAll();
    }
    
    @GetMapping(path = "/selecionarPag/{pageNumber}")
    public Iterable<PaymentModel> getPaymentPage(@PathVariable int pageNumber){
    	Pageable page = PageRequest.of(pageNumber, 20);
    	return repository.findAll(page);
    }
    
    @PostMapping("/salvar")
    public @ResponseBody PaymentModel newPayment(
    		@Valid 
            @RequestParam String name,
            @RequestParam String cpf,
            @RequestParam String email,
            @RequestParam Double value) {
        PaymentModel payment = new PaymentModel(name, cpf, email, value);
        repository.save(payment);
        return payment;
    }

    @DeleteMapping("/{id}")
    public void deltePayment(@PathVariable int id) {
        repository.deleteById(id);
    }

}

