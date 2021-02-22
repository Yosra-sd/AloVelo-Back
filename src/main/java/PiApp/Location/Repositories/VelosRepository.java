package PiApp.Location.Repositories;


import PiApp.Location.Models.Velos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VelosRepository extends CrudRepository<Velos,Long> {

    Velos findByVeloId(Long veloId);


}
