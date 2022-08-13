package sn.demarch.ged.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String idRole;
    private String name;
    private String description;

/**
    @ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "idRole" ),
            inverseJoinColumns = @JoinColumn( name = "matricule" ) )
    private List<User> users = new ArrayList<>();

    **/
}
