package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningId;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private Long filmid;

//    @OneToMany(mappedBy = "screeningId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Booking booking;



    //test constructor
    @Autowired
    public Screening(Long screeningId, String time, Long filmid) {
        super();
        this.screeningId = screeningId;
        this.time = time;
        this.filmid = filmid;
    }

    //production constructor
    @Autowired
    public Screening(String time, Long filmid) {
        super();
        this.time = time;
        this.filmid= filmid;
    }

    public Long getscreeningId() {
        return screeningId;
    }

    public void setscreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public Long getfilmid() {
        return filmid;
    }

    public void setfilmid(Long filmid) {
        this.filmid = filmid;
    }

@Autowired
    //Default constructor
    public Screening() {

    }

    @Override
    public String toString() {
        return "Screening [id=" + screeningId + ", time=" + time + ", filmid=" + filmid + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening Screening = (Screening) o;
        return time == Screening.time && filmid == Screening.filmid && filmid.equals(Screening.filmid) && time.equals(Screening.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, filmid);
    }
}