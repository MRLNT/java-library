import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.BukuDao;
import dao.OrangDao;
import dao.PinjamDao;
import models.Buku;
import models.Orang;
import models.Pinjam;
import services.book.BookService;
import services.book.BookServiceImplementation;
import services.borrow.BorrowService;
import services.borrow.BorrowServiceImplementation;
import services.person.PersonService;
import services.person.PersonServiceImplementation;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    static BukuDao bukuDao = new BukuDao();
    static BookService bookService = new BookServiceImplementation(bukuDao);

    static OrangDao orangDao = new OrangDao();
    static PersonService personService = new PersonServiceImplementation(orangDao);

    static PinjamDao pinjamDao = new PinjamDao();
    static BorrowService borrowService = new BorrowServiceImplementation(pinjamDao);

    private static void menuTidakAda() {
        System.out.print("Input Tidak sesuai/Menu tidak ada\n");
    }

    private static void menu() {
        System.out.println("=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
        System.out.println("1. MANAJEMEN BUKU");
        System.out.println("2. MANAJEMEN ANGGOTA");
        System.out.println("3. PINJAM BUKU");
        System.out.println("4. KEMBALIKAN BUKU");
        System.out.print("Pilihan: ");
    }

    private static void menuManajemenBuku() {
        System.out.println("1. TAMBAH BUKU");
        System.out.println("2. LIHAT SEMUA BUKU");
        System.out.println("3. LIHAT BUKU DARI INDEX");
        System.out.println("4. HAPUS BUKU");
        System.out.print("Pilihan: ");
    }

    private static void menuManajemenAnggota() {
        System.out.println("1. TAMBAH ANGGOTA");
        System.out.println("2. LIHAT SEMUA ANGGOTA");
        System.out.println("3. LIHAT ANGGOTA DARI INDEX");
        System.out.println("4. HAPUS ANGGOTA");
        System.out.print("Pilihan: ");
    }

    private static void pinjamBuku() {
        System.out.print("Masukkan ID Index Buku: ");
        Integer idBuku = Integer.valueOf(scanner.nextLine());
        System.out.print("Masukkan ID Index User: ");
        Integer idUser = Integer.valueOf(scanner.nextLine());
        LocalDate borrowDate = LocalDate.now();
        String statusPeminjaman = "Peminjaman";
        borrowService.createBorrow(new Pinjam(idBuku, idUser, borrowDate, statusPeminjaman));
        System.out.println("Peminjaman Berhasil");
    }

    private static void pengembalianBuku(){
        List<Pinjam> result = borrowService.getAllBorrow();
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
        System.out.print("PILIH INDEX PENGEMBALIAN BUKU: ");
        Integer pilihEdit = Integer.valueOf(scanner.nextLine());
        Pinjam hasil = borrowService.getBorrowById(pilihEdit);
        Integer idBuku = hasil.getIdBuku();
        Integer idUser = hasil.getIdUser();
        LocalDate borrowDate = LocalDate.now();
        String statusPeminjaman = "Pengembalian";
        //HARUSNYA SET
        borrowService.deleteBorrow(pilihEdit);
        borrowService.createBorrow(new Pinjam(idBuku, idUser, borrowDate, statusPeminjaman));
    }

    private static void tambahBuku() {
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Penerbit Buku: ");
        String penerbit = scanner.nextLine();
        System.out.print("Masukkan Pengarang Buku: ");
        String pengarang = scanner.nextLine();
        
        bookService.createBook(new Buku(judul, penerbit, pengarang));
    }

    private static void tambahAnggota() {
        System.out.print("Masukkan Nama Anggota: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        personService.createPerson(new Orang(nama, email));
    }

    private static void lihatSemuaBuku(){
        List<Buku> result = bookService.getAllBook();
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
    }

    private static void lihatSemuaAnggota(){
        List<Orang> result = personService.getAllPerson();
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
    }

    private static void liatBukuDariIndex(){
        System.out.print("Masukkan index buku : ");
        Integer pilihBuku = Integer.valueOf(scanner.nextLine());
        Buku hasil = bookService.getBookById(pilihBuku);
        System.out.println(hasil);
    }

    private static void liatAnggotaDariIndex(){
        System.out.print("Masukkan index Anggota : ");
        Integer pilihAnggota = Integer.valueOf(scanner.nextLine());
        Orang hasil = personService.getPersonById(pilihAnggota);
        System.out.println(hasil);
    }

    private static void tambahData(){
        bookService.createBook(new Buku("Simba", "Kompas", "Si Pembuat"));
        bookService.createBook(new Buku("Openheimer", "Gramedia", "Si Nolan"));
        personService.createPerson(new Orang("marcel", "marcel@gmail.com"));
        personService.createPerson(new Orang("antonio", "antonio@gmail.com"));
    }

    private static void hapusBuku(){
        System.out.print("Masukkan index Buku : ");
        Integer hapus = Integer.valueOf(scanner.nextLine());
        bookService.deleteBook(hapus);
    }

    private static void hapusAnggota(){
        System.out.print("Masukkan index Anggota : ");
        Integer hapus = Integer.valueOf(scanner.nextLine());
        personService.deletePerson(hapus);
    }

    public static void main(String[] args) {
        tambahData();
        String pilih, pilih2;
        boolean ulang = true;

        try {
            while (ulang) {
                menu();
                pilih = scanner.nextLine();
                switch (pilih) {
                    case "1":
                        menuManajemenBuku();
                        pilih2 = scanner.nextLine();
                        switch (pilih2) {
                        case "1": tambahBuku();
                            break;
                        case "2": lihatSemuaBuku();
                            break;
                        case "3": liatBukuDariIndex();
                            break;
                        case "4": hapusBuku();
                        break;
                        default:  menuTidakAda();
                            break;
                        }
                        break;
                    case "2":
                        menuManajemenAnggota();
                        pilih2 = scanner.nextLine();
                        switch (pilih2) {
                        case "1": tambahAnggota();
                            break;
                        case "2": lihatSemuaAnggota();
                            break;
                        case "3": liatAnggotaDariIndex();
                            break;
                        case "4": hapusAnggota();
                            break;
                        default:  menuTidakAda();
                            break;
                        }
                        break;
                    case "3":
                        pinjamBuku();
                        break;
                    case "4":
                        pengembalianBuku();
                        break;
                    default:
                        menuTidakAda();
                        break;
                }
                while (true) {
                    System.out.print("Ulang Program? (y/n): ");
                    String again = scanner.nextLine();
                    if ("y".equalsIgnoreCase(again)) {
                        break;
                    } else if ("n".equalsIgnoreCase(again)) {
                        ulang = false;
                        break;
                    } else {
                        menuTidakAda();
                    }
                }
            }
            System.out.println("Program Selesai");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}