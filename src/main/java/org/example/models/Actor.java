package org.example.models;

import javax.persistence.*;

@Entity
@IdClass(ActorID.class)
@Table(name = "actors")
public class Actor {
    @Column(name = "first_name")
    private String firstName;
    @Id
    @Column(name = "last_name")
    private String lastName;
    @Id
    @Column(name = "date_of_birth")
    private String  dateOfBirth;
    private String gender;
    @Column(name = "wealth_mln$")
    private int wealthInMln;

    public Actor(String firstName, String lastName, String dateOfBirth, String gender, int wealthInMln) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.wealthInMln = wealthInMln;
    }

    public Actor() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public int getWealthInMln() {
        return wealthInMln;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWealthInMln(int wealthInMln) {
        this.wealthInMln = wealthInMln;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", wealthInMln=" + wealthInMln +
                '}';
    }
}
