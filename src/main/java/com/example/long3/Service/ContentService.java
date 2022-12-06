package com.example.long3.Service;


import com.example.long3.Model.Content;

import java.util.List;

public interface ContentService {
    void addContent(Content content, String memberID);

    List<Content> getAllContentByID(String memberID);
}
