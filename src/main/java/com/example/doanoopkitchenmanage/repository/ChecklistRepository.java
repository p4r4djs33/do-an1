package com.example.doanoopkitchenmanage.repository;

import com.example.doanoopkitchenmanage.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist,Long> {
}
