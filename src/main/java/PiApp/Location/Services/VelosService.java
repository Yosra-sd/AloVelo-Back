package PiApp.Location.Services;


import PiApp.Location.Models.Clients;
import PiApp.Location.Models.Velos;
import PiApp.Location.Repositories.VelosRepository;
//import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

@Service
public class VelosService {

    @Autowired
    private VelosRepository velorepos;

    public VelosService(VelosRepository velorepos) {
        this.velorepos = velorepos ;
    }

    public Velos findByVelosId(Long veloId) {
        return velorepos.findByVeloId(veloId);
    }



    // add a velo
    public ResponseEntity<Velos> addVelo(Velos v1)
    {
        try {
            Velos velos = velorepos.save(v1);
            return new ResponseEntity<Velos>(velos, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all velos
    public ResponseEntity<List<Velos>> getAllVelos()
    {
        try {
            List<Velos> listVelos = (List<Velos>) velorepos.findAll();
            if (listVelos.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity(listVelos, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //find a velo
    public ResponseEntity<Velos> getVeloByRef(Long Code)
    {
        try {
            Optional<Velos> velo = velorepos.findById(Code);
            return velo.map(x -> ResponseEntity.ok().body(x))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //delete a velo
    public ResponseEntity<?> deleteVelo(Long Code)
    {
        try {
            Optional<Velos> velo = velorepos.findById(Code);
            if (velo.isEmpty()) // si id invalide
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            velorepos.deleteById(Code);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update a velo

    public ResponseEntity<Velos> updateVelo(Long id, Velos updVelo)
    {
        try {
            Optional<Velos> velos = velorepos.findById(id);
            if (velos.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            Velos v1 = velos.get();    // pour recuperer le velo qui est dans Optional
            v1.setName(updVelo.getName());
            v1.setCouleur(updVelo.getCouleur());
            v1.setReference(updVelo.getReference());
            v1.setDescription(updVelo.getDescription());
            v1.setStock(updVelo.getStock());
            v1.setPhotos(updVelo.getPhotos());
            v1.setPrix(updVelo.getPrix());
            v1.setType(updVelo.getType());
            v1.setTaille(updVelo.getTaille());


            Velos updated = velorepos.save(v1);
            return new ResponseEntity<Velos>(updated, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    public ResponseEntity<List<Velos>> getVeloByEtat(String Etat)
//    {
//        try {
//            List<Velos> listetat = velorepos.findAll().stream()
//                    .filter(x->x.getStock().equalsIgnoreCase(Etat))
//                    .collect(Collectors.toList());
//            if (listetat.isEmpty())
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return new ResponseEntity<>(listetat,HttpStatus.OK);
//        }catch (Exception e)
//        {
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    private List<Velos> getVeloByStockAndName(Integer stock, String veloName) {
//        return velorepos.findAll().stream()
//                .filter(x->x.getStock()==1&&x.getName().toLowerCase().equals(veloName.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    private List<Velos> findByStockAndDate(Integer stock, LocalDate dateres) {
//        return velorepos.findAll().stream()
//                .filter(x->x.getStock()==1&&x.getReference().toLocalDate().isEqual(startDate))
//                .collect(Collectors.toList());
//    }



}
