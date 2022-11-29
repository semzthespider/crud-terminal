package com.project.terminal.crudterminal.repository;

import com.project.terminal.crudterminal.entity.KaryawanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository <KaryawanEntity, Integer> {
}
