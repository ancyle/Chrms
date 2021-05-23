package user.ancyle.chrms.business.concretes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.UserService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.result.*;
import user.ancyle.chrms.dataAccess.abstracts.UserRepo;
import user.ancyle.chrms.entities.concretes.JobSeeker;
import user.ancyle.chrms.entities.concretes.User;

import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserManager(UserRepo userRepo){this.userRepo=userRepo;}

    @NotNull
    @Override
    public Result newUser(@NotNull User user) {
        this.userRepo.save(user);
        return new SuccessResult(Messages.success);
    }

    @NotNull
    @Override
    public DataResult<List<User>> allUsers() {
        return new SuccessDataResult<>(this.userRepo.findAll(),Messages.success);
    }

    @NotNull
    @Override
    public Result getUserByMail(@NotNull String mail) {
        var result=this.userRepo.existsUserByUserMail(mail);
        if(!result) return  new ErrorResult(Messages.userExists);
        return new SuccessResult();
    }
}
