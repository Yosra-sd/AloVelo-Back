package PiApp.Location.Repositories;

import PiApp.Location.Models.LocationId;
import PiApp.Location.Models.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, LocationId> {
}
