package user.ancyle.chrms.business.concretes;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ancyle.chrms.business.abstracts.ConfirmationService;
import user.ancyle.chrms.business.abstracts.JobSeekerService;
import user.ancyle.chrms.core.utilities.mail.MailService;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.dataAccess.abstracts.ConfirmationRepo;
import user.ancyle.chrms.entities.concretes.Confirmation;
import user.ancyle.chrms.entities.concretes.User;
@Service
public class ConfirmationManager implements ConfirmationService {

    private final ConfirmationRepo confirmationRepo;
    private final MailService mailService;
    private final JobSeekerService jobSeekerService;

    @Autowired
    public ConfirmationManager(ConfirmationRepo confirmationRepo,MailService mailService,JobSeekerService jobSeekerService) {

        this.mailService=mailService;
        this.confirmationRepo = confirmationRepo;
        this.jobSeekerService=jobSeekerService;
    }

    @NotNull
    @Override
    public Result newConfirmation(User user) {
        Confirmation confirmation=new Confirmation();
        confirmation.setToken(mailService.createToken());
        confirmation.setUser(user);
        this.confirmationRepo.save(confirmation);
        mailService.sendMail(user.getUserMail(),confirmation.getToken());
        return new SuccessResult();
    }

    @Override
    public Confirmation findByToken(@NotNull String token) {
        var result=this.confirmationRepo.getConfirmationByToken(token);
        if(result==null) return null;
        return result;
    }

    @Override
    public void verifyAccount(Confirmation confirmation) {
        confirmation.setMailVerify(true);
        this.confirmationRepo.save(confirmation);
    }
}
