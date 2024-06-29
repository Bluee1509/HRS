package hrs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrs.dtos.HoSoDTO;
import hrs.responses.HosoResponse;
import hrs.services.HoSoService;

@RestController
@RequestMapping("/users/hoso")
public class HoSoController {

    @Autowired
    private HoSoService hoSoService;

    @PostMapping("/add")
    public String addHoSo(@ModelAttribute HoSoDTO hoSoDTO) {
        int result = hoSoService.addHoSo(hoSoDTO);
        if (result > 0) {
            return "Thêm hồ sơ thành công";
        } else {
            return "Thêm hồ sơ thất bại";
        }
    }

    @PutMapping("/update/{id_hoso}")
    public String updateHoSo(@PathVariable int id_hoso, @ModelAttribute HoSoDTO hoSoDTO) {
    	System.out.println(hoSoDTO.toString());
        int result = hoSoService.updateHoSo(id_hoso, hoSoDTO);
        if (result > 0) {
            return "Cập nhật hồ sơ thành công";
        } else {
            return "Cập nhật hồ sơ thất bại";
        }
    }

    @DeleteMapping("/delete/{id_hoso}")
    public String deleteHoSo(@PathVariable int id_hoso) {
        int result = hoSoService.deleteHoSo(id_hoso);
        if (result > 0) {
            return "Xóa hồ sơ thành công";
        } else {
            return "Xóa hồ sơ thất bại";
        }
    }
    // API hiển thị tất cả hồ sơ
    @GetMapping
    public List<HosoResponse> getAllHoSo() {
        return hoSoService.getAllHoSo();
    }

    // API tìm kiếm hồ sơ theo tên nhân viên
    @GetMapping("/search")
    public List<HosoResponse> searchHoSoByTenNhanVien(@RequestParam String tenNhanVien) {
        return hoSoService.searchHoSoByTenNhanVien(tenNhanVien);
    }
}