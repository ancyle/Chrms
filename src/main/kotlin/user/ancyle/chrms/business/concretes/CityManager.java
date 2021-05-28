package user.ancyle.chrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.CityService;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessDataResult;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.dataAccess.abstracts.CityRepo;
import user.ancyle.chrms.entities.concretes.City;

import java.util.List;

@Service
public class CityManager  implements CityService {
    private final CityRepo cityRepo;

@Autowired
    public CityManager(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public DataResult<List<City>> listAllCities() {
        return new SuccessDataResult<>(this.cityRepo.findAll());
    }

    @Override
    public Result addNewCity(City city) {
    this.cityRepo.save(city);
        return new SuccessResult();
    }
}
