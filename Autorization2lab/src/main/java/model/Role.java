package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String title;
    @ManyToMany(
            cascade = {CascadeType.ALL}
    )
    @JoinTable(
            name = "role_right",
            joinColumns = {@JoinColumn(
                    name = "role_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "right_id"
            )}
    )
    private List<Right> accesList = new ArrayList();

    public Role(String title) {
        this.title = title;
    }

    public void AddRight(Right right) {
        this.accesList.add(right);
    }
}
