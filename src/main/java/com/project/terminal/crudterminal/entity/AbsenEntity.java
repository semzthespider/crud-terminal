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
@Table(name = "absen")
public class AbsenEntity {
    @Id
    @Column(name= "id_karyawan")
    Integer idKaryawan;
    @Column(name= "hari")
    String hari;
    @Column(name = "jam_masuk")
    String jamMasuk;
    @Column(name = "jam_keluar")
    String jamKeluar;
}
