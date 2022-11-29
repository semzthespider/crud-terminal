package com.project.terminal.crudterminal.repository;

import com.project.terminal.crudterminal.entity.JabatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanRepository extends JpaRepository<JabatanEntity, Long> {
}
