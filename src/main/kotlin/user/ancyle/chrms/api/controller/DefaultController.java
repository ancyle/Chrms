package user.ancyle.chrms.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class DefaultController {

    private final List<String> commands;

    public DefaultController(){
        this.commands=new ArrayList<>();
        commands.add("Try the commands below :");
        commands.add("To Show Data");
        commands.add("List Positions : /app/positions/all");
        commands.add("List Users : /app/users/all");
        commands.add("List Employers : /app/users/all/emp");
        commands.add("List JobSeekers : /app/users/all/js");
        commands.add("List Moderators : /app/users/all/mod");
        commands.add("To Add New Data");
        commands.add("New Position : /app/positions/new");
        commands.add("New User : /app/users/new/usr");
        commands.add("New Employer : /app/users/new/emp");
        commands.add("New Moderator : /app/users/new/mod");
        commands.add("New JobSeeker : /app/users/new/js");
    }

    @GetMapping("/")
    public List<String> getHome(){
        return commands;
    }
}
