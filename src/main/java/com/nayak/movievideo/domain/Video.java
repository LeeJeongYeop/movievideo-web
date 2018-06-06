package com.nayak.movievideo.domain;

import javax.persistence.*;

/**
 * Created by nayak on 2018. 6. 6..
 */
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String movieTitle;
    @Column
    private String videoId;
    @Column
    private String videoTitle;
    @Column
    private String videoDescription;
    @Column
    private String videoCoverImageUrl;
    @Column
    private String videoPublishedDate;

    public long getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getVideoCoverImageUrl() {
        return videoCoverImageUrl;
    }

    public void setVideoCoverImageUrl(String videoCoverImageUrl) {
        this.videoCoverImageUrl = videoCoverImageUrl;
    }

    public String getVideoPublishedDate() {
        return videoPublishedDate;
    }

    public void setVideoPublishedDate(String videoPublishedDate) {
        this.videoPublishedDate = videoPublishedDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", videoId='" + videoId + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoDescription='" + videoDescription + '\'' +
                ", videoCoverImageUrl='" + videoCoverImageUrl + '\'' +
                ", videoPublishedDate='" + videoPublishedDate + '\'' +
                '}';
    }
}
