package com.example.long3.Controllers;

import com.example.long3.Model.Content;
import com.example.long3.Model.User;
import com.example.long3.Service.ContentImpl;
import com.example.long3.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "post")
public class ContentController {
    @Autowired
    ContentImpl content;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addPostForm(ModelMap modelMap) {
        modelMap.addAttribute("Content", new Content());
        return "content";
    }
    @RequestMapping(value = "/create-content/${memberID}", method = RequestMethod.POST)
    public String addPostByID(ModelMap modelMap,
                              @ModelAttribute("Content") Content c,
                              @PathVariable("memberID") String memberID) {
        content.addContent(c, memberID);
        return "redirect:/";
    }
}
