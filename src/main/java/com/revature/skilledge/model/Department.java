package com.revature.skilledge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy ="department", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees;

}


//Hiberanate --- ORM

