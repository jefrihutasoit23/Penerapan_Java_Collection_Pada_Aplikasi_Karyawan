package org.example;

import java.time.LocalDate;
import java.util.Date;
public class Karyawan {
    private Integer id;
    private String nama;
    private LocalDate DoB;
    private String alamat;
    private Boolean status;

    public int getGaji(){
        int upah = 200000;
        return ((2023-DoB.getYear())*upah);
    }

    public Karyawan(Integer id, String nama, LocalDate doB, String alamat, Boolean status) {
        this.id = id;
        this.nama = nama;
        DoB = doB;
        this.alamat = alamat;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
