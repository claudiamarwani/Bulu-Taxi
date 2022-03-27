package bulutaxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UsingDatabase {
    
//fungsi melakukan koneksi ke database
    public Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:D:/PBO-NetBeansProjects/BuluTaxi/storage/data_taxi.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    //fungsi untuk mengambil seluruh data pada tabel penumpang
    public void getAllPenumpang() {
        String query = "Select * from penumpang";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("idPenumpang") + "\t"
                        + rs.getString("namaPenumpang") + "\t"
                        + rs.getInt("lokasiAsal") + "\t"
                        + rs.getInt("lokasiTujuan") + "\t"
                        + rs.getInt("jamMulai") + "\t"
                        + rs.getInt("jamSelesai"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    //fungsi untuk menambahkan data ke dalam database
    public void tambahPenumpang(int idPenumpang, String namaPenumpang, int lokasiAsal, int lokasiTujuan, int jamMulai, int jamSelesai) {
        String query = "insert into penumpang values(?,?,?,?,?,?)";
        try {
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, idPenumpang);
            stmt.setString(2, namaPenumpang);
            stmt.setInt(3, lokasiAsal);
            stmt.setInt(4, lokasiTujuan);
            stmt.setInt(5, jamMulai);
            stmt.setInt(6, jamSelesai);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void getDiskonTotalTagihan(){
        String query = "Select * from penumpang where totalTagihan > 1000000 and jumlahPerjalanan >= 5";
        try{
            Connection connect = this.connect();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("idPenumpang") + "\t"
                        + rs.getString("namaPenumpang") + "\t"
                        + rs.getDouble("totalkm") + "\t"
                        + rs.getDouble("totaljam") + "\t"
                        + rs.getDouble("totalbiayakm") + "\t"
                        + rs.getDouble("totalbiayajam") + "\t"
                        + rs.getDouble("totalbaiayaDibayar") + "\t"
                        + rs.getDouble("jumlahPerjalanan") + "\t"
                        + rs.getDouble("totalTagihan"));
            }
            } catch (Exception e) {
            System.out.println(e);
            }
            
        }
    }
