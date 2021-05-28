package user.ancyle.chrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.ancyle.chrms.entities.concretes.Announcement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Short> {

    List<Announcement> findAllByExDate(LocalDate exDate);
    List<Announcement> findAllByStatus(boolean status);
    List<Announcement> findAllByExDateGreaterThan(LocalDate date);
    List<Announcement> findAllByEmployer_CorpName(String corpName);

}
