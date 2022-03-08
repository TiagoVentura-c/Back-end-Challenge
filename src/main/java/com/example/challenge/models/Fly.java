package com.example.challenge.models;

import java.time.LocalDateTime;
import java.util.List;

public class Fly {
    private int id;
    private boolean feactured;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    private String summary;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

    private List<Launch> launches;
    private List<Event> events;

}
