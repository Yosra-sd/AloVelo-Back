package PiApp.Location.Controllers;

import PiApp.Location.Models.Administrateur;
import PiApp.Location.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admins")

public class AdminController {

    private AdminService AdminServ ;

    @Autowired
    public AdminController (AdminService AdminServ){
        this.AdminServ=AdminServ;
    }

    // add administrateur
    @PostMapping("/newadmin")
    public ResponseEntity<Administrateur> addAdmin(@Valid @RequestBody Administrateur a1)
    {
        return AdminServ.addAdmin(a1);
    }

    //Select admins
    @GetMapping("/all")
    public ResponseEntity<List<Administrateur>> getAdmin()
    {
        return AdminServ.getAlladmin();
    }

    //Delete admin by id
    @DeleteMapping("/admin/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Long id)
    {
        return AdminServ.deleteAdmin(id);
    }

    //Update admin by id
    @PutMapping("/admin/{code}")
    public ResponseEntity<Administrateur> updateAdmin(@PathVariable Long code, @Valid @RequestBody Administrateur a1)
    {
        return AdminServ.updateAdmin(code,a1);
    }

    // find admin by id
    @GetMapping("/admin/{code}")
    public ResponseEntity<Administrateur> getAdmin (@PathVariable Long code)
    {
        return AdminServ.getAdminByID(code);
    }
}


