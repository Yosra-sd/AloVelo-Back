package PiApp.Location.Controllers;

import PiApp.Location.Models.Clients;
import PiApp.Location.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {


    private ClientsService clientsService ;

    @Autowired
    public ClientsController (ClientsService clientsService)
    {
        this.clientsService=clientsService;
    }


    // add Client
    @PostMapping("/newclient")
    public ResponseEntity<Clients> addClient(@Valid @RequestBody Clients c1)
    {
        return clientsService.addClient(c1);
    }

    // get by id
    @GetMapping("/client/{id}")
    public ResponseEntity<Clients> getTeam (@PathVariable Long id)
    {
        return clientsService.getClientById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clients>> getClients()
    {
        return clientsService.getAllClients();
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable Long id, @Valid @RequestBody Clients c1)
    {
        return clientsService.updateClient(id,c1);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id)
    {
        return clientsService.deleteClient(id);
    }
}
