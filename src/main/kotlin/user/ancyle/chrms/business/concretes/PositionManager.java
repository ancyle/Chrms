package user.ancyle.chrms.business.concretes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.PositionService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.business.RuleVerifier;
import user.ancyle.chrms.core.utilities.result.*;
import user.ancyle.chrms.dataAccess.abstracts.PositionRepo;
import user.ancyle.chrms.entities.concretes.Position;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionRepo positionRepo;

    @Autowired
    public PositionManager(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    @NotNull
    @Override
    public DataResult<List<Position>> allPositions() {
        return new SuccessDataResult<>(positionRepo.findAll(), Messages.success);
    }

    @NotNull
    @Override
    public Result newPosition(@NotNull Position position) {
        var result = RuleVerifier.Companion.verify(checkIfPositionNameExists(position.getPositionName()));
        if (!result.isSuccess()) return new ErrorResult(result.getMessage());
        positionRepo.saveAndFlush(position);
        return new SuccessResult(Messages.success);
    }

    //Business Rules

    private Result checkIfPositionNameExists(String positionName) {
        var result = this.positionRepo.existsByPositionName(positionName);
        if (result) return new ErrorResult(Messages.positionNameExists);
        return new SuccessResult();
    }
}
