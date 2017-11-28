package com.space.traveler.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Report> reports;

    @ManyToOne(fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Coordinates coordinates;

    @Column(name = "resolved")
    private Boolean resolved;


}
