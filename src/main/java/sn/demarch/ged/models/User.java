package sn.demarch.ged.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "matricule")
    private Set<User_Groupe> user_groupes = new HashSet<>();

    @ManyToMany()
    private Set<Groupe> groupes = new HashSet<>();

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<User_Groupe> getUser_groupes() {
        return user_groupes;
    }
    @JsonIgnore
    public void setUser_groupes(Set<User_Groupe> user_groupes) {
        this.user_groupes = user_groupes;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    @JsonIgnore
    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }
}
