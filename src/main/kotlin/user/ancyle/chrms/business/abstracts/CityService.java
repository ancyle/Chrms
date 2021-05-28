package user.ancyle.chrms.business.abstracts;

import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> listAllCities();
    Result addNewCity(City city);
}
