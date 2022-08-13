package sn.demarch.ged.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.demarch.ged.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
