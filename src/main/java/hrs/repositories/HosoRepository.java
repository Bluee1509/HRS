package hrs.repositories;

import java.util.List;

import hrs.dtos.HoSoDTO;
import hrs.responses.HosoResponse;

public interface HosoRepository {
	int addHoSo(HoSoDTO hoSoDTO, String hopdonglaodongPath, String bangluongPath, String baohiemXhPath, String baohiemYtePath);
	int updateHoSo(int id_hoso, HoSoDTO hoSoDTO, String hopdonglaodongPath, String bangluongPath, String baohiemXhPath, String baohiemYtePath);
	int deleteHoSo(int id_hoso);
	List<HosoResponse> searchHoSoByTenNhanVien(String tenNhanVien);
	List<HosoResponse> getAllHoSo();
}
