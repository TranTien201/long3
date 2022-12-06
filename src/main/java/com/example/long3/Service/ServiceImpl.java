package com.example.long3.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceImpl implements Services {
    @Override
    public String getDateTime() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return current.format(formatter);
    }

    @Override
    public boolean checkLogin(HttpSession session) {
        boolean checkLogin = false;
        if(session.getAttribute("userName") != null) {
            checkLogin = true;
        }
        return checkLogin;
    }
}
