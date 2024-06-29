package hrs.controllers;

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

import hrs.dtos.QuaTrinhLamViecDTO;
import hrs.services.QuaTrinhLamViecService;

@RestController
@RequestMapping("/users/qtlv")
public class QuaTrinhLamViecController {
	@Autowired
    private QuaTrinhLamViecService quaTrinhLamViecService;

    // API hiển thị toàn bộ quá trình làm việc
    @GetMapping("/work-processes")
    public List<QuaTrinhLamViecDTO> getAllWorkProcesses() {
        return quaTrinhLamViecService.getAllWorkProcesses();
    }

    // API tìm kiếm quá trình làm việc theo ID nhân viên
    @GetMapping("/work-processes/search")
    public List<QuaTrinhLamViecDTO> findWorkProcessesByEmployeeId(@RequestParam int id_nv) {
        return quaTrinhLamViecService.findWorkProcessesByEmployeeId(id_nv);
    }

    // API thêm quá trình làm việc
    @PostMapping("/work-processes")
    public int addWorkProcess(@RequestBody QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
        return quaTrinhLamViecService.addWorkProcess(quaTrinhLamViecDTO);
    }

    // API sửa quá trình làm việc
    @PutMapping("/work-processes/{id_qtlv}")
    public int updateWorkProcess(@PathVariable int id_qtlv, @RequestBody QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
        return quaTrinhLamViecService.updateWorkProcess(id_qtlv, quaTrinhLamViecDTO);
    }

    // API xoá quá trình làm việc
    @DeleteMapping("/work-processes/{id_qtlv}")
    public int deleteWorkProcess(@PathVariable int id_qtlv) {
        return quaTrinhLamViecService.deleteWorkProcess(id_qtlv);
    }
}
