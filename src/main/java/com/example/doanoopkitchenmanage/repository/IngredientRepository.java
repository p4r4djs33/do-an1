package com.example.doanoopkitchenmanage.repository;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Iterable<Ingredient> findAllByChecklist(Checklist checklist);
}
