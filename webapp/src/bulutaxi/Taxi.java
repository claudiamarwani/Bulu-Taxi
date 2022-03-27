package bulutaxi;

import java.util.Scanner;

public class Taxi {

    String idTaxi;
    String platNomor;
    String namaDriver;
    static Double jumlahPerjalanan;
    static Double biayaJam;
    static Double biayaKm;
    static Double km;
    static Double jam;
    static Double totalkm;
    static Double totaljam;
    static Double totalbiayaJam;
    static Double totalbiayaKm;
    static Double totalbiayaDibayar;
    static Double totalTagihan;

    final Double biayaAwal = 3600.0;
    final Double biayaperKm = 4350.0;
    final Double biayaperJam = 45000.0;

    Taxi(String tahun, String nopendaftaran) {
        idTaxi = tahun + nopendaftaran;
    }

    public String getIdTaxi() {
        return idTaxi;
    }

    public void setIdTaxi(String idTaxi) {
        this.idTaxi = idTaxi;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }

    public static Double getJumlahPerjalanan() {
        return jumlahPerjalanan;
    }

    public static void setJumlahPerjalanan(Double jumlahPerjalanan) {
        Taxi.jumlahPerjalanan = jumlahPerjalanan;
    }

    public static Double getBiayaJam() {
        return biayaJam;
    }

    public static void setBiayaJam(Double biayaJam) {
        Taxi.biayaJam = biayaJam;
    }

    public static Double getBiayaKm() {
        return biayaKm;
    }

    public static void setBiayaKm(Double biayaKm) {
        Taxi.biayaKm = biayaKm;
    }

    public static Double getKm() {
        return km;
    }

    public static void setKm(Double km) {
        Taxi.km = km;
    }

    public static Double getJam() {
        return jam;
    }

    public static void setJam(Double jam) {
        Taxi.jam = jam;
    }

    public static Double getTotalkm() {
        return totalkm;
    }

    public static void setTotalkm(Double totalkm) {
        Taxi.totalkm = totalkm;
    }

    public static Double getTotaljam() {
        return totaljam;
    }

    public static void setTotaljam(Double totaljam) {
        Taxi.totaljam = totaljam;
    }

    public static Double getTotalbiayaJam() {
        return totalbiayaJam;
    }

    public static void setTotalbiayaJam(Double totalbiayaJam) {
        Taxi.totalbiayaJam = totalbiayaJam;
    }

    public static Double getTotalbiayaKm() {
        return totalbiayaKm;
    }

    public static void setTotalbiayaKm(Double totalbiayaKm) {
        Taxi.totalbiayaKm = totalbiayaKm;
    }

    public static Double getTotalbiayaDibayar() {
        return totalbiayaDibayar;
    }

    public static void setTotalbiayaDibayar(Double totalbiayaDibayar) {
        Taxi.totalbiayaDibayar = totalbiayaDibayar;
    }

    public static Double getTotalTagihan() {
        return totalTagihan;
    }

    public static void setTotalTagihan(Double totalTagihan) {
        Taxi.totalTagihan = totalTagihan;
    }

