package hrs.controllers;

import hrs.entities.Nhanvien;
import hrs.services.NhanvienService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/nhanvien")
public class NhanvienController {
	@Autowired
	private NhanvienService nhanVienService;

	// API hiển thị toàn bộ nhân viên
	@GetMapping("/employees")
	public List<Nhanvien> getAllEmployees() {
		return nhanVienService.getAllEmployees();
	}

	// API tìm kiếm nhân viên theo tên
	@GetMapping("/employees/search")
	public List<Nhanvien> findEmployeesByName(@RequestParam String name) {
		return nhanVienService.findEmployeesByName(name);
	}

//API thêm nhân viên
	@PostMapping("/them")
	public String themNhanVien(@RequestBody Nhanvien nhanVien) {
		nhanVienService.themNhanVien(nhanVien);
		return "Thêm nhân viên thành công";
	}

	// API update nhân viên
	@PutMapping("/update/{id_nv}")
	public String updateNhanVien(@PathVariable Long id_nv, @RequestBody Nhanvien nhanVien) {
		int result = nhanVienService.updateNhanvien(id_nv, nhanVien);
		if (result > 0) {
			return "Cập nhật nhân viên thành công";
		} else {
			return "Cập nhật nhân viên thất bại";
		}
	}

	// API xoá nhân viên
	@DeleteMapping("/delete/{id_nv}")
	public String deleteNhanVien(@PathVariable Long id_nv) {
		int result = nhanVienService.xoaNhanvien(id_nv);
		if (result > 0) {
			return "Xoá nhân viên thành công";
		} else {
			return "Xoá nhân viên thất bại";
		}
	}

}
