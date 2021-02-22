package PiApp.Location.Repositories;


import PiApp.Location.Models.Clients;
import PiApp.Location.Models.Velos;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients,Long> {

    Clients findByClientId(Long clientId);
}

