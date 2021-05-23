package user.ancyle.chrms.business.concretes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.ModeratorService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessDataResult;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.dataAccess.abstracts.ModeratorRepo;
import user.ancyle.chrms.entities.concretes.Moderator;

import java.util.List;

@Service
public class ModeratorManager implements ModeratorService {

    private final ModeratorRepo moderatorRepo;

    @Autowired
    public ModeratorManager(ModeratorRepo moderatorRepo){
        this.moderatorRepo=moderatorRepo;
    }

    @NotNull
    @Override
    public Result newModerator(@NotNull Moderator moderator) {
        this.moderatorRepo.save(moderator);
        return new SuccessResult(Messages.success);
    }

    @NotNull
    @Override
    public DataResult<List<Moderator>> listAllModerators() {
        return new SuccessDataResult<>(this.moderatorRepo.findAll(),Messages.success);
    }

    //Business Rules
}
