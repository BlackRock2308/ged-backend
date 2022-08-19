package sn.demarch.ged.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User_Groupe implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String matricule;
    private String idGroupe;

    @ManyToMany(
            fetch = FetchType.EAGER)
    @JoinColumn(name="matricule", nullable = false, updatable = false, insertable = false)
    private Set<User> user;

    @ManyToMany(
            fetch = FetchType.EAGER)
    @JoinColumn(name="idGroupe", nullable = false, updatable = false, insertable = false)
    private Set<Groupe> groupe;
}
