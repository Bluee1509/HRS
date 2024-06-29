package hrs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrs.dtos.QuaTrinhLamViecDTO;
import hrs.repositories.QuaTrinhLamViecRepository;

@Service
public class QuaTrinhLamViecService {
	@Autowired
    private QuaTrinhLamViecRepository quaTrinhLamViecDAO;

    // Hàm hiển thị toàn bộ quá trình làm việc
    public List<QuaTrinhLamViecDTO> getAllWorkProcesses() {
        return quaTrinhLamViecDAO.getAllWorkProcesses();
    }

    // Hàm tìm kiếm quá trình làm việc theo ID nhân viên
    public List<QuaTrinhLamViecDTO> findWorkProcessesByEmployeeId(int id_nv) {
        return quaTrinhLamViecDAO.findWorkProcessesByEmployeeId(id_nv);
    }

    // Hàm thêm quá trình làm việc
    public int addWorkProcess(QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
        return quaTrinhLamViecDAO.addWorkProcess(quaTrinhLamViecDTO);
    }

    // Hàm sửa quá trình làm việc
    public int updateWorkProcess(int id_qtlv, QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
        return quaTrinhLamViecDAO.updateWorkProcess(id_qtlv, quaTrinhLamViecDTO);
    }

    // Hàm xoá quá trình làm việc
    public int deleteWorkProcess(int id_qtlv) {
        return quaTrinhLamViecDAO.deleteWorkProcess(id_qtlv);
    }
}
