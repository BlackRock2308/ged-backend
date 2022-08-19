package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;
import sn.demarch.ged.models.User_Groupe;
import sn.demarch.ged.repositories.GroupeRepository;
import sn.demarch.ged.repositories.UserRepository;
import sn.demarch.ged.repositories.UserToGroupeRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service("groupeService")
@Transactional
public class GroupeServiceImpl implements GroupeService{

    private final GroupeRepository groupeRepository;

    private final UserRepository userRepository;

    private UserToGroupeRepository userToGroupeRepository;

    @Override
    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Iterable<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public Optional<Groupe> getOneGroupe(String id) {
        return groupeRepository.findById(id);
    }

    @Override
    public Groupe updateGroupe(Groupe groupe) {
        Groupe existingGroupe = groupeRepository.findById(groupe.getIdGroupe()).orElse(null);
        existingGroupe.setName(groupe.getName());
        existingGroupe.setDescription(groupe.getDescription());
        //existingGroupe.setUsers(groupe.getUsers());
        return groupeRepository.save(existingGroupe);
    }

    @Override
    public void addUserToGroupe(User use) {

    }

    @Override
    public User_Groupe saveUserToGroupe(User_Groupe user_groupe) {
        User user  = userRepository.findById(user_groupe.getMatricule()).get();
        Groupe groupe = groupeRepository.findById(user_groupe.getIdGroupe()).get();
        Set<User> userGroupes = groupe.getUsers();
        userGroupes.add(user);
        groupe.setUsers(userGroupes);
        groupeRepository.save(groupe);
        return userToGroupeRepository.save(user_groupe);
    }
}
