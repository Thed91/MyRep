package javarush.test.crud.controller;

import javarush.test.crud.model.User;
import javarush.test.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    private static final int MAX_RECORDS=10;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listUsers(@RequestParam(value = "page",defaultValue = "0",required = false)int page,Model model){
        model.addAttribute("user",new User());
        model.addAttribute("userList",userService.listUsers(MAX_RECORDS,page));
        model.addAttribute("page",page);
        model.addAttribute("records",userService.getRecords());
        return "users";
    }

    @RequestMapping(value = "/users/add",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")User user){
        if (user.getId()==null){
            userService.addUser(user);
        }else userService.updateUser(user);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/edit/{id}")
    public String editUser(@RequestParam(value = "page", defaultValue = "0",required = false)int page,@PathVariable("id")int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        model.addAttribute("userList",userService.listUsers(MAX_RECORDS,page));
        model.addAttribute("page",page);
        model.addAttribute("records",userService.getRecords());
        return "users";
    }
    @RequestMapping(value = "/search")
    public String searchUsers(@RequestParam("searchName") String searchName,Model model){
        if (searchName!=null){
            List<User> searchList = userService.searchUsers(searchName);
            model.addAttribute("searchList",searchList);
        }
        return "search";
    }
}
