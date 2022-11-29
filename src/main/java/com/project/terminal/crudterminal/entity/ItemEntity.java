package com.project.terminal.crudterminal.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity {
    @Id
    @Column(name = "id_item")
    Long id;
    @Column(name = "nama_item")
    String namaItem;
    @Column(name = "harga")
    String harga;

}
