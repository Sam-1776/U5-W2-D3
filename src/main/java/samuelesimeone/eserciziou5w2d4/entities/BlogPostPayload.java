package samuelesimeone.eserciziou5w2d4.entities;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class BlogPostPayload {
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;
    private UUID autoreId;
}
