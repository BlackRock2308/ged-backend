package sn.demarch.ged.services;

import sn.demarch.ged.models.User_Groupe;

import java.util.Optional;

public interface UserToGroupeService {


    public Iterable<User_Groupe> getAllUserToGroupe();
    public User_Groupe saveUserToGroupe(User_Groupe userToGroupe);
    public Optional<User_Groupe> getOneUserToGroupe(String id);
    public User_Groupe updateUserTGroupe(User_Groupe userToGroupe);

    public void assignUserToGroupe(String matricule, String idGroupe);

    public void unAssignUsergroupe(String matricule, String idGroupe);
}
