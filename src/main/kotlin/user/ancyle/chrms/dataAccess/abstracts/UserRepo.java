package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.ancyle.chrms.entities.concretes.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Short> {
    boolean existsUserByUserMail(String mail);
}
