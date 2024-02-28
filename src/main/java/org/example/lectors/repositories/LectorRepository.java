package org.example.lectors.repositories;


import org.example.lectors.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
}