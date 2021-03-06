package com.it_academyproject.domains;

import com.fasterxml.jackson.annotation.JsonView;
import com.it_academyproject.exceptions.EmptyFieldException;
import com.it_academyproject.tools.View;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends MyAppUser {
	
	@JsonView(View.Summary.class)
	private String lastDeliveredExercise;
	
    @JsonView(View.Summary.class)
    @ManyToOne
    private Seat seat;

    public Student() {
        super();
        this.setRole(Role.STUDENT);
    }

    public Student(String firstName, String lastName, String email, char gender, String portrait, String password, boolean enabled) {
        super(firstName, lastName, email, gender, password, enabled, Role.STUDENT);
    }

    public Student(String email, String password) throws EmptyFieldException {
        super(email, password);
        this.setRole(Role.STUDENT);
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

	public String getLastDeliveredExercise()
	{
		return lastDeliveredExercise;
	}

	public void setLastDeliveredExercise(String lastDeliveredExercise)
	{
		this.lastDeliveredExercise = lastDeliveredExercise;
	}

    
}
