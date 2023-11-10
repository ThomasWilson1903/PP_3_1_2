package com.example.pp_3_1_2.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255, nullable = false)
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "error firstName")
    @NotNull(message = "not NULL")
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "error lastName")
    @NotNull(message = "not NULL")
    private String lastName;

    @Column(name = "email", length = 255, nullable = false)
    @Email(message = "error e-mail")
    @NotNull(message = "not NULL")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
