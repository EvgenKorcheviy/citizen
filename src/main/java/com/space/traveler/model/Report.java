package com.space.traveler.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_report", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "report_id"))
    private User user;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "report_coordinates", joinColumns = @JoinColumn(name = "report_id"), inverseJoinColumns = @JoinColumn(name = "coordinates_id"))
    private Coordinates coordinates;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "comment")
    private String comment;

}
