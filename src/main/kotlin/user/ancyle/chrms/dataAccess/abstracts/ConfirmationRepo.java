package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.ancyle.chrms.entities.concretes.Confirmation;


@Repository
@Transactional
public interface ConfirmationRepo extends JpaRepository<Confirmation,Short> {
    Confirmation getConfirmationByToken(String token);
}
