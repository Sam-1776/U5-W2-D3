package samuelesimeone.eserciziou5w2d4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import samuelesimeone.eserciziou5w2d4.entities.Autore;
import samuelesimeone.eserciziou5w2d4.services.AutoriService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autori")
public class AutoriController {

    @Autowired
    AutoriService autoriService;

    @GetMapping
    public List<Autore> getAll(){
        return this.autoriService.getAll();
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable UUID id){
        return this.autoriService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore save(@RequestBody Autore autore){
        return this.autoriService.save(autore);
    }

    @PutMapping("/{id}")
    public Autore update(@PathVariable UUID id, @RequestBody Autore autoreUp){
        return this.autoriService.update(id, autoreUp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        this.autoriService.delete(id);
    }
}
