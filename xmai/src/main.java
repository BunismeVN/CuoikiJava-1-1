import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

class Main extends JFrame {
    JFrame f = new JFrame("Menu");
    JTextField tfHoten = new JTextField(20);
    JTextField tfCMND = new JTextField(10);
    JTextField tfsdt = new JTextField(10);
    JTextField tfmaphong = new JTextField(10);
    JTextField tfloaiphong= new JTextField(10);
    JTextField tfgiatien = new JTextField(10);
    JTextField tftrangthai = new JTextField(20);
    JLabel lbngaydat = new JLabel("Ngày đặt phòng");
    JTextField tfngaydat = new JTextField(50);
    JLabel lbngaytra = new JLabel("Ngày trả phòng");
    JTextField tfngaytra = new JTextField(20);

    JButton themButton = new JButton("Thêm");
    JButton suaButton = new JButton("Sửa");
    JButton xoaButton = new JButton("Xóa");
    JButton lammoiButton = new JButton("RESET");

    JTable tbSearch;

    PreparedStatement pst;
    Connection conn;
    ResultSet rs;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private JPanel panel_3;
    private final JLabel lbgiatien = new JLabel("Giá Tiền");
    private JPanel panel_1;
    private JPanel panel_2;
    private final JLabel lblNewLabel = new JLabel("Ngày đặt phòng");
    private final JLabel lblNgyTrPhng = new JLabel("Ngày trả phòng");
    private final JLabel lblNewLabel_1 = new JLabel("");

    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(500,230);
        f.setSize(1000,450);
        f.getContentPane().setLayout(null);
        f.getContentPane().add(TaoPanel());
        lbgiatien.setBounds(10, 100, 62, 20);
        panel_2.add(lbgiatien);
        lbgiatien.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tfgiatien.setBounds(86, 104, 172, 20);
        panel_2.add(tfgiatien);
        tfngaydat.setBounds(411, 11, 142, 20);
        panel_2.add(tfngaydat);
        tfngaytra.setBounds(411, 73, 142, 20);
        panel_2.add(tfngaytra);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(288, 13, 113, 18);

        panel_2.add(lblNewLabel);
        lblNgyTrPhng.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNgyTrPhng.setBounds(288, 76, 113, 17);

        panel_2.add(lblNgyTrPhng);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\XUAN MAI\\Downloads\\hotel.png"));
        lblNewLabel_1.setBounds(725, 34, 145, 136);

        panel_3.add(lblNewLabel_1);
        f.setVisible(true);
    }
    private JPanel TaoPanel() {
        panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 986, 413);
        panel_3.setLayout(null);
        panel_3.add(tableData());
        themButton.setBounds(0, 0, 245, 25);
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect con1 = new Connect();
//               String NGAY_DAT_PHONG = tftrangthai.getText();
//               String NGAY_TRA_PHONG = tfngaytra.getText();
//               Date dp = Date.valueOf(NGAY_DAT_PHONG);
//               Date tp = Date.valueOf(NGAY_TRA_PHONG);
                String truyvan = "INSERT INTO KS(HO_TEN,SO_DIEN_THOAI,CMND,MA_PHONG,LOAI_PHONG,GIA_TIEN,TRANG_THAI) VALUES (?,?,?,?,?,?,?)";
                conn = con1.getConnection();

                try{
                    pst = conn.prepareStatement(truyvan);
                    pst.setString(1,tfHoten.getText());
                    pst.setString(2,tfCMND.getText());
                    pst.setString(3,tfsdt.getText());
                    pst.setString(4,tfmaphong.getText());
                    pst.setString(5,tfloaiphong.getText());
                    pst.setString(6,tfgiatien.getText());
                    pst.setString(7,tftrangthai.getText());
                    pst.executeUpdate();

                    int chk = pst.executeUpdate();
                    if (chk > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    }
                    else {

                    }

                }
                catch(Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null," Thêm thất bại, vui lòng thử lại");
                }
            }




        });
        panel_3.add(button());
        tabbedPane.setBounds(10, 0, 588, 170);

        panel_3.add(tabbedPane);

        panel_1 = new JPanel();
        tabbedPane.addTab("Quản lý khách hàng", null, panel_1, null);
        panel_1.setLayout(null);
        tfHoten.setBounds(63, 11, 166, 20);
        panel_1.add(tfHoten);
        tfCMND.setBounds(212, 77, 166, 20);
        panel_1.add(tfCMND);
        tfsdt.setBounds(370, 11, 166, 20);
        panel_1.add(tfsdt);

        JLabel LbHoten = new JLabel("Họ tên");
        LbHoten.setFont(new Font("Segoe UI", Font.BOLD, 12));
        LbHoten.setBounds(10, 11, 62, 20);
        panel_1.add(LbHoten);

        JLabel lbcmnd = new JLabel("CMND");
        lbcmnd.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbcmnd.setBounds(150, 76, 52, 20);
        panel_1.add(lbcmnd);

        JLabel lbsdt = new JLabel("SĐT");
        lbsdt.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbsdt.setBounds(325, 10, 52, 20);
        panel_1.add(lbsdt);

        panel_2 = new JPanel();
        tabbedPane.addTab("Quản lý phòng", null, panel_2, null);
        panel_2.setLayout(null);
        tfmaphong.setBounds(86, 11, 172, 20);
        panel_2.add(tfmaphong);
        tfloaiphong.setBounds(86, 42, 172, 20);
        panel_2.add(tfloaiphong);
        tftrangthai.setBounds(86, 73, 172, 20);
        panel_2.add(tftrangthai);

        JLabel lbmaphong = new JLabel("Mã Phòng");
        lbmaphong.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbmaphong.setBounds(10, 10, 66, 20);
        panel_2.add(lbmaphong);

        JLabel lbloaiphong = new JLabel("Loại Phòng");
        lbloaiphong.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbloaiphong.setBounds(10, 42, 66, 20);
        panel_2.add(lbloaiphong);

        JLabel lbtrangthai = new JLabel("Trạng thái");
        lbtrangthai.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbtrangthai.setBounds(10, 69, 66, 20);
        panel_2.add(lbtrangthai);
        return panel_3;
    }
    private JPanel button() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 388, 986, 25);
        panel.setLayout(null);

        panel.add(themButton);
        themButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        suaButton.setBounds(247, 0, 245, 25);
        panel.add(suaButton);
        suaButton.setFont(new java.awt.Font("Segoe UI", 1, 12));

        xoaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connect con1 = new Connect();
                conn = con1.getConnection();
                try {
                    String sql ="delete from KS where CMND ='"+tfCMND.getText()+"'";
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
        			int chk = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa?","Thông báo!", JOptionPane.YES_NO_OPTION);
        			if(chk == JOptionPane.YES_OPTION) {
        				st.executeUpdate(sql);
        				JOptionPane.showConfirmDialog(null, "Xóa thành công");
        			}

                } catch (Exception e1) {

                }

            }
        });
        xoaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        xoaButton.setBounds(494, 0, 245, 25);
        panel.add(xoaButton);
