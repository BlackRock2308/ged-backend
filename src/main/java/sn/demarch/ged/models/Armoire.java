package sn.demarch.ged.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(	name = "armoires",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "armoireName")
        })
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
public class Armoire implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @NotBlank
    @Size(max = 50)
    private String armoireName;
    @NotBlank
    private String description;
    @Column(columnDefinition = "int default 0")
    private Integer nombre_fichiers;
}
