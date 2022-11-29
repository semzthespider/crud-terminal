package com.project.terminal.crudterminal.service;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.entity.KaryawanEntity;
import com.project.terminal.crudterminal.repository.KaryawanRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class KaryawanService {
    public List<KaryawanEntity> karyawan(){
        return karyawanRepository.findAll();
    }
    private KaryawanRepository karyawanRepository;

    public KaryawanService(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public void inputData() throws ParseException {
        Scanner input = new Scanner(System.in);
        Integer idKaryawan = karyawanNewInput();

        System.out.println("Nama Karyawan :");
        String namaKaryawan = input.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Tanggal Join");
        String tanggalJoin = input2.nextLine();

        System.out.println("Id Jabatan :");
        Long idJabatan = Long.valueOf(input2.next());
    }

    public void multipleKaryawan() throws ParseException {
        Integer i;
        for(i=1; i<5; i++){
            inputData();
        }
    }

    public List<KaryawanEntity> saveDataKaryawan(KaryawanEntity karyawanEntity) throws ParseException {
        return karyawanRepository.save(karyawanEntity);
    }

    public boolean checkKaryawan(Integer idKaryawan ){
        Optional<KaryawanEntity> checkIdKaryawan= karyawanRepository.findById(idKaryawan);
        return checkIdKaryawan.isPresent()?true:false;
    }

    private void karyawan(KaryawanEntity karyawanEntity){
        System.out.println(karyawanEntity);
        karyawanRepository.save(karyawanEntity);
    }

    private Integer karyawanNewInput() throws ParseException {
        System.out.println("Id Karyawan");
        Scanner input3 = new Scanner(System.in);
        Integer idKaryawan = input3.nextInt();
        Boolean findOrNot = checkKaryawan(idKaryawan);
        if(findOrNot){
            System.out.println("Id karyawan sudah digunakan");
            System.out.println("Berikut id karyawan yang sudah ada");
            List<KaryawanEntity> saranJabatan = karyawanRepository.findAll();
            for(KaryawanEntity entity:saranJabatan){
                System.out.println("Id Karyawan :"+entity.getIdJabatan());
                System.out.println("Nama Karyawan : "+entity.getNamaKaryawan());
            }
            System.out.println("Bila tidak ingin memilih tekan 0");
            Integer inputData = input3.nextInt();
            if(inputData==0){
                Helper.backToMenu();
            }

        }
        return idKaryawan;
    }




}
