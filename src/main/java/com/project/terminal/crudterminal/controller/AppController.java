package com.project.terminal.crudterminal.controller;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.service.AbsenService;
import com.project.terminal.crudterminal.service.ItemService;
import com.project.terminal.crudterminal.service.JabatanService;
import com.project.terminal.crudterminal.service.KaryawanService;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Scanner;

@Controller
public class AppController {

    private static ItemService itemService;
    private static AbsenService absenService;
    private static JabatanService jabatanService;
    private static KaryawanService karyawanService;


    public AppController(ItemService itemService, JabatanService jabatanService, KaryawanService karyawanService, AbsenService absenService) {
        this.itemService = itemService;
        this.jabatanService = jabatanService;
        this.karyawanService = karyawanService;
        this.absenService = absenService;
    }

    public static void showProses() throws ParseException {
        System.out.println("=== TODO LIST APP ===");
        System.out.println("[1] Tambah Item");
        System.out.println("[2] Tambah Jabatan List");
        System.out.println("[3] Tambah Karyawan List");
        System.out.println("[4] Absen Karyawan");
        System.out.println("[5] Get Jabatan");
        System.out.println("[0] Keluar");
        System.out.println("---------------------");
        System.out.print("Pilih Operasi APP => ");

        Scanner input = new Scanner(System.in);
        String selectedOpsi = input.nextLine();
        if (selectedOpsi.equals("1")) {
            System.out.println("[1] Singgle");
            System.out.println("[2] Multiple");
            Scanner input2 = new Scanner(System.in);
            String klik = input2.nextLine();
            System.out.println("Ketik Angka :");
            if(klik.equals("1")){
                System.out.println("Berapa banyak data yang akan dimasukan :");
                Scanner dataInput = new Scanner(System.in);
                Integer klik3  = dataInput.nextInt();

                Integer data = klik3;
                switch(data) {
                    case 1:
                        itemService.doSomething();
                        break;
                    case 2:
                        itemService.doSomething();
                        break;
                    case 3:
                        itemService.doSomething();
                        break;
                    case 4:
                        itemService.doSomething();
                        break;
                    case 5:
                        itemService.doSomething();
                        break;
                    default:
                        System.out.println("Anda tidak memilih berhenti");
                }
            }else if (klik.equals("2")){
                System.out.println("multiple");
            }


        } else if (selectedOpsi.equals("2")) {
            jabatanService.jabatanKaryawan();
        } else if (selectedOpsi.equals("3")) {
            karyawanService.karyawanToko();
        } else if (selectedOpsi.equals("4")) {
            absenService.absenJbtn();
        } else if (selectedOpsi.equals("5")) {
            jabatanService.getJabatanKaryawan();
        } else if (selectedOpsi.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("Kamu salah pilih Operasi!");
            Helper.backToMenu();
        }
    }

}
