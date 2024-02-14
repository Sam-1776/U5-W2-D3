package samuelesimeone.eserciziou5w2d4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import samuelesimeone.eserciziou5w2d4.entities.BlogPost;
import samuelesimeone.eserciziou5w2d4.entities.BlogPostPayload;
import samuelesimeone.eserciziou5w2d4.services.BlogPostService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAll(){
        return this.blogPostService.getAll();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable UUID id){
        return this.blogPostService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost save(@RequestBody BlogPostPayload post){
        return this.blogPostService.save(post);
    }

    @PutMapping("/{id}")
    public BlogPost update(@PathVariable UUID id, @RequestBody BlogPost post){
        return this.blogPostService.update(id,post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        this.blogPostService.deletePost(id);
    }


}
