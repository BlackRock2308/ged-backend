package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPrenom(String prenom);

    Optional<User> findByNom(String nom);

    @Query(
            value = "SELECT * FROM users WHERE matricule NOT IN (SELECT users_matricule FROM groupe_users WHERE groupe_id = ?1)",
            nativeQuery = true
    )
    List<User> getUserNotGroupes(String matricule);

}
