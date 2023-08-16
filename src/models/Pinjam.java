package models;

import java.time.LocalDate;

public class Pinjam {
    private Integer idBuku;
    private Integer idUser;
    private LocalDate borrowDate;
    private String statusPeminjaman;

    public Pinjam() {
    }

    public Pinjam(Integer idBuku, Integer idUser, LocalDate borrowDate, String statusPeminjaman) {
        this.idBuku = idBuku;
        this.idUser = idUser;
        this.borrowDate = borrowDate;
        this.statusPeminjaman = statusPeminjaman;
    }
    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }
    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }
    public Integer getIdBuku() {
        return idBuku;
    }
    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    @Override
    public String toString() {
        return statusPeminjaman + " [ID BUKU=" + idBuku + ", ID USER=" + idUser + ", TANGGAL PINJAM=" + borrowDate + "]";
    }
    
}
