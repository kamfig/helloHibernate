package pl.kamilF.helloHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userDao;

    @GetMapping("/")
    public String add(ModelMap modelMap){
        modelMap.put("user",new User());
        return "add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/all";
    }
    @GetMapping("/all")
    public String getAll(ModelMap modelMap){
        modelMap.put("users",userDao.findAll());
        return "all2";
    }

}
