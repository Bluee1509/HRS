package hrs.services;
import hrs.entities.Nhanvien;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrs.repositories.NhanvienRepository;
@Service
public class NhanvienService {
	@Autowired
    private NhanvienRepository NhanvienRepository;
    
	public NhanvienService(hrs.repositories.NhanvienRepository nhanvienRepository) {
		NhanvienRepository = nhanvienRepository;
	}

	public void themNhanVien(Nhanvien nhanvien) {
		NhanvienRepository.save(nhanvien);
	}
	public int updateNhanvien(Long id_nv,Nhanvien nhanVien) {
		return NhanvienRepository.updateNhanvien(id_nv, nhanVien);
	}
	public int xoaNhanvien(Long id_nv) {
		return NhanvienRepository.delete(id_nv);
	}
	 // Hàm hiển thị toàn bộ nhân viên
    public List<Nhanvien> getAllEmployees() {
        return NhanvienRepository.getAllEmployees();
    }

    // Hàm tìm kiếm nhân viên theo tên
    public List<Nhanvien> findEmployeesByName(String name) {
        return NhanvienRepository.findEmployeesByName(name);
    }
}
