package PiApp.Location.Controllers;

import PiApp.Location.Models.Locations;
import PiApp.Location.Repositories.LocationsRepository;
import PiApp.Location.Services.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private LocationsService locationsServ ;

    @Autowired
    public LocationsController (LocationsService locationsServ)
    {
        this.locationsServ= locationsServ ;
    }

    @PostMapping("/newlocations")
    public ResponseEntity<Locations> addLocations(@Valid @RequestBody Locations L1) {
        return locationsServ.addLocations (L1);
    }





}


