package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import user.ancyle.chrms.entities.concretes.Position;

public interface PositionRepo extends JpaRepository<Position,Integer> {
}
