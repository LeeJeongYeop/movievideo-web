package com.nayak.movievideo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nayak on 2018. 6. 3..
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "movie_title")
    private String movieTitle;
    @Column
    private String posterImageUrl;
    @Column
    private String crawlingDate;

    @OneToMany(targetEntity = Video.class, mappedBy = "movieTitle", fetch = FetchType.EAGER)
    private List<Video> videoList;

    public Movie() {}

    public Movie(String movieTitle, String posterImageUrl, String crawlingDate) {
        this.movieTitle = movieTitle;
        this.posterImageUrl = posterImageUrl;
        this.crawlingDate = crawlingDate;
    }

    public long getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPosterImageUrl() {
        return posterImageUrl;
    }

    public void setPosterImageUrl(String posterImageUrl) {
        this.posterImageUrl = posterImageUrl;
    }

    public String getCrawlingDate() {
        return crawlingDate;
    }

    public void setCrawlingDate(String crawlingDate) {
        this.crawlingDate = crawlingDate;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", posterImageUrl='" + posterImageUrl + '\'' +
                ", crawlingDate='" + crawlingDate + '\'' +
                ", videoList=" + videoList +
                '}';
    }
}
