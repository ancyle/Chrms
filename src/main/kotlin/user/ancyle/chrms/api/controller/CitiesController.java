package user.ancyle.chrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.ancyle.chrms.business.abstracts.CityService;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CitiesController {
    private final CityService cityService;
@Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/all")
    public DataResult<List<City>> listAll(){
    return this.cityService.listAllCities();
    }

    @PostMapping("/new")
    public Result addNew(City city){
    return this.cityService.addNewCity(city);
    }
}
