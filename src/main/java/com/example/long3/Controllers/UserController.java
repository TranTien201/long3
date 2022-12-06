package com.example.long3.Controllers;

import com.example.long3.Model.Content;
import com.example.long3.Model.User;
import com.example.long3.Service.ContentImpl;
import com.example.long3.Service.ContentService;
import com.example.long3.Service.ServiceImpl;
import com.example.long3.Service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "")
public class UserController {
    @Autowired
    UserImpl user;
    @Autowired
    ServiceImpl service;
    @Autowired
    ContentImpl content;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homeUserPage(ModelMap modelMap,
                               HttpSession session) {
        boolean checkLogin = service.checkLogin(session);
        if(checkLogin) {
            String memberID = (String) session.getAttribute("memberID");

            List<Content> listContent = content.getAllContentByID(memberID);
            modelMap.addAttribute("listContent", listContent);
            return "user";
        }
        return "redirect:/login/login-form";
    }

    @RequestMapping(value = "/user/user-profile/{id}", method = RequestMethod.GET)
    public String profileByID(ModelMap modelMap, @PathVariable("id") String memberID) {
        Optional<User> user1 = user.getUserByID(memberID);
        modelMap.addAttribute("user", user1.get());
        modelMap.addAttribute("User", new User());
        return "profile";
    }

    @RequestMapping(value = "/user/user-update/{memberID}", method = RequestMethod.POST)
    public String updateUserByID(ModelMap modelMap,
                                 @ModelAttribute("User") User u,
                                 @PathVariable("memberID") String memberID) {
        if(user.getUserByID(memberID).isPresent()) {
            User user1 = user.getUserByID(memberID).get();
            if(u.getFirstName() != null) {
                user1.setFirstName(u.getFirstName());
            }
            if(u.getLastName() != null) {
                user1.setLastName(u.getLastName());
            }
            if(u.getPhone() != null) {
                user1.setPhone(u.getPhone());
            }
            if(u.getDescription() != null) {
                user1.setDescription(u.getDescription());
            }
            user1.setUpdateTime(service.getDateTime());
            user.updateUser(user1);
        }

        return "redirect:/user/user-profile/" + memberID;
    }
}
