package l.godefroy.Api.controller;
import l.godefroy.Api.service.UserServiceImpl;
import l.godefroy.Api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    //@Qualifier("clientService")
    public void setUserService(UserServiceImpl userService){
        this.userService=userService;
    }

    @GetMapping("/User")
    public List<User> find() {
        return userService.find();
    }

    @PostMapping("/User")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "Nouvel pari ajouté";
    }

    @PostMapping("/User/{username}")
    public List<User> findUsername(@PathVariable String username){
        return userService.findUsername(username);
    }

    @PutMapping("/User/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody Map<String, Object> payload){
        return userService.updateUser(id, (int) payload.get("points"));
    }

    @DeleteMapping("/User/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long idUser){
        userService.delete(idUser);
    }
}
