package user.ancyle.chrms.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.ancyle.chrms.business.abstracts.*;
import user.ancyle.chrms.core.utilities.result.DataResult;
import user.ancyle.chrms.core.utilities.result.ErrorResult;
import user.ancyle.chrms.core.utilities.result.Result;
import user.ancyle.chrms.core.utilities.result.SuccessResult;
import user.ancyle.chrms.entities.concretes.*;

import java.util.List;

@RestController
@RequestMapping("/app/users")
public class UsersController {

    private final UserService userService;
    private final EmployerService employerService;
    private final JobSeekerService jobSeekerService;
    private final ModeratorService moderatorService;
    private final ConfirmationService confirmationService;

    @Autowired
    public UsersController
            (UserService userService,EmployerService employerService,
             JobSeekerService jobSeekerService,ModeratorService moderatorService,ConfirmationService confirmationService){
        this.employerService=employerService;
        this.userService=userService;
        this.jobSeekerService=jobSeekerService;
        this.moderatorService=moderatorService;
        this.confirmationService=confirmationService;
    }



    @GetMapping("/all")
    public DataResult<List<User>> listAllUsers(){
        return this.userService.allUsers();
    }

    @GetMapping("/all/emp")
    public DataResult<List<Employer>> listAllEmployers(){
        return this.employerService.listAllEmployers();
    }

    @GetMapping("/all/js")
    public DataResult<List<JobSeeker>> listAllJobSeekers(){
        return this.jobSeekerService.listAllJobSeekers();
    }

    @GetMapping("/all/mod")
    public DataResult<List<Moderator>> listAllModerators(){return this.moderatorService.listAllModerators();}

    @PostMapping("/new/emp")
    @ResponseBody
    public Result newEmployer(@RequestBody Employer employer,@RequestParam String password){
        var result=this.employerService.newEmployer(employer,password);
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        return new SuccessResult("Registration is success. Step 1: Verify your email.");
    }

    @PostMapping("/new/usr")
    @ResponseBody
    public Result newUser(@RequestBody User user){
        var result=this.userService.newUser(user);
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        return result;
    }

    @PostMapping("/new/js")
    @ResponseBody
    public Result newJobSeeker(@RequestBody JobSeeker jobSeeker, @RequestParam String password){
        var result=this.jobSeekerService.newJobSeeker(jobSeeker,password);
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        confirmationService.newConfirmation(jobSeeker.getUser());
        return new SuccessResult("Registration is success. Step 1: Verify your email.");
    }

    @PostMapping("/new/mod")
    @ResponseBody
    public Result newModerator(@RequestBody Moderator moderator){
        var result=this.moderatorService.newModerator(moderator);
        if(!result.isSuccess()) return new ErrorResult(result.getMessage());
        return result;
    }
}
