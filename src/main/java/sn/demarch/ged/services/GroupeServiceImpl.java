package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;
import sn.demarch.ged.repositories.GroupeRepository;
import sn.demarch.ged.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service("groupeService")
@Transactional
public class GroupeServiceImpl implements GroupeService{

    private final GroupeRepository groupeRepository;

    private final UserRepository userRepository;

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
}