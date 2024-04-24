/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.chucnangDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class CenterContentStore extends JPanel {

    private StoreScreen SS_main;
    private int chieurong, chieucao;
    public JPanel search;
    public JPanel thaotac;
    public JPanel pageContent;

    public CenterContentStore(int chieurong, int chieucao, StoreScreen s) {
        SS_main = s;

        this.chieurong = chieurong;
        this.chieucao = chieucao;
        init();

    }

    private void init() {
//        setPreferredSize(new Dimension(chieurong, chieucao));
        setLayout(new FlowLayout(3, 10, 0));
        setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        setOpaque(true);

        search = new JPanel();
        search.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        search.setOpaque(true);
        add(search);
//
        thaotac = new JPanel();
        thaotac.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        thaotac.setOpaque(true);
        add(thaotac);
//        
        pageContent = new JPanel();
        pageContent.setLayout(new BorderLayout());
        pageContent.add(new JLabel("Chưa lựa chọn chức năng", JLabel.CENTER), BorderLayout.CENTER);
        pageContent.setPreferredSize(new Dimension(chieurong, chieucao));
        pageContent.setBackground(Color.WHITE);
        pageContent.setOpaque(true);
        add(pageContent);
//

    }

    public void changeCenterContent(chucnangDTO cnDTO, String maquyen) {
 System.out.println(cnDTO.getMACHUCNANG());
 if(cnDTO.getMACHUCNANG().equals("KH")){
     this.pageContent.removeAll();
      this.pageContent.setLayout(new BorderLayout(0, 0));
      view_quan_li_khach_hang qlkh = new view_quan_li_khach_hang(chieurong, chieucao);
        this.pageContent.add(qlkh, BorderLayout.CENTER);

        this.pageContent.revalidate();
        this.pageContent.repaint();

     return;
 }
  
                  

               
        SearchInStore JP_search = new SearchInStore(cnDTO.getTENCHUCNANG(), pageContent);
        showSearch(JP_search);

        pageContent.removeAll();

        Component[] JP_childSearch = JP_search.getComponents();
        if ((int) search.getPreferredSize().getWidth() + (int) thaotac.getPreferredSize().getWidth() <= chieurong) {
            if (JP_childSearch.length != 0) {
                pageContent.setPreferredSize(new Dimension(chieurong, chieucao - (int) search.getPreferredSize().getHeight() - 5));
            } else {
                pageContent.setPreferredSize(new Dimension(chieurong, chieucao - (int) thaotac.getPreferredSize().getHeight() - 15));
            }
        } else {
            pageContent.setPreferredSize(new Dimension(chieurong, chieucao - (int) search.getPreferredSize().getHeight() - (int) thaotac.getPreferredSize().getHeight()));
        }
        int widthPageContent = (int) pageContent.getPreferredSize().getWidth();
        int heightPageContent = (int) pageContent.getPreferredSize().getHeight();
        switch (cnDTO.getMACHUCNANG()) {

            case "NULLTK": {
                chucnangTaikhoan cntk = new chucnangTaikhoan(this, cnDTO, maquyen);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, cntk);
                showThaotac(JP_thaotac);
                showPageContent(cntk);
                break;
            }
            case "NULLHD":{
                chucnangHoadon cnhd = new chucnangHoadon(this, cnDTO, maquyen);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, cnhd);
                showThaotac(JP_thaotac);
                showPageContent(cnhd);
                break;
            }
               

            case "NCC": {

                nhacungcapGUI nccGUI = new nhacungcapGUI(widthPageContent, heightPageContent);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, nccGUI);
                showThaotac(JP_thaotac);
                showPageContent(nccGUI);
                break;
            }
            case "LOAI": {
                loaiSPGUI lGUI = new loaiSPGUI(widthPageContent, heightPageContent);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, lGUI);
                showThaotac(JP_thaotac);
                showPageContent(lGUI);
                break;
            }
            case "NV": {
                try {
                    Trangnhanvien_GUI nvGUI = new Trangnhanvien_GUI(widthPageContent, heightPageContent);
                    ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, nvGUI);
                    showThaotac(JP_thaotac);
                    showPageContent(nvGUI);
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CenterContentStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "SP": {
                SanPhamGUI spGUI = new SanPhamGUI(widthPageContent, heightPageContent, pageContent.getBackground());
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, spGUI);
                showThaotac(JP_thaotac);
                showPageContent(spGUI);
                break;
            }
            case "TK":{
                chucnangTaikhoan cntk = new chucnangTaikhoan(this, cnDTO, maquyen);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, cntk);
                showThaotac(JP_thaotac);
                showPageContent(cntk);
                break;
            }
                
            case "HD":{
                 chucnangHoadon cnhd = new chucnangHoadon(this, cnDTO, maquyen);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, cnhd);
                showThaotac(JP_thaotac);
                showPageContent(cnhd);
                break;
            }
               
            case "PQ":{
                phanquyen pq = new phanquyen(widthPageContent, heightPageContent);
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, pq);
                showThaotac(JP_thaotac);
                showPageContent(pq);
                break;
            }
                
           
            case "SIZE":{
                  JPanel size = new JPanel();
                size.setPreferredSize(new Dimension(widthPageContent, heightPageContent));
                size.add(new JLabel("Đây là trang size"));
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, size);
                showThaotac(JP_thaotac);
                showPageContent(size);
                break;
            }
                
            case "NULLThK":{
                 JPanel thKe = new JPanel();
                thKe.setPreferredSize(new Dimension(widthPageContent, heightPageContent));
                thKe.add(new JLabel("Đây là trang thống kê"));
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, thKe);
                showThaotac(JP_thaotac);
                showPageContent(thKe);
                break;
            }
               
            case "NULLDX":
                JPanel dx = new JPanel();
                dx.setPreferredSize(new Dimension(widthPageContent, heightPageContent));
                dx.setBackground(Color.WHITE);
                dx.setOpaque(true);
                showPageContent(dx);
                int r2 = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
                        if (r2 == JOptionPane.YES_OPTION) {
                            SS_main.dispose();
                            LoginUI login = new LoginUI();
                        }
                break;
            case "PN":{
                JPanel pn = new JPanel();
                pn.setPreferredSize(new Dimension(widthPageContent, heightPageContent));
                pn.add(new JLabel("Đây là trang phiếu nhập"));
                ThaotacInStore JP_thaotac = new ThaotacInStore(cnDTO.getMACHUCNANG(), maquyen, pn);
                showThaotac(JP_thaotac);
                showPageContent(pn);
                break;
            }
            default:
                JPanel p = new JPanel();
                p.add(new JLabel("Chưa có chức năng này", JLabel.CENTER));
                showPageContent(p);
                break;
        }
    }

    public void showPageContent(Component page) {
//        SS_main.pageContent.setPreferredSize(new Dimension(chieurong,this.chieucao));
        this.pageContent.setLayout(new BorderLayout(0, 0));
        this.pageContent.add(page, BorderLayout.CENTER);

        this.pageContent.revalidate();
        this.pageContent.repaint();
    }

    public void showThaotac(JPanel thaotac) {

        this.thaotac.removeAll();
        this.thaotac.add(thaotac);

        this.thaotac.revalidate();
        this.thaotac.repaint();
    }

    public void showSearch(JPanel search) {
        this.search.removeAll();

        this.search.add(search);

        this.search.revalidate();
        this.search.repaint();
    }
}