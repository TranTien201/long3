package com.example.long3.Controllers;

import com.example.long3.Service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "register")
public class RegisterController {
    @Autowired
    UserImpl user;
    @RequestMapping(value = "/register-form", method = RequestMethod.GET)
    public String registerForm() {
        return "register";
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String handelRegisterUser(ModelMap modelMap,
                                     @RequestParam("userName") String userName,
                                     @RequestParam("password") String password,
                                     @RequestParam("email") String email,
                                     @RequestParam("rePassword") String re_password,
                                     HttpSession session,
                                     HttpServletRequest request,
                                     RedirectAttributes redirectAttributes) {
        if(user.checkEmailExist(email)) {
            redirectAttributes.addFlashAttribute("error", "Email đã tồn tại");
            return "redirect:/register/register-form";
        } else if(!user.checkRePassword(password, re_password)) {
            redirectAttributes.addFlashAttribute("error", "Mật khẩu và mật khẩu nhập lại không hợp lệ");
            return "redirect:/register/register-form";
        }
        user.addUser(userName, email, password);
        session = request.getSession(true);
        session.setAttribute("userName", userName);
        session.setAttribute("memberID", "FPT" + user.countUserID());
        return "user";
    }
}
