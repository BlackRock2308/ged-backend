package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.Armoire;

@Repository
public interface ArmoireRepository extends JpaRepository<Armoire, String> {
}
