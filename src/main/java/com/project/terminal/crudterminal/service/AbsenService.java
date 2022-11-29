package com.project.terminal.crudterminal.service;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.entity.AbsenEntity;
import com.project.terminal.crudterminal.entity.JabatanEntity;
import com.project.terminal.crudterminal.entity.KaryawanEntity;
import com.project.terminal.crudterminal.repository.AbsenRepository;
import com.project.terminal.crudterminal.repository.KaryawanRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class AbsenService  {
    public AbsenService(AbsenRepository absenRepository, KaryawanService karyawanService) {
        this.absenRepository = absenRepository;
        this.karyawanService = karyawanService;
    }

    private AbsenRepository absenRepository;
    private KaryawanService karyawanService;
    private KaryawanRepository karyawanRepository;

    public void absenJbtn () throws ParseException {
        Scanner input = new Scanner(System.in);

        Integer idKaryawan = absenKaryawan();

        System.out.println("Nama Hari");
        String hari = input.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Jam Masuk");
        String jamMasuk = input2.nextLine();

        System.out.println("Jam Keluar");
        String jamKeluar = input2.nextLine();

        AbsenEntity absenKaryawan = new AbsenEntity(idKaryawan, hari, jamMasuk, jamKeluar);


        absen(absenKaryawan);
        Helper.backToMenu();
    }

    private void absen(AbsenEntity absenEntity){
        System.out.println(absenEntity);
        absenRepository.save(absenEntity);
    }


    private Integer absenKaryawan() throws ParseException {
        System.out.println("Id Karyawan");
        Scanner input12 = new Scanner(System.in);
        Integer karyawan = input12.nextInt();
        Boolean findOrNotAbsen = karyawanService.checkKaryawan(karyawan);
        if(!findOrNotAbsen){
            System.out.println("id Karyawan tidak ada di daftar karyawan");
            System.out.println("Berikut id karyawan yang terdaftar");
            List<KaryawanEntity> karyawanTerdaftar = karyawanService.karyawan();

            for(KaryawanEntity entities: karyawanTerdaftar){
                System.out.println("Id Karyawan"+entities.getIdKaryawan()+"\t");
                System.out.println("Nama Karyawan"+entities.getIdKaryawan());
            }
            System.out.println("ketik 0 bila ingin memilih kembali");
            Integer input2 = input12.nextInt();
            if(input2==0){
                Helper.backToMenu();
            }absenKaryawan();
        }
        return karyawan;
    }



}

