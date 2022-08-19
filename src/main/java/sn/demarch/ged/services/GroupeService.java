package sn.demarch.ged.services;

import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;

import java.util.List;
import java.util.Optional;

@Service("groupeService")
public interface GroupeService {

    public Iterable<Groupe> getAllGroupes();
    public Groupe saveGroupe(Groupe groupe);
    public Optional<Groupe> getOneGroupe(String id);
    public Groupe updateGroupe(Groupe groupe);

    public void assignUserGroupe(String matricule, String idGroupe);

    public void unassignUserGroupe(String matricule, String idGroupe);

    public List<Groupe> getUserNotGroupes(User user);
}
