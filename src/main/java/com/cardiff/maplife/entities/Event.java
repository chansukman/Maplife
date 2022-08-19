package com.cardiff.maplife.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")


@Component
public class Event {
    public Event() {

    }
    public Event(Long id, long host_id, String event_link, String title, double longitude, double latitude, boolean room_type, Date event_date, String event_dis) {
        this.id = id;
        this.host_id = host_id;
        this.event_link = event_link;
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.room_type = room_type;
        this.event_date = event_date;
        this.event_dis = event_dis;
    }

    public Event(Long host_id, String event_title) {
        this.host_id = host_id;
        this.title = event_title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "eventId")
    private Long id;

    public Long getId() {
        return id;
    }

    public Long getHost_id() {
        return host_id;
    }

    public String getEvent_link() {
        return event_link;
    }

    public String getEvent_title() {
        return title;
    }

    public boolean isRoom_type() {
        return room_type;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public String getEvent_dis() {
        return event_dis;
    }

    @Column(name = "host_id")
    private Long host_id;
    @Column(name = "event_link")
    private String event_link;
    @Column(name = "event_title")
    private String title;
    @Column(name = "room_type")
    private boolean room_type;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "event_date")
    private Date event_date;
    @Column(name = "event_dis")
    private String event_dis;


    public void setId(Long id) {
        this.id = id;
    }

    public void setHost_id(Long host_id) {
        this.host_id = host_id;
    }

    public void setEvent_link(String event_link) {
        this.event_link = event_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRoom_type(boolean room_type) {
        this.room_type = room_type;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public void setEvent_dis(String event_dis) {
        this.event_dis = event_dis;
    }
}