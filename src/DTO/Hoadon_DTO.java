
package DTO;

public class Hoadon_DTO {
    private String maHD,tenKH,maNV;
    private String ngayHD;
    private int tongTien;

    public Hoadon_DTO(String maHD, String ngayHD, String tenKH, String maNV, int tongTien) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.maNV = maNV;
        this.ngayHD = ngayHD;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return tenKH;
    }

    public void setMaKH(String maKH) {
        this.tenKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
