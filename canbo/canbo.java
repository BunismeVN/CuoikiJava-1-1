package canbo;

import java.util.Scanner;

public class canbo{
    Scanner in = new Scanner(System.in);
    
    String hoTen;
    String ngaySinh;
    String gioiTinh;
    String diaChi;
    
    public canbo(){
        
    }
    canbo(String hoTen){
        this.hoTen = hoTen;
    }
    canbo(String hoTen, String ngaySinh){
        this.ngaySinh = ngaySinh;
    }
    canbo(String hoTen, String ngaySinh, String gioiTinh){
        this.gioiTinh = gioiTinh;
    }
    canbo(String hoTen, String ngaySinh, String gioiTinh, String diaChi){
        this.diaChi = diaChi;
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
    
    public void Nhap()
    {
        System.out.print("Nhap ho ten: ");
        hoTen = in.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaySinh = in.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioiTinh = in.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = in.nextLine();
    }
    public void Xuat()
    {
        System.out.println("Ho ten: " +hoTen);
        System.out.println("Ngay sinh: " +ngaySinh);
        System.out.println("Gioi tinh: " +gioiTinh);
        System.out.println("Dia chi: " +diaChi);
    }
}
