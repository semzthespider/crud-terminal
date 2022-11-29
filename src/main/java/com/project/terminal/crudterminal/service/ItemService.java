package com.project.terminal.crudterminal.service;

import com.project.terminal.crudterminal.dao.Helper;
import com.project.terminal.crudterminal.entity.ItemEntity;
import com.project.terminal.crudterminal.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Scanner;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void doSomething() throws ParseException {
        System.out.println("Welcome");
        Scanner input = new Scanner(System.in);
        System.out.println("ID Barang : ");
        Long id = input.nextLong();
        System.out.println("Nama Barang : ");
        String namaItem = input.next();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Harga Barang : ");
        String harga = input2.nextLine();
        barang(new ItemEntity(id,namaItem,harga));
        Helper.backToMenu();

    }

    private void barang(ItemEntity itemEntity){
        System.out.println(itemEntity);
        itemRepository.save(itemEntity);
    }
}
