package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.Groupe;

import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe,String> {


}
