package PiApp.Location.Repositories;

import PiApp.Location.Models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrateur,Long> {
}
