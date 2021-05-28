package user.ancyle.chrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.ancyle.chrms.business.abstracts.AnnouncementService;
import user.ancyle.chrms.business.abstracts.CityService;
import user.ancyle.chrms.business.abstracts.PositionService;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.ErrorResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.entities.concretes.Announcement;
import user.ancyle.chrms.entities.concretes.City;
import user.ancyle.chrms.entities.concretes.Position;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ann")
public class AnnouncementsController {
    private final AnnouncementService announcementService;
    private final CityService cityService;
    private final PositionService positionService;

    @Autowired
    public AnnouncementsController(AnnouncementService announcementService, CityService cityService, PositionService positionService) {
        this.announcementService = announcementService;
        this.cityService = cityService;
        this.positionService = positionService;
    }

    @PostMapping("/new")
    public Result addNew(@RequestBody Announcement announcement) {
        var result = this.announcementService.addNew(announcement);
        if (!result.isSuccess()) return new ErrorResult(result.getMessage());
        return result;
    }

    @GetMapping("/all")
    public DataResult<List<Announcement>> listAll() {
        return this.announcementService.listAll();
    }

    @GetMapping("/allByCorp")
    public DataResult<List<Announcement>> listAllByCorp(@RequestParam String corpName) {
        return this.announcementService.listAllByCorpName(corpName);
    }

    @GetMapping("/allByExDate")
    public DataResult<List<Announcement>> listAllByExDate() {
        return this.announcementService.findAllByExDateGreaterThan(LocalDate.now());
    }

    @PutMapping("/modify/{id}")
    public Result modify(@PathVariable Short id) {
        var ann = this.announcementService.getById(id);
        //ann.getData().setStatus(false);
        this.announcementService.modify(ann.getData());
        return new SuccessResult();
    }

    @ModelAttribute
    public List<City> getCities() {
        return this.cityService.listAllCities().getData();
    }

    @ModelAttribute
    public List<Position> getPositions() {
        return this.positionService.allPositions().getData();
    }
}
