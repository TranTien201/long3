package com.example.long3.Service;

import com.example.long3.Model.Content;
import com.example.long3.Repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentImpl implements ContentService{
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    ServiceImpl service;
    @Override
    public void addContent(Content c, String memberID) {
        String date = service.getDateTime();
        Content content = new Content(c.getTitle(), c.getBrief(), c.getContent(), date, date, memberID);
        contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContentByID(String authorID) {
        return contentRepository.listAllContentByID(authorID);
    }
}
