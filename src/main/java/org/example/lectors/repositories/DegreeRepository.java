package org.example.lectors.repositories;


import org.example.lectors.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}