package samuelesimeone.eserciziou5w2d4.exceptions;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsPayload {
    private String message;
    private LocalDateTime time;
}
