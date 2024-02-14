package samuelesimeone.eserciziou5w2d4.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelesimeone.eserciziou5w2d4.entities.BlogPost;

import java.util.UUID;

@Repository
public interface BlogPostDAO extends JpaRepository<BlogPost, UUID> {
}
