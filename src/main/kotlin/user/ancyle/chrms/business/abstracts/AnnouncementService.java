package user.ancyle.chrms.business.abstracts;

import org.springframework.stereotype.Service;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.entities.concretes.Announcement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface AnnouncementService {
    DataResult<List<Announcement>> listAll();
    DataResult<List<Announcement>> listAllByCorpName(String corpName);
    Result addNew(Announcement announcement);
    Result modify(Announcement announcement);
    DataResult<Announcement> getById(short id);
    DataResult<List<Announcement>> findAllByExDate(LocalDate exDate);
    DataResult<List<Announcement>> findAllByStatus(boolean status);
    DataResult<List<Announcement>> findAllByExDateGreaterThan(LocalDate date);
}
