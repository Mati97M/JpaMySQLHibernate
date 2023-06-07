package org.example.models;

import java.io.Serializable;
import java.util.Objects;

public class ActorID implements Serializable {
    private String lastName;
    private String  dateOfBirth;

    public ActorID() {
    }

    public ActorID(String lastName, String dateOfBirth) {
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorID actorID = (ActorID) o;
        return Objects.equals(lastName, actorID.lastName) && Objects.equals(dateOfBirth, actorID.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, dateOfBirth);
    }

}
