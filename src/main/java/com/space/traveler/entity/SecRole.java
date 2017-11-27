package com.space.traveler.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sec_role")
public class SecRole implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "title", nullable = false, length = 36)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sec_roles_sec_users",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "user_id"})})
    private Set<SecUser> users;


    public SecRole() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SecUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SecUser> users) {
        this.users = users;
    }
}
