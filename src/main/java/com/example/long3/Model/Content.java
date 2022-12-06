package com.example.long3.Model;


import javax.persistence.*;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contentID")
    private int contentID;
    private String title;
    private String brief;
    private String content;
    private String createdDate;
    private String updateTime;
    private String authorID;

    public Content() {

    }

    public Content(int contentID, String title, String brief, String content, String createDate, String updateTime, String authorID) {
        this.contentID = contentID;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createdDate = createDate;
        this.updateTime = updateTime;
        this.authorID = authorID;
    }
    public Content(String title, String brief, String content, String createDate, String updateTime, String authorID) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createdDate = createDate;
        this.updateTime = updateTime;
        this.authorID = authorID;
    }
    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(String createDate) {
        this.createdDate = createDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
}
