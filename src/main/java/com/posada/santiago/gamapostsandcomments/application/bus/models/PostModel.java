package com.posada.santiago.gamapostsandcomments.application.bus.models;

public class PostModel {

    private String aggregateId;
    private String author;
    private String title;

    public PostModel(String aggregateId, String author, String title) {
        this.aggregateId = aggregateId;
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "postId='" + aggregateId + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public PostModel(PostModel fromJson) {
    }
}
