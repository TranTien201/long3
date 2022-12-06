package com.example.long3.Controllers;

import com.example.long3.Model.User;
import com.example.long3.Service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    UserImpl user;
    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public String loginForm() {
        return "login";
    }

    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public String handelLoginUser(ModelMap modelMap,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  HttpServletRequest request,
                                  HttpSession session){
        User u = user.loginUser(email, password);
        if(u != null) {
            session = request.getSession(true);
            session.setAttribute("userName", u.getUserName());
            session.setAttribute("memberID", u.getMemberID());
            return "redirect:/";
        }
        return "user";
    }
}
