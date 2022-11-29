package com.project.terminal.crudterminal.repository;

import com.project.terminal.crudterminal.entity.AbsenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenRepository extends JpaRepository<AbsenEntity, Long> {
}
