package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.User_Groupe;

@Repository
public interface UserToGroupeRepository extends JpaRepository<User_Groupe, String> {
}
