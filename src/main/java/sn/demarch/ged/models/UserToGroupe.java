package sn.demarch.ged.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserToGroupe implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String userMatricule;
    private String groupeId;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name="userMatricule", nullable = false, updatable = false, insertable = false)
    private User user;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name="groupeId", nullable = false, updatable = false, insertable = false)
    private Groupe groupe;
}
