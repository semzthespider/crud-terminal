package com.project.terminal.crudterminal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jabatan")
public class JabatanEntity {
    @Id
    @Column(name = "id_jabatan")
    Long idJabatan;
    @Column(name = "nama_jabatan")
    String namaJabatan;
    @Column(name = "id_jabatan_atasan")
    Integer idJabatanAtasan;

}
