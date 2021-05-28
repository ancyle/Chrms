package user.ancyle.chrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.AnnouncementService;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessDataResult;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.dataAccess.abstracts.AnnouncementRepo;
import user.ancyle.chrms.entities.concretes.Announcement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
public class AnnouncementManager implements AnnouncementService {
    private final AnnouncementRepo announcementRepo;
@Autowired
    public AnnouncementManager(AnnouncementRepo announcementRepo) {
        this.announcementRepo = announcementRepo;
    }

    @Override
    public DataResult<List<Announcement>> listAll() {
        return new SuccessDataResult<>(this.announcementRepo.findAll());
    }

    @Override
    public DataResult<List<Announcement>> listAllByCorpName(String corpName) {
        return new SuccessDataResult<>(this.announcementRepo.findAllByEmployer_CorpName(corpName));
    }

    @Override
    public Result addNew(Announcement announcement) {
        this.announcementRepo.save(announcement);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Announcement>> findAllByExDate(LocalDate exDate) {
        return new SuccessDataResult<>(this.announcementRepo.findAllByExDate(exDate));
    }

    @Override
    public DataResult<List<Announcement>> findAllByStatus(boolean status) {
        return new SuccessDataResult<>(this.announcementRepo.findAllByStatus(status));
    }

    @Override
    public DataResult<List<Announcement>> findAllByExDateGreaterThan(LocalDate date) {
        return new SuccessDataResult<>(this.announcementRepo.findAllByExDateGreaterThan(date));
    }
}
