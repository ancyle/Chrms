package user.ancyle.chrms.business.concretes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.EmployerService;
import user.ancyle.chrms.business.abstracts.UserService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.business.RuleVerifier;
import user.ancyle.chrms.core.utilities.result.*;
import user.ancyle.chrms.dataAccess.abstracts.EmployerRepo;
import user.ancyle.chrms.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerRepo employerRepo;
    private final UserService userService;

    @Autowired
    public EmployerManager(EmployerRepo employerRepo,UserService userService){
        this.employerRepo=employerRepo;
        this.userService=userService;
    }

    @NotNull
    @Override
    public Result newEmployer(@NotNull Employer employer,String password) {
        var result= RuleVerifier.Companion.verify(checkCorpMailIsValid(employer),
                checkUserPassMatches(employer,password));
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        this.employerRepo.save(employer);
        return new SuccessResult(Messages.success);
    }

    @NotNull
    @Override
    public DataResult<List<Employer>> listAllEmployers() {
        return new SuccessDataResult<>(this.employerRepo.findAll(),Messages.success);
    }

    private Result checkCorpMailIsValid(Employer employer){
        var result=employer.getUser().getUserMail().contains(employer.getCorpName());
        if(!result) return new ErrorResult(Messages.corpMailInvalid);
        return new SuccessResult();
    }

    private Result checkUserPassMatches(Employer employer,String password){
        var result=employer.getUser().getUserPass().equals(password);
        if(!result) return new ErrorResult(Messages.passwordFail);
        return new SuccessResult();
    }

    private Result checkUserAlreadyExists(Employer employer){
        var result=userService.getUserByMail(employer.getUser().getUserMail());
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        return new SuccessResult();
    }
}
