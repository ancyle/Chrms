package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import user.ancyle.chrms.entities.concretes.City;

public interface CityRepo extends JpaRepository<City,Short> {

}
