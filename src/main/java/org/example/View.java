package org.example;

public class View {
    public static void mainMenu(){
        System.out.println("============================");
        System.out.println("APLIKASI MANAJEMEN KARYAWAN");
        System.out.println("============================");
        System.out.println("1. ADD");
        System.out.println("2. DELETE");
        System.out.println("3. EDIT");
        System.out.println("4. VIEW LIST");
        System.out.println("4. EXIT");
    }

    public static void karyawanData(Karyawan k){
        System.out.println("Id : "+k.getId());
        System.out.println("Nama : "+k.getNama());
        System.out.println("Tanggal Lahir : "+k.getDoB());
        System.out.println("Alamat : "+k.getAlamat());
        System.out.println("Status Aktif : "+k.getStatus());
        System.out.println();
    }
}
