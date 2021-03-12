package model;

import lombok.*;

import javax.management.ConstructorParameters;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Rights")
public class Right {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            name = "rights"
    )
    private String right;

    public Right(String right) {
        this.right = right;
    }
}
