package com.michaeldavidis.assignment.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @Size(min = 3, max = 25)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 3, max = 25)
    private String lastName;

    @Column(name = "subject")
    @Size(min = 1, max = 200)
    private String subject;

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Long getId() {
        return id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
