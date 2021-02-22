package PiApp.Location.Services;

import PiApp.Location.Models.Clients;
import PiApp.Location.Models.LocationId;
import PiApp.Location.Models.Locations;
import PiApp.Location.Models.Velos;
import PiApp.Location.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientsService {


    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private VelosService velosService;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository ;
    }


    public Clients findByClientId(Long clientId) {
        return clientsRepository.findByClientId(clientId);
    }


    // get client by id
    public ResponseEntity<Clients> getClientById(Long id)
    {
        try {
            Optional<Clients> clients = clientsRepository.findById(id);
            return clients.map(x -> ResponseEntity.ok().body(x))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }}

    // add a client
    public ResponseEntity<Clients> addClient(Clients c1)
    {
        try {
            Clients clients = clientsRepository.save(c1);
            return new ResponseEntity<Clients>(clients, HttpStatus.CREATED);
        }catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Clients>> getAllClients()
    {
        try {
            List<Clients> listClients = (List<Clients>) clientsRepository.findAll();
            if (listClients.isEmpty())
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity(listClients, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Clients> updateClient(Long id, Clients updateClient)
    {
        try {
            Optional<Clients> clients = clientsRepository.findById(id);
            if (clients.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            Clients c1 = clients.get();    // pour recuperer le velo qui est dans Optional
            c1.setNom(updateClient.getNom());
            c1.setPrenom(updateClient.getPrenom());
            c1.setTelephone(updateClient.getTelephone());
            c1.setEmail(updateClient.getEmail());
            c1.setCIN(updateClient.getCIN());
            c1.setLogin(updateClient.getLogin());
            c1.setPassword(updateClient.getPassword());


            Clients updated = clientsRepository.save(c1);
            return new ResponseEntity<Clients>(updated, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteClient(Long id)
    {
        try {
            Optional<Clients> clients = clientsRepository.findById(id);
            if (clients.isEmpty()) // si id invalide
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            clientsRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
