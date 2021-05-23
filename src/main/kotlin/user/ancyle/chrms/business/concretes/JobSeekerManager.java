package user.ancyle.chrms.business.concretes;

import com.sun.net.httpserver.Authenticator;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.JobSeekerService;
import user.ancyle.chrms.business.abstracts.UserService;
import user.ancyle.chrms.business.constants.Messages;
import user.ancyle.chrms.core.utilities.business.RuleVerifier;
import user.ancyle.chrms.core.utilities.identifier.mernis.GWOKPSPublicSoap;
import user.ancyle.chrms.core.utilities.result.*;
import user.ancyle.chrms.dataAccess.abstracts.JobSeekerRepo;
import user.ancyle.chrms.entities.concretes.JobSeeker;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerRepo jobSeekerRepo;
    private final UserService userService;

    @Autowired
    public JobSeekerManager
            (JobSeekerRepo jobSeekerRepo,UserService userService){

        this.jobSeekerRepo=jobSeekerRepo;
        this.userService=userService;
    }


    @NotNull
    @Override
    public Result newJobSeeker(@NotNull JobSeeker jobSeeker,String password) {
        var result= RuleVerifier.Companion.verify
                (verifyUserIdentityByMernis(jobSeeker),checkPasswordIsMatching(jobSeeker,password),
                        checkIfUserExist(jobSeeker));
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        this.jobSeekerRepo.save(jobSeeker);
        return new SuccessResult(Messages.success);
    }

    @NotNull
    @Override
    public DataResult<List<JobSeeker>> listAllJobSeekers() {

        return new SuccessDataResult<>(this.jobSeekerRepo.findAll(),Messages.success);
    }

    @SneakyThrows
    private Result verifyUserIdentityByMernis(JobSeeker jobSeeker) {
        GWOKPSPublicSoap soap=new GWOKPSPublicSoap();
        var result=soap.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()),jobSeeker.getFirstName(),jobSeeker.getLastName(),Integer.valueOf(jobSeeker.getBirthYear()));
        if(!result) return new ErrorResult(Messages.mernis);
        return new SuccessResult();
    }

    private Result checkPasswordIsMatching(JobSeeker jobSeeker,String password){
        var result=jobSeeker.getUser().getUserPass().equals(password);
        if(!result) return new ErrorResult(Messages.passwordFail);
        return new SuccessResult();
    }

    private Result checkIfUserExist(JobSeeker jobSeeker){
    var result=this.userService.getUserByMail(jobSeeker.getUser().getUserMail());
    if(result.isSuccess()) return new ErrorResult(result.getMessage());
    return new SuccessResult();
    }
}
