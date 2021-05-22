package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee", schema = "kitchen-manage-do-an")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_contact")
    private String numberContact;
    @Column(name = "shift")
    private String shift;
    @Column(name = "salary")
    private String salary;
    @OneToMany(targetEntity = Checklist.class)
    private List<Checklist> checklists;
    @OneToMany(targetEntity = MainIngredient.class)
    private List<MainIngredient> mainIngredients;

    public Employee() {
    }

    public Employee(Long id, String name, String numberContact, String shift, String salary) {
        this.id = id;
        this.name = name;
        this.numberContact = numberContact;
        this.shift = shift;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }
}
