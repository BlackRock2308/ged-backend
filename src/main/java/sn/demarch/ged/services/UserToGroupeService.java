package sn.demarch.ged.services;

import sn.demarch.ged.models.User;
import sn.demarch.ged.models.UserToGroupe;

import java.util.Optional;

public interface UserToGroupeService {


    public Iterable<UserToGroupe> getAllUserToGroupe();
    public UserToGroupe saveUserToGroupe(UserToGroupe userToGroupe);
    public Optional<UserToGroupe> getOneUserToGroupe(String id);
    public UserToGroupe updateUserTGroupe(UserToGroupe userToGroupe);
}
