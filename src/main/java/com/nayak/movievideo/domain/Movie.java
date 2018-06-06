package com.nayak.movievideo.domain;

import javax.persistence.*;

/**
 * Created by nayak on 2018. 6. 3..
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String movieTitle;
    @Column
    private String posterImageUrl;
    @Column
    private String crawlingDate;

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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", posterImageUrl='" + posterImageUrl + '\'' +
                ", crawlingDate='" + crawlingDate + '\'' +
                '}';
    }
}
