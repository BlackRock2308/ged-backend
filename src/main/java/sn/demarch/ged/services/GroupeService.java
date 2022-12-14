package sn.demarch.ged.services;

import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;
import sn.demarch.ged.models.User_Groupe;

import java.util.List;
import java.util.Optional;

@Service("groupeService")
public interface GroupeService {

    public Iterable<Groupe> getAllGroupes();
    public Groupe saveGroupe(Groupe groupe);
    public Optional<Groupe> getOneGroupe(String id);
    public Groupe updateGroupe(Groupe groupe);

    public void addUserToGroupe(User user);

    public User_Groupe saveUserToGroupe(User_Groupe user_groupe);

    public List<User> getUserNotGroupes(Groupe groupe);
}
