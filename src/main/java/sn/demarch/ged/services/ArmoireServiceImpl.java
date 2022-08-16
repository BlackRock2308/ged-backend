package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Armoire;
import sn.demarch.ged.repositories.ArmoireRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@AllArgsConstructor
@Service("armoireService")
@Transactional
public class ArmoireServiceImpl implements ArmoireService{
    private final ArmoireRepository armoireRepository;
    @Override
    public Iterable<Armoire> getAllArmoires() {
        return armoireRepository.findAll();
    }

    @Override
    public Armoire saveArmoire(Armoire armoire) {
        return armoireRepository.save(armoire);
    }

    @Override
    public Optional<Armoire> getOneArmoire(String id) {
        return  armoireRepository.findById(id);
    }

    @Override
    public Armoire updateArmoire(Armoire armoire) {
        Armoire existingArmoire = armoireRepository.findById(armoire.getId()).orElse(null);
        existingArmoire.setArmoireName(armoire.getArmoireName());
        existingArmoire.setDescription(armoire.getDescription());

        return armoireRepository.save(existingArmoire);
    }
}
