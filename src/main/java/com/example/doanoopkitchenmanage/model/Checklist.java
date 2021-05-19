package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checklist")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Long numberImport;
    @OneToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

    private Long numberBegin;
    private Long numberEnd;

    public Checklist() {
    }

    public Checklist(Long id, Employee employee, Long numberImport, List<Ingredient> ingredients, Long numberBegin, Long numberEnd) {
        this.id = id;
        this.employee = employee;
        this.numberImport = numberImport;
        this.ingredients = ingredients;
        this.numberBegin = numberBegin;
        this.numberEnd = numberEnd;
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
