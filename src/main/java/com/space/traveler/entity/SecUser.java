package com.space.traveler.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sec_user")
@NamedQueries({
        @NamedQuery(name = SecUser.FIND_BY_USERNAME,
                query = "FROM SecUser u WHERE u.username = :username")
})
public class SecUser implements Serializable {

    public static final String FIND_BY_USERNAME = "User.findByUsername";

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "username", nullable = false, length = 36)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    private String passwordConfirm;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "phone_number", length = 36)
    private String phoneNumber;

    @Column(name = "email", length = 36)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Set<SecRole> roles;

    @OneToOne(cascade = CascadeType.ALL)
    private SecUserDetails userDetails;



    public SecUser() {
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<SecRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SecRole> roles) {
        this.roles = roles;
    }

    public SecUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(SecUserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
