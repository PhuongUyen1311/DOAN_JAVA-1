/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author hp
 */
import java.util.ArrayList;
import DTO.nhacungcapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class nhacungcapDAO {

    private ConnectDataBase c;

    public nhacungcapDAO() {
        try {
            c = new ConnectDataBase();
        } catch (SQLException e) {
        }
    }

    public ArrayList<nhacungcapDTO> listNhacungcap() {
        ArrayList<nhacungcapDTO> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM nhacungcap";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {
                if (result.getInt("TRANGTHAI") == 1) {
                    list.add(new nhacungcapDTO(result.getString("MANCC"), result.getString("TENNCC"), result.getInt("SDT")));
                }
            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }

    public void add(nhacungcapDTO item) {
        try {
            c.connect();
            String query = "INSERT INTO nhacungcap(MANCC,TENNCC,SDT) VALUES ('" + item.getMANCC() + "','" + item.getTENNCC() + "','" + item.getSDT() + "');";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

    public void update(nhacungcapDTO item) {
        try {
            c.connect();

            String query = " UPDATE nhacungcap SET TENNCC='" + item.getTENNCC() + "', SDT=" + item.getSDT() + " WHERE MANCC='" + item.getMANCC() + "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

    public void delete(String m) {
        try {
            c.connect();
            String query = "UPDATE nhacungcap SET TRANGTHAI = 0 WHERE MANCC = '" + m + "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        ArrayList<nhacungcapDTO> list = new ArrayList<>();
        nhacungcapDAO c = new nhacungcapDAO();
        list = c.listNhacungcap();
        for (nhacungcapDTO i : list) {
            System.out.println(i.getMANCC() + " " + i.getTENNCC() + " " + i.getSDT());

        }

//        chucnangDTO c_new= new chucnangDTO("TEST", "THEMCHUCNANG");
//        c.delete(c_new);
    }

}
