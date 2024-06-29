package hrs.repositories;

import java.util.List;

import hrs.dtos.QuaTrinhLamViecDTO;

public interface QuaTrinhLamViecRepository {
	List<QuaTrinhLamViecDTO> getAllWorkProcesses();
	List<QuaTrinhLamViecDTO> findWorkProcessesByEmployeeId(int id_nv);
	int addWorkProcess(QuaTrinhLamViecDTO quaTrinhLamViecDTO);
	int updateWorkProcess(int id_qtlv, QuaTrinhLamViecDTO quaTrinhLamViecDTO);
	int deleteWorkProcess(int id_qtlv);
}
