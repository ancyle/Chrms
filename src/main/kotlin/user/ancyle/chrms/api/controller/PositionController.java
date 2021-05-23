package user.ancyle.chrms.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.ancyle.chrms.business.abstracts.PositionService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.ErrorResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.entities.concretes.Position;

import java.util.List;

@RestController
@RequestMapping("/app/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService){this.positionService=positionService;}

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataResult<List<Position>> getAllPositions() {
        return this.positionService.allPositions();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Result newPosition(@RequestBody Position position) {
        var result = this.positionService.newPosition(position);
        if (!result.isSuccess()) return new ErrorResult(Messages.failure);
        return result;
    }
}
