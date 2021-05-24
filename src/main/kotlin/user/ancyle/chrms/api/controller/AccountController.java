package user.ancyle.chrms.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.ancyle.chrms.business.abstracts.ConfirmationService;
import user.ancyle.chrms.business.abstracts.JobSeekerService;
import user.ancyle.chrms.core.utilities.mail.MailService;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.entities.concretes.Confirmation;

@RequestMapping("/")
@RestController
public class AccountController {

    private final MailService mailService;
    private final ConfirmationService confirmationService;

    @Autowired
    public AccountController(MailService mailService,ConfirmationService confirmationService){
        this.confirmationService=confirmationService;
        this.mailService=mailService;
    }

    @GetMapping("/confirm-account")
    public String confirmAccount(@RequestParam String token){
        var result=this.confirmationService.findByToken(token);
        if(result==null||result.isMailVerify()) return "User already activated or Token is invalid";
        confirmationService.verifyAccount(this.confirmationService.findByToken(token));
        return "Mail activation success.";
    }
}
