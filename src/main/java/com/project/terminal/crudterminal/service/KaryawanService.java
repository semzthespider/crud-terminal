package com.project.terminal.crudterminal.service;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.entity.KaryawanEntity;
import com.project.terminal.crudterminal.repository.KaryawanRepository;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.*;

@Service
public class KaryawanService {
    private List<KaryawanEntity> karyawanEntities;

    public List<KaryawanEntity> karyawan(){
        return karyawanRepository.findAll();
    }
    private KaryawanRepository karyawanRepository;

    public KaryawanService(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public KaryawanEntity inputData() throws ParseException {
        Scanner input = new Scanner(System.in);
        Integer idKaryawan = karyawanNewInput();

        System.out.println("Nama Karyawan :");
        String namaKaryawan = input.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Tanggal Join");
        String tanggalJoin = input2.nextLine();

        System.out.println("Id Jabatan :");
        Long idJabatan = Long.valueOf(input2.next());

        return new KaryawanEntity(idKaryawan, namaKaryawan, tanggalJoin, idJabatan);
    }

    public void multipleKaryawan() throws ParseException {
        System.out.println("Mau input berapa data :");
        Scanner input = new Scanner(System.in);
        Integer sumData = input.nextInt();
        List<KaryawanEntity> karyawanEntityList=new ArrayList<>();
        if(sumData==0){
            KaryawanEntity karyawan=inputData();
            karyawanEntityList.add(karyawan);
        }else{
            doActionInputMoreData(karyawanEntityList,1,sumData);
        }
        int i=1;
        for (KaryawanEntity entity:karyawanEntityList) {
            System.out.println("data number:"+i);
            System.out.println("id:"+entity.getIdKaryawan());
            System.out.println("Nama Karyawan:"+entity.getNamaKaryawan());
            System.out.println("Tanggal Join:"+entity.getTanggalJoin());
            System.out.println("id Jabatan Atasan:"+entity.getIdJabatan());
            i++;
        }


    }

    public void doActionInputMoreData(List<KaryawanEntity> karyawanEntities,Integer curData,Integer sumData) throws ParseException {
        if(curData!=sumData){
            KaryawanEntity karyawan=inputData();
            karyawanEntities.add(karyawan);
            Scanner input = new Scanner(System.in);
            System.out.println("kalau mau lanjut tekan angka selain 0 kalau ngga tekan 0 ya tolol");
            Integer mauLanjut=input.nextInt();
            if(mauLanjut==0){
                curData=sumData;
            }else{
                curData++;
            }
            doActionInputMoreData(karyawanEntities,curData,sumData);
        }
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
                Helper.backToMenu();
            }
            System.out.println("Bila tidak ingin memilih tekan 0");
            Integer inputData = input3.nextInt();
            if(inputData==0){
                Helper.backToMenu();
            }

        }
        return idKaryawan;
    }

//    public List<KaryawanEntity> saveDataKaryawan(List<KaryawanEntity> karyawanEntities) {
//        List<KaryawanEntity> getKaryawanInput = karyawanRepository.findAll();
//        for(KaryawanEntity entity:getKaryawanInput){
//            System.out.println("Id Karyawan :"+entity.getIdJabatan());
//            System.out.println("Nama Karyawan : "+entity.getNamaKaryawan());
//            System.out.println("Tanggal Join: "+entity.getNamaKaryawan());
//            System.out.println("Id Jabatan: "+entity.getNamaKaryawan());
//        }
//        return karyawanRepository.saveAll(karyawanEntities);
//    }




}
