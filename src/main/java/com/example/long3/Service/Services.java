package com.example.long3.Service;

import javax.servlet.http.HttpSession;

public interface Services {
    String getDateTime();

    boolean checkLogin(HttpSession session);
}
