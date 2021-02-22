package PiApp.Location.Services;


import PiApp.Location.Models.Administrateur;
import PiApp.Location.Models.Clients;
import PiApp.Location.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository Adminrepos;

    public AdminService(AdminRepository Adminrepos) {
        this.Adminrepos = Adminrepos;
    }

    // add
    public ResponseEntity<Administrateur> addAdmin(Administrateur a1) {
        try {
            Administrateur admin = Adminrepos.save(a1);
            return new ResponseEntity<Administrateur>(admin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get all admins
    public ResponseEntity<List<Administrateur>>getAlladmin()
    {
        try{
            List<Administrateur> listAdmin=Adminrepos.findAll();
            if(listAdmin.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity(listAdmin,HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete admin
    public ResponseEntity<?> deleteAdmin(Long id)
    {
        try {
            Optional<Administrateur> admin = Adminrepos.findById(id);
            if (admin.isEmpty()) // si id invalide
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            Adminrepos.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update admin by id
    public ResponseEntity<Administrateur> updateAdmin(Long code,Administrateur updAdmin)
    {
        try
        {
            Optional<Administrateur> admin=Adminrepos.findById(code);
            if(admin.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            Administrateur a1=admin.get();    // pour recuperer l'admin qui est dans Optional
            a1.setNom(updAdmin.getNom());
            a1.setPrenom(updAdmin.getPrenom());
            a1.setEmail(updAdmin.getEmail());
            a1.setPassword(updAdmin.getPassword());
            Administrateur updated=Adminrepos.save(a1);
            return new ResponseEntity<Administrateur>(updated,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //find admin by id
    public ResponseEntity<Administrateur> getAdminByID(Long Code)
    {
        try{
            Optional<Administrateur> admin=Adminrepos.findById(Code);
            return admin.map(x->ResponseEntity.ok().body(x))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
