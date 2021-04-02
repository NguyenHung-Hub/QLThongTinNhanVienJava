package thongTinNhanVien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class DanhSachNhanVien implements Serializable{
	

	
	private List<NhanVien> dsNhanViens;
	
	public DanhSachNhanVien() {
		dsNhanViens = new  ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if (dsNhanViens.contains(nv)) {
			return false;
		}
		
		dsNhanViens.add(nv);
		return true;
	}
	
//	List<Object> list = new ArrayList();
//	for (Iterator<NhanVien> iterator = dsNhanViens.iterator(); iterator.hasNext();) {
//	  Object obj= iterator.next();
//	    if (obj.getId().equals("1")) {
//	       // Remove the current element from the iterator and the list.
//	       iterator.remove();
//	    }
//	}
	
//	public boolean xoaNhanVien(String ma) {
//		for (Iterator<NhanVien> iterator = dsNhanViens.iterator(); iterator.hasNext();) {
//			NhanVien nhanVien = (NhanVien) iterator.next();
//			if (nhanVien.getMaNV().equals(ma)) {
//				iterator.remove();
//				return true;
//			}
//			
//		}
//		return false;
//	}
//	
//	public boolean xoaNhanVien(String maNV) {
//		return dsNhanViens.removeIf(nv->nv.getMaNV().equals(maNV));
//	}
	
	public boolean xoa(Object object) {
		dsNhanViens.remove(object);
		return true;
	}
	
	/**
	 * Tìm kiếm theo mã nhân viên
	 * @param ma
	 * @return
	 */
//	public DanhSachNhanVien timKiemTheGhiNo(String ma) {
//		DanhSachNhanVien list = new DanhSachNhanVien();
//		
//		for (NhanVien taiKhoanThe : dsNhanViens) {
//				if(taiKhoanThe.getMaNV().equals(ma))
//					list.themNhanVien(taiKhoanThe);
//		}
//		
//		return list;
//	}

	public NhanVien getElement(int index) {
		if(index <0 || index>dsNhanViens.size())
			return null;
		return dsNhanViens.get(index);
	}
	
	public int getSize() {
		return dsNhanViens.size();
	}
}
