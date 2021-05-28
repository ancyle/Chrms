package user.ancyle.chrms.api.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/")
@RestController
public class DefaultController {

    private final String[] commands;

    public DefaultController(){
        this.commands=new String[]{
                "Try the commands below :",
        "To Show Data",
        "List Positions : /app/positions/all",
        "List Users : /app/users/all",
        "List Employers : /app/users/all/emp",
        "List JobSeekers : /app/users/all/js",
        "List Moderators : /app/users/all/mod",
        "To Add New Data",
        "New Position : /app/positions/new",
        "New User : /app/users/new/usr",
        "New Employer : /app/users/new/emp",
        "New Moderator : /app/users/new/mod",
        "New JobSeeker : /app/users/new/js"
        };
    }

    @SneakyThrows
    @GetMapping("/")
    @ResponseBody
    public String[] getHome() {
        return commands;
    }
}
