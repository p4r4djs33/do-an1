package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "checklist")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numberImport;
    private Long numberBegin;
    private Long numberEnd;
    private String dateCreated;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;


    public Checklist() {
    }

    public Checklist(Long id, Long numberImport, Long numberBegin, Long numberEnd, String dateCreated, Employee employee, List<Ingredient> ingredients) {
        this.id = id;
        this.numberImport = numberImport;
        this.numberBegin = numberBegin;
        this.numberEnd = numberEnd;
        this.dateCreated = dateCreated;
        this.employee = employee;
        this.ingredients = ingredients;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getNumberImport() {
        return numberImport;
    }

    public void setNumberImport(Long numberImport) {
        this.numberImport = numberImport;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getNumberBegin() {
        return numberBegin;
    }

    public void setNumberBegin(Long numberBegin) {
        this.numberBegin = numberBegin;
    }

    public Long getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(Long numberEnd) {
        this.numberEnd = numberEnd;
    }
}