//reset button
        lammoiButton.setBounds(741, 0, 245, 25);
        panel.add(lammoiButton);
        lammoiButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lammoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect cn = new Connect();
                rs = cn.Danhsach("SELECT*FROM KS");
                String[] column = {"HO_TEN", "SO_DIEN_THOAI", "CMND","MA_PHONG", "LOAI_PHONG","GIA_TIEN", "TRANG_THAI", "NGAY_DAT_PHONG", "NGAY_TRA_PHONG"};

                //   String gender = cboGender.getSelectedItem().toString();
                DefaultTableModel tm = new DefaultTableModel(column, 0);
                try {
                    while (rs.next()) {
                        Object data[] = {rs.getString("HO_TEN"), rs.getString("SO_DIEN_THOAI"), rs.getString("CMND"), rs.getString("MA_PHONG"), rs.getString("LOAI_PHONG"), rs.getString("GIA_TIEN"), rs.getString("TRANG_THAI"),rs.getString("NGAY_DAT_PHONG"),rs.getString("NGAY_TRA_PHONG")};
                        tm.addRow(data);
                    }
                    //        tbhouse.setModel(tm);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return  panel;
    }
    private JPanel table() {
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        Display();
        JScrollPane sp = new JScrollPane(tbSearch);
        panel.add(sp);
        return  panel;
    }
    private JPanel tableData(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 181, 986, 208);
        BangDL();
        panel.setLayout(null);
        JScrollPane sp = new JScrollPane(tbSearch);
        sp.setBounds(0, 0, 976, 197);
        panel.add(sp);
        return  panel;
    }
    public void BangDL() {
        Connect con_DV = new Connect();
        String col[] = {"HO_TEN", "SO_DIEN_THOAI", "CMND","MA_PHONG", "LOAI_PHONG","GIA_TIEN", "TRANG_THAI", "NGAY_DAT_PHONG", "NGAY_TRA_PHONG"};
        DefaultTableModel tm1 = new DefaultTableModel(col, 0);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = con_DV.getConnection();
            // tạo đối tượng thực thi câu lệnh SELECT
            st = conn.createStatement();
            // Thực thi
            rs = st.executeQuery("SELECT * FROM KS");
            Vector data = null;
            tm1.setRowCount(0);


            // Trong khi chưa hết dữ liệu
            while (rs.next()){
                data = new Vector();
                data.add(rs.getString("HO_TEN"));
                data.add(rs.getString("SO_DIEN_THOAI"));
                data.add(rs.getString("CMND"));
                data.add(rs.getString("MA_PHONG"));
                data.add(rs.getString("LOAI_PHONG"));
                data.add(rs.getString("GIA_TIEN"));
                data.add(rs.getString("TRANG_THAI"));
                data.add(rs.getString("NGAY_DAT_PHONG"));
                data.add(rs.getString("NGAY_TRA_PHONG"));
                // thêm dòng vào table model
                tm1.addRow(data);
            }
            tbSearch = new JTable();
            tbSearch.setModel(tm1); // thêm dữ liệu vào table
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void Display(){

        Connect cn = new Connect();
        rs = cn.Danhsach("SELECT*FROM KS");
        String[] column = {"HO_TEN", "SO_DIEN_THOAI", "CMND","MA_PHONG", "LOAI_PHONG","GIA_TIEN", "TRANG_THAI", "NGAY_DAT_PHONG", "NGAY_TRA_PHONG"};

        //   String gender = cboGender.getSelectedItem().toString();
        DefaultTableModel tm = new DefaultTableModel(column, 0);
        try {
            while (rs.next()) {
                Object data[] = {rs.getString("HO_TEN"), rs.getString("SO_DIEN_THOAI"), rs.getString("CMND"), rs.getString("MA_PHONG"), rs.getString("LOAI_PHONG"), rs.getString("GIA_TIEN"), rs.getString("TRANG_THAI"),rs.getString("NGAY_DAT_PHONG"),rs.getString("NGAY_TRA_PHONG")};
                tm.addRow(data);
            }
            //        tbhouse.setModel(tm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Main(){

        TaoFrame();

        lammoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }
}