    public static void main(String[] args) {

        int jumlahPenumpang;
        Taxi tx1 = new Taxi("2021", "12");
        tx1.setPlatNomor("BK 1208 MN");
        tx1.setNamaDriver("Ujang");

        System.out.println("ID Taxi         = " + tx1.getIdTaxi());
        System.out.println("Nomor Plat Taxi = " + tx1.getPlatNomor());
        System.out.println("Nama Driver     = " + tx1.getNamaDriver());

        Scanner inputJumlah = new Scanner(System.in);
        System.out.println("Masukkan jumlah Penumpang = ");
        jumlahPenumpang = inputJumlah.nextInt();
        Penumpang png = new Penumpang();

        tx1.setTotalkm(0.0);
        tx1.setTotaljam(0.0);
        tx1.setTotalbiayaKm(0.0);
        tx1.setTotalbiayaJam(0.0);
        tx1.setTotalbiayaDibayar(0.0);
        tx1.setTotalTagihan(0.0);

        for (int j = 1; j <= jumlahPenumpang; j++) {
            Scanner idPenumpang = new Scanner(System.in);
            System.out.println("ID Penumpang ke " + j + " " + "=");
            png.setIdPenumpang(idPenumpang.nextLine());

            Scanner namaPenumpang = new Scanner(System.in);
            System.out.println("Nama Penumpang ke " + j + " " + "=");
            png.setNamaPenumpang(namaPenumpang.nextLine());

            Scanner jumlahPerjalanan = new Scanner(System.in);
            System.out.println("Perjalanan ke =");
            tx1.setJumlahPerjalanan(jumlahPerjalanan.nextDouble());

            Scanner LokAsal = new Scanner(System.in);
            System.out.println("Lokasi Asal = ");
            png.setLokasiAsal(LokAsal.nextLine());

            Scanner LokTujuan = new Scanner(System.in);
            System.out.println("Lokasi Tujuan = ");
            png.setLokasiTujuan(LokTujuan.nextLine());

            Double asal = Double.parseDouble(png.getLokasiAsal());
            Double tujuan = Double.parseDouble(png.getLokasiTujuan());

            Scanner jMulai = new Scanner(System.in);
            System.out.println("Jam Mulai = ");
            png.setJamMulai(jMulai.nextLine());

            Scanner jSelesai = new Scanner(System.in);
            System.out.println("Jam Selesai = ");
            png.setJamSelesai(jSelesai.nextLine());

            Double mulai = Double.parseDouble(png.getJamMulai());
            Double selesai = Double.parseDouble(png.getJamSelesai());

            tx1.setKm(tujuan - asal);
            tx1.setBiayaKm(tx1.biayaAwal + (tx1.biayaperKm * tx1.getKm()));
            tx1.setJam(selesai - mulai);
            tx1.setBiayaJam(tx1.biayaAwal + (tx1.biayaperJam * tx1.getJam()));

            tx1.setTotalbiayaKm(tx1.getTotalbiayaKm() + tx1.getBiayaKm());
            tx1.setTotalkm(tx1.getTotalkm() + tx1.getKm());

            tx1.setTotalbiayaJam(tx1.getTotalbiayaJam() + tx1.getBiayaJam());
            tx1.setTotaljam(tx1.getTotaljam() + tx1.getJam());

            System.out.println("___________________________________________________");
            System.out.println("ID penumpang            = " + png.getIdPenumpang());
            System.out.println("Nama penumpang          = " + png.getNamaPenumpang());
            System.out.println("Perjalanan ke           = " + tx1.getJumlahPerjalanan());
            System.out.println("Lokasi Asal             = " + png.getLokasiAsal());
            System.out.println("Lokasi Tujuan           = " + png.getLokasiTujuan());
            System.out.println("Km yang ditempuh        = " + tx1.getKm() + "(KM)");
            System.out.println("Jam Mulai               = " + png.getJamMulai());
            System.out.println("Jam Selesai             = " + png.getJamSelesai());
            System.out.println("Jumlah jam              = " + tx1.getJam() + "(Jam)");
            System.out.println("Biaya berdasarkan Km    = Rp. " + tx1.getBiayaKm());
            System.out.println("Biaya berdasarkan Jam   = Rp. " + tx1.getBiayaJam());
            System.out.println("___________________________________________________");

            if (tx1.getTotalbiayaKm() > tx1.getTotalbiayaJam()) {
                totalbiayaDibayar = tx1.getBiayaKm();
                System.out.println("Total biaya yang harus dibayar  = Rp. " + tx1.getBiayaKm());
            } 
            else if (tx1.getTotalbiayaJam() > tx1.getTotalbiayaKm()) {
                totalbiayaDibayar = tx1.getBiayaJam();
                System.out.println("Total biaya yang harus dibayar  = Rp. " + tx1.getBiayaJam());
            } 
            else {
                totalbiayaDibayar = tx1.getBiayaKm();
                System.out.println("Total biaya yang harus dibayar  = Rp. " + tx1.getBiayaKm());
            }
            
            
            if (tx1.getTotalbiayaDibayar() > 1000000.0 && tx1.getJumlahPerjalanan() >= 5) {
                totalTagihan = tx1.getTotalbiayaDibayar() - (tx1.getTotalbiayaDibayar() * 0.1);
                System.out.println("Total Tagihan yang harus dibayar  = Rp. " + tx1.getTotalbiayaDibayar());
            } 
            else {
                totalTagihan = tx1.getTotalbiayaDibayar();
                System.out.println("Total Tagihan yang harus dibayar  = Rp. " + tx1.getTotalbiayaDibayar());
            }
            
            System.out.println("---------------------------------------------------");
        }
    }
}
