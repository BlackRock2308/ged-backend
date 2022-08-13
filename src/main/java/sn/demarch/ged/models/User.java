package sn.demarch.ged.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String matricule;
    private String nom;
    private String prenom;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "userMatricule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserToGroupe> userToGroupeList;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "T_Users_Groupes_Associations",
            joinColumns = @JoinColumn( name = "user_matricule" ),
            inverseJoinColumns = @JoinColumn( name = "id_groupe" ) )
    private Set<Groupe> groupes = new HashSet<>();


    /**
    @ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "user_matricule" ),
            inverseJoinColumns = @JoinColumn( name = "id_role" ) )
    private List<Role> roles = new ArrayList<>();
**/


}
