package org.example;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.View.mainMenu;

public class Controller {

    public static Map<Integer, Karyawan> listKaryawan = new HashMap<Integer, Karyawan>();

    public static void insertKaryawan(){
        LocalDate DoB = LocalDate.parse("2001-01-01");
        listKaryawan.put(1, new Karyawan(1, "max", DoB, "Jl. Sudirman", true));
        LocalDate DoB2 = LocalDate.parse("2001-02-02");
        listKaryawan.put(2, new Karyawan(2, "ernest", DoB2, "Jl. Sudirman", true));
        LocalDate DoB3 = LocalDate.parse("2001-03-03");
        listKaryawan.put(3, new Karyawan(3, "riki", DoB3, "Jl. Sudirman", true));
        LocalDate DoB4 = LocalDate.parse("2001-04-04");
        listKaryawan.put(4, new Karyawan(4, "amoy", DoB4, "Jl. Sudirman", true));
    }

    public static void startView(){
        mainMenu();
        int input;
        // validate input
        while(true){
            input = inputInt();
            if (input >= 1  && input <= 4){
                break;
            }else{
                System.out.println("option not available !!");
            }
        }
        switch(input) {
            case 1:
                addView();
                break;
            case 2:
                deleteView();
                break;
            case 3:
                editView();
                break;
            case 4:
                listView();
                break;
        }
    }

    public static void addView(){
        System.out.print("Masukan Nama : ");
        String nama = inputString();

        System.out.print("Tanggal lahir dengan format (yyyy-mm-dd): ");
        String tanggal = inputString();

        System.out.print("Masukan Alamat : ");
        String alamat = inputString();

        System.out.print("Masukan status aktif (1/0) : ");
        int status = inputInt();

        int result = add(nama, tanggal, alamat, status);
        if (result == 1){
            System.out.println("Data karyawan baru berhasil ditambahkan");
        }else{
            System.out.println("Gagal menambahkan karyawan, silahkan coba lagi");
        }
        pressAnyKey();
        startView();
    }

    public static int add(String nama, String tanggal, String alamat, int statusInt){
        try{
            int id = Collections.max(listKaryawan.keySet())+1;
            LocalDate DoB = LocalDate.parse(tanggal);

            boolean status;
            if (statusInt == 1){
                status = true;
            }else if(statusInt == 0){
                status = false;
            }else {
                return 0;
            }

            listKaryawan.put(id, new Karyawan(id, nama, DoB, alamat, status));
            return 1;
        }catch(Exception e){
            return 0;
        }

    }

    public static void deleteView(){
        System.out.println("(Silahkan pilih id)");
        int id = inputInt();
        int result = delete(id);
        if (result == 1){
            System.out.println("Data Karyawan berhasil dihapus");
        }else{
            System.out.println("Data Karyawan gagal dihapus");
        }
        pressAnyKey();
        startView();
    }

    public static int delete(int key){
        if (listKaryawan.remove(key) != null){
            return 1;
        }else {
            return 0;
        }
    }

    public static void editView(){
        System.out.println("(Silahkan pilih id)");
        int id = inputInt();

        System.out.print("Masukan Nama : ");
        String nama = inputString();

        System.out.print("Tanggal lahir dengan format (yyyy-mm-dd): ");
        String tanggal = inputString();

        System.out.print("Masukan Alamat : ");
        String alamat = inputString();

        System.out.print("Masukan status aktif (1/0) : ");
        int status = inputInt();

        int result = edit(id, nama, tanggal, alamat, status);
        if (result == 1){
            System.out.println("Data karyawan berhasil diedit");
        }else{
            System.out.println("Gagal mengedit karyawan, silahkan coba lagi");
        }
        pressAnyKey();
        startView();
    }

    public static int edit(int key, String nama, String tanggal, String alamat, int statusInt){
        try{
            if (!listKaryawan.containsKey(key)){
                return 0;
            }
            LocalDate DoB = LocalDate.parse(tanggal);

            boolean status;
            if (statusInt == 1){
                status = true;
            }else if(statusInt == 0){
                status = false;
            }else {
                return 0;
            }

            listKaryawan.put(key, new Karyawan(key, nama, DoB, alamat, status));
            return 1;
        }catch(Exception e){
            return 0;
        }

    }

    public static void listView(){
        System.out.println("===============");
        System.out.println("LIST KARYAWAN");
        System.out.println("===============");
        for (Map.Entry<Integer, Karyawan> k : listKaryawan.entrySet()) {
            View.karyawanData(k.getValue());
        }
        pressAnyKey();
        startView();
    }

    public static String inputString(){
        Scanner userInput = new Scanner(System.in);
        String string = userInput.nextLine();
        return string;
    }


    public static int inputInt(){
        int inputChoice;
        while (true){
            try{
                System.out.print("=> ");
                Scanner input = new Scanner (System.in);
                inputChoice = input.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("Invalid choice");
            }
        }
        return inputChoice;
    }

    public static void pressAnyKey(){
        System.out.println("Press any key to continue ...");
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
    }
}
