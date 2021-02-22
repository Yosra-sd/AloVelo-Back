package PiApp.Location.Controllers;


import PiApp.Location.Models.Velos;
import PiApp.Location.Services.VelosService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/velos")

public class VelosController {
    private VelosService velosServ ;

    @Autowired
    public VelosController (VelosService velosServ){
        this.velosServ=velosServ;
    }



    // add velo
    @PostMapping("/newvelo")
    public ResponseEntity<Velos> addVelo(@Valid @RequestBody Velos v1)
    {
        return velosServ.addVelo(v1);
    }

    //Select velos
    @GetMapping("/all")
    public ResponseEntity<List<Velos>> getVelos()
    {
        return velosServ.getAllVelos();
    }

    //Delete a velo
    @DeleteMapping("/velo/{id}")
    public ResponseEntity deleteVelo(@PathVariable Long code)
    {
        return velosServ.deleteVelo(code);
    }

    //Update a velo
    @PutMapping("/velo/{id}")
    public ResponseEntity<Velos> updateVelo(@PathVariable Long id, @Valid @RequestBody Velos v1)
    {
        return velosServ.updateVelo(id,v1);
    }

    // find a velo
    @GetMapping("/velo/{code}")
    public ResponseEntity<Velos> getVelo (@PathVariable Long code)
    {
        return velosServ.getVeloByRef(code);
    }


}
