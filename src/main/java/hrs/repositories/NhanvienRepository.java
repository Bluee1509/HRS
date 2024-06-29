package hrs.repositories;

import java.util.List;

import hrs.entities.Nhanvien;

public interface NhanvienRepository {

	int save(Nhanvien nhanvien);
	int updateNhanvien(Long id_nv, Nhanvien nhanVien);
	int delete(Long id_nv);
	List<Nhanvien> findEmployeesByName(String name);
	List<Nhanvien> getAllEmployees();

}
