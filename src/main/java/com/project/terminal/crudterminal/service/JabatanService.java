package com.project.terminal.crudterminal.service;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.entity.JabatanEntity;
import com.project.terminal.crudterminal.repository.JabatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class JabatanService {

    @Autowired
    private JabatanRepository jabatanRepository;
    public JabatanService(JabatanRepository jabatanRepository) {
        this.jabatanRepository = jabatanRepository;
    }

    public void jabatanKaryawan() throws ParseException {
        Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println("Id Jabatan :");
            Integer idJbtn = input2.nextInt();

            System.out.println("Jabatan Karyawan :");
            String jabatanKaryawan =input.next();


            Integer idAtasan=foundAtasanAgain();
            JabatanEntity jabatans=new JabatanEntity(Long.valueOf(idJbtn),jabatanKaryawan, idAtasan);

            jabatan(jabatans);
            Helper.backToMenu();
    }


    private void jabatan(JabatanEntity jabatanEntity){
        System.out.println(jabatanEntity);
        jabatanRepository.save(jabatanEntity);
    }

    private boolean checkIdAtasan(Integer idJabatan){
        Optional<JabatanEntity> cekId = jabatanRepository.findById(Long.valueOf(idJabatan));
        return cekId.isPresent()?true:false;
    }

    private Integer foundAtasanAgain() throws ParseException {
        System.out.println("Id Jabatan Atasan :");
        Scanner input3 = new Scanner(System.in);
        Integer idAtasan = input3.nextInt();
        Boolean findOrNot=checkIdAtasan(idAtasan);
        if(!findOrNot){
            System.out.println("id Jabatan tidak ditemukan");
            System.out.println("Berikut saran id Jabatan yang ada");
            List<JabatanEntity>saranJabatan=jabatanRepository.findAll();
            for (JabatanEntity entity:saranJabatan) {
                System.out.print("ID Jabatan:"+entity.getIdJabatan()+"\t");
                System.out.println("Nama Jabatan:"+entity.getNamaJabatan());
            }
            System.out.print("bila tidak ingin memilih tekan 0");
            Integer input=input3.nextInt();
            if(input==0){
                Helper.backToMenu();
            }
            foundAtasanAgain();

        }
        return idAtasan;
    }

    public void getJabatanKaryawan() throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Id Jabatan :");
        Long idJabatan = input.nextLong();
        Long cekId = jabatanRepository.findById(idJabatan).get().getIdJabatan();
        String nama = jabatanRepository.findById(idJabatan).get().getNamaJabatan();
        if (cekId != null) {
            System.out.println("Jabatan Atasan :" + nama);
        }else{
            System.out.println("tidak terdaftar");
        }
        Helper.backToMenu();

    }


}
