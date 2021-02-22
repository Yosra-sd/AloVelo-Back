package PiApp.Location.Services;

import PiApp.Location.Models.Clients;
import PiApp.Location.Models.LocationId;
import PiApp.Location.Models.Locations;
import PiApp.Location.Models.Velos;
import PiApp.Location.Repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository locationrepo ;

    @Autowired
    private VelosService velosService;

    @Autowired
    private ClientsService clientsService;

    public LocationsService (LocationsRepository locationrepo)
    {
        this.locationrepo = locationrepo ;
    }



    public ResponseEntity<Locations> addLocations(Locations l1){
        try {
            System.out.println(l1.toString());
            Velos velos = velosService.findByVelosId(l1.getVelos().getVeloId());
            Clients clients = clientsService.findByClientId(l1.getClients().getClientId());

            l1.setId_location(new LocationId(velos.getVeloId(),clients.getClientId()));

            Locations locations = locationrepo.save(l1);

            return new ResponseEntity<Locations>(locations, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
