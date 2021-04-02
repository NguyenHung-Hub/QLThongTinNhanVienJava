package thongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ThongTinNhanVien_UI extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField txtHoNV;
//	private JRadioButton rbtnNu;
	private JTextField txtLuongNV;
	private DefaultTableModel tableModel;
	private JTable table;
	private String[] tieuDeBang = { "Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
	private JTextField txtTimKiem;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnLuu;
	private JTextField txtTenNV;
	private JTextField txtTuoiNV;
	private JCheckBox chkNu;
	private DanhSachNhanVien dsNhanVien;

	public ThongTinNhanVien_UI() {
		setTitle("^_^");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		/* begin: top */
		JPanel topJPanel = new JPanel(new BorderLayout());
//		topJPanel.setBackground(Color.red);
		topJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		JLabel tieuDeJLabel = new JLabel("THÔNG TIN NHÂN VIÊN", SwingConstants.CENTER);
		tieuDeJLabel.setPreferredSize(new Dimension(getWidth(), 40));
		tieuDeJLabel.setFont(new Font("Arial", Font.BOLD, 24));
		tieuDeJLabel.setForeground(Color.blue);
		topJPanel.add(tieuDeJLabel, BorderLayout.NORTH);

		Box topBox = Box.createVerticalBox();
		topBox.setBackground(Color.yellow);

		// mã nhân viên
		Box maNVBox = Box.createHorizontalBox();
		JLabel maNVJLabel = new JLabel("Mã nhân viên");
		maNVJLabel.setPreferredSize(new Dimension(100, 20));
		maNVBox.add(maNVJLabel);
		txtMaNV = new JTextField(15);
		maNVBox.add(txtMaNV);
		topBox.add(maNVBox);

		// họ + tên nhân viên
		Box hoNVBox = Box.createHorizontalBox();
		JLabel hoNVJLabel = new JLabel("Họ");
		hoNVJLabel.setPreferredSize(new Dimension(100, 20));
		hoNVBox.add(hoNVJLabel);
		txtHoNV = new JTextField(20);
		hoNVBox.add(txtHoNV);

		JLabel tenNVJLabel = new JLabel("Tên nhân viên");
		hoNVBox.add(tenNVJLabel);
		txtTenNV = new JTextField(20);
		hoNVBox.add(txtTenNV);
		topBox.add(hoNVBox);

		// tuổi + phái
		Box tuoiNVBox = Box.createHorizontalBox();
		JLabel tuoiNVJLabel = new JLabel("Tuổi");
		tuoiNVJLabel.setPreferredSize(new Dimension(100, 20));
		tuoiNVBox.add(tuoiNVJLabel);
		txtTuoiNV = new JTextField(20);
		tuoiNVBox.add(txtTuoiNV);

		JLabel gioiTinhNVJLabel = new JLabel("Phái");
		gioiTinhNVJLabel.setPreferredSize(new Dimension(100, 20));
		tuoiNVBox.add(gioiTinhNVJLabel);
//		rbtnNu = new JRadioButton();
		chkNu = new JCheckBox();
		tuoiNVBox.add(chkNu);
		JLabel nuJLabel = new JLabel("Nữ");
		nuJLabel.setPreferredSize(new Dimension(50, 20));
		tuoiNVBox.add(nuJLabel);
		topBox.add(tuoiNVBox);

		// tiền lương
		Box luongNVBox = Box.createHorizontalBox();
		JLabel luongNVJLabel = new JLabel("Tiền lương");
		luongNVJLabel.setPreferredSize(new Dimension(100, 20));
		luongNVBox.add(luongNVJLabel);
		txtLuongNV = new JTextField(20);
		txtLuongNV.addActionListener(this);
		luongNVBox.add(txtLuongNV);
		topBox.add(luongNVBox);

		topJPanel.add(topBox, BorderLayout.CENTER);
		this.add(topJPanel, BorderLayout.NORTH);
		/* end: top */

		/* begin: center */
		JPanel centerJPanel = new JPanel(new BorderLayout());
		centerJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		tableModel = new DefaultTableModel(tieuDeBang, 0);
		table = new JTable(tableModel);
		table.setRowHeight(30);

		centerJPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		this.add(centerJPanel, BorderLayout.CENTER);
		/* end: center */

		/* begin: bottom */
		JPanel bottomJPanel = new JPanel(new BorderLayout());

		JPanel timKiemJPanel = new JPanel();
		timKiemJPanel.add(new JLabel("Nhập mã số cần tìm:"));
		txtTimKiem = new JTextField(15);
		timKiemJPanel.add(txtTimKiem);
		btnTimKiem = new JButton("Tìm kiếm");
		timKiemJPanel.add(btnTimKiem);
//		bottomJPanel.add(timKiemJPanel);

		JPanel btnJPanel = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");

		btnJPanel.add(btnThem);
		btnJPanel.add(btnXoaRong);
		btnJPanel.add(btnXoa);
		btnJPanel.add(btnLuu);

		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);

//		bottomJPanel.add(btnJPanel);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, timKiemJPanel, btnJPanel);
//		splitPane.setDividerSize(4);

		bottomJPanel.add(splitPane, BorderLayout.CENTER);

		this.add(bottomJPanel, BorderLayout.SOUTH);

		/* end: bottom */

		// Đọc thông tin từ file
		dsNhanVien = new DanhSachNhanVien();
		LuuTru luuTru = new LuuTru();

		try {
			dsNhanVien = (DanhSachNhanVien) luuTru.DocFile("data\\dataNhanVien.txt");

			for (int i = 0; i < dsNhanVien.getSize(); i++) {
				NhanVien nv = dsNhanVien.getElement(i);

				String gioiTinh = "Nam"; // true
				if (nv.isGioiTinh() == false)
					gioiTinh = "Nữ";

				tableModel.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), gioiTinh,
						nv.getTienLuong() });
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ThongTinNhanVien_UI().setVisible(true);
	}

	public boolean checkEmtyText() {

		if (txtMaNV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập mã.");
			txtMaNV.requestFocus();
			return false;
		}

		if (txtHoNV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập họ.");
			txtHoNV.requestFocus();
			return false;
		}

		if (txtTenNV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên.");
			txtTenNV.requestFocus();
			return false;
		}

		if (txtTuoiNV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tuổi.");
			txtTuoiNV.requestFocus();
			return false;
		}

		if (txtLuongNV.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tiền lương.");
			txtLuongNV.requestFocus();
			return false;
		}

		return true;
	}

	public boolean checkNumber() {
		try {
			int tuoi = Integer.parseInt(txtTuoiNV.getText());
			if (tuoi < 1 || tuoi > 100) {
				JOptionPane.showMessageDialog(this, "Nhập tuổi không đúng.");
				txtTuoiNV.selectAll();
				txtTuoiNV.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Nhập tuổi không đúng.");
			txtTuoiNV.selectAll();
			txtTuoiNV.requestFocus();
			return false;
		}
		try {
			double luong = Double.parseDouble(txtLuongNV.getText());
			if (luong < 1) {
				JOptionPane.showMessageDialog(this, "Nhập tiền lương không đúng.");
				txtLuongNV.selectAll();
				txtLuongNV.requestFocus();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Nhập tiền lương không đúng.");
			txtLuongNV.selectAll();
			txtLuongNV.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object.equals(btnThem)) {

			if (checkEmtyText() == true) {
				if (checkNumber() == false) {
					return;
				}
			} else
				return;

			// lưu vào file
			String gioiTinhString = "Nam";
			boolean gioiTinhBoolean = true; // là nam
			if (chkNu.isSelected()) {
				gioiTinhString = "Nữ";
				gioiTinhBoolean = false;
			}

			double luong = Double.parseDouble(txtLuongNV.getText());
			int tuoi = Integer.parseInt(txtTuoiNV.getText());

			NhanVien nhanVien = new NhanVien(txtMaNV.getText(), txtTenNV.getText(), txtHoNV.getText(), tuoi,
					gioiTinhBoolean, luong);

			if (!dsNhanVien.themNhanVien(nhanVien)) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại. Có thể trùng mã!");
				txtMaNV.selectAll();
				txtMaNV.requestFocus();
				return;
			}

			// hiển thị lên bảng
			tableModel.addRow(new Object[] { txtMaNV.getText(), txtTenNV.getText(), txtHoNV.getText(),
					txtTuoiNV.getText(), gioiTinhString, txtLuongNV.getText() });

			txtMaNV.selectAll();
			txtTenNV.selectAll();
			txtHoNV.selectAll();
			txtTuoiNV.selectAll();
			chkNu.setSelected(false);
			txtLuongNV.selectAll();
			txtMaNV.requestFocus();
		}

		// Nút xóa rỗng
		if (object.equals(btnXoaRong)) {
			txtMaNV.setText("");
			txtTenNV.setText("");
			txtHoNV.setText("");
			txtTuoiNV.setText("");
			chkNu.setSelected(false);
			txtLuongNV.setText("");
			txtMaNV.requestFocus();
		}

		// nút xóa
		if (object.equals(btnXoa)) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa.");
			} else {
				int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (x == JOptionPane.YES_OPTION) {
					
					String maNVXoa = (String) table.getValueAt(table.getSelectedRow(), 0);
					System.out.println(maNVXoa);
//					dsNhanVien.xoaNhanVien(maNVXoa);
					dsNhanVien.xoa(dsNhanVien.getElement(table.getSelectedRow()));
					tableModel.removeRow(table.getSelectedRow());
				}
			}
		}

		// nút lưu
		if (object.equals(btnLuu)) {
			LuuTru luuTru = new LuuTru();

			try {
				luuTru.LuuFile(dsNhanVien, "data\\dataNhanVien.txt");
				JOptionPane.showMessageDialog(this, "Lưu thành công.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Lưu không thành công.");
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int rowSelect = table.getSelectedRow();
		
		txtMaNV.setText(table.getValueAt(rowSelect,0).toString());
		txtHoNV.setText(table.getValueAt(rowSelect,1).toString());
		txtTenNV.setText(table.getValueAt(rowSelect,2).toString());
		txtTuoiNV.setText(table.getValueAt(rowSelect,3).toString());
//		.setText(table.getValueAt(rowSelect,0).toString());
		txtLuongNV.setText(table.getValueAt(rowSelect,4).toString());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
