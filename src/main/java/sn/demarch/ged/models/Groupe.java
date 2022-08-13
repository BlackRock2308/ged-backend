package sn.demarch.ged.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String idGroupe;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "groupeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserToGroupe> userToGroupeList = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "groupes")
    private List<User> users = new ArrayList<>();


    public void addUserToGroupe(User user) {
        this.users.add(user);
    }

}
