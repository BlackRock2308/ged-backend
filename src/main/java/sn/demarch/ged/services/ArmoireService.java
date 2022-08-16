package sn.demarch.ged.services;

import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Armoire;
import sn.demarch.ged.models.Groupe;

import java.util.Optional;

@Service("armoireSerive")
public interface ArmoireService {

    public Iterable<Armoire> getAllArmoires();
    public Armoire saveArmoire(Armoire armoire);
    public Optional<Armoire> getOneArmoire(String id);
    public Armoire updateArmoire(Armoire armoire);
}
