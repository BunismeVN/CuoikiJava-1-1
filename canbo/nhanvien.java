package canbo;

import java.util.Scanner;

public class nhanvien extends canbo {
    Scanner in = new Scanner(System.in);
    
    String congViec;
    
    nhanvien()
    {
        super();
    }
    nhanvien(String hoTen)
    {
        super(hoTen);
    }
    nhanvien(String hoTen, String ngaySinh)
    {
        super(hoTen, ngaySinh);
    }
    nhanvien(String hoTen, String ngaySinh, String gioiTinh)
    {
        super(hoTen, ngaySinh, gioiTinh);
    }
    nhanvien(String hoTen, String ngaySinh, String gioiTinh, String diaChi)
    {
        super(hoTen, ngaySinh, gioiTinh, diaChi);
    }
    nhanvien(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String congViec)
    {
        super(hoTen, ngaySinh, gioiTinh, diaChi);
        this.congViec = congViec;
    }
    
    public void setHoTen(String hoTen)
    {
        this.hoTen = hoTen;
    }
    public String getHoTen()
    {
        return hoTen;
    }
    public void setNgaySinh(String ngaySinh)
    {
        this.ngaySinh = ngaySinh;
    }
    public String getNgaySinh()
    {
        return ngaySinh;
    }
    public void setGioiTinh(String gioiTinh)
    {
        this.gioiTinh = gioiTinh;
    }
    public String getGioiTinh()
    {
        return gioiTinh;
    }
    public void setDiaChi(String diaChi)
    {
        this.diaChi = diaChi;
    }
    public String getDiaChi()
    {
        return diaChi;
    }
    public void setCongViec(String congViec)
    {
        this.congViec = congViec;
    }
    public String getCongViec()
    {
        return congViec;
    }
    
    public void Nhap()
    {
        super.Nhap();
        System.out.print("Nhap cong viec: ");
        congViec = in.nextLine();
        System.out.print("\n");
    }
    public void Xuat()
    {
        super.Xuat();
        System.out.println("Cong viec: " +congViec);
    }
}
