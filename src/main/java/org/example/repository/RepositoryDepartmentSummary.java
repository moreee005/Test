package org.example.repository;

import org.example.model.DepartmentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDepartmentSummary extends JpaRepository<DepartmentSummary, Integer> {
}
