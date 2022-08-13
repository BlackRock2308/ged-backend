package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPrenom(String prenom);

    Optional<User> findByNom(String nom);



}
