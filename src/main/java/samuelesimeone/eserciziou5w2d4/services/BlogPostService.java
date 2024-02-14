package samuelesimeone.eserciziou5w2d4.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelesimeone.eserciziou5w2d4.dao.AutoriDAO;
import samuelesimeone.eserciziou5w2d4.dao.BlogPostDAO;
import samuelesimeone.eserciziou5w2d4.entities.Autore;
import samuelesimeone.eserciziou5w2d4.entities.BlogPost;
import samuelesimeone.eserciziou5w2d4.entities.BlogPostPayload;
import samuelesimeone.eserciziou5w2d4.exceptions.NotFoundException;

import java.util.*;

@Service
public class BlogPostService {
    Random rdm = new Random();
    @Autowired
    BlogPostDAO blogPostDAO;

    @Autowired
    AutoriService autoriService;

    public List<BlogPost> getAll(){
        return blogPostDAO.findAll();
    }

    public BlogPost save(BlogPostPayload post){
        Autore found = autoriService.findById(post.getAutoreId());
        post.setCover("https://picsum.photos/200/300");
        post.setTempoDiLettura(rdm.nextDouble(1.0, 60.0));
        BlogPost newPost = new BlogPost(post.getCategoria(), post.getTitolo(), post.getCover(), post.getContenuto(), post.getTempoDiLettura(), found);
        return blogPostDAO.save(newPost);
    }

    public BlogPost findById(UUID id){
       return blogPostDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost update(UUID id, BlogPost postUp){
        postUp.setCover("https://picsum.photos/" + rdm.nextInt(100, 200) + "/" + rdm.nextInt(200, 300));
        postUp.setTempoDiLettura(rdm.nextDouble(1.0, 60.0));
        BlogPost found = this.findById(id);
        found.setCategoria(postUp.getCategoria());
        found.setContenuto(postUp.getContenuto());
        found.setTitolo(postUp.getTitolo());
        found.setCover(postUp.getCover());
        found.setTempoDiLettura(postUp.getTempoDiLettura());
        return blogPostDAO.save(found);
    }

    public void deletePost(UUID id){
        BlogPost found = this.findById(id);
        blogPostDAO.delete(found);
    }
}
