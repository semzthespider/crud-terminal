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
@Table(name = "karyawan")
public class KaryawanEntity {

    @Id
    @Column(name = "id_karyawan")
    Integer idKaryawan;
    @Column(name = "nama_karyawan")
    String namaKaryawan;
    @Column(name = "tanggal_join")
    String tanggalJoin;
    @Column(name = "id_jabatan")
    Long idJabatan;


}
