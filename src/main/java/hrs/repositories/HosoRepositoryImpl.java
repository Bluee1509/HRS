package hrs.repositories;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import hrs.dtos.HoSoDTO;
import hrs.responses.HosoResponse;

@Repository
public class HosoRepositoryImpl implements HosoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addHoSo(HoSoDTO hoSoDTO, String hopdonglaodongPath, String bangluongPath, String baohiemXhPath,
			String baohiemYtePath) {
		String sql = "INSERT INTO hoso (id_nv, hopdonglaodong, bangluong, baohiem_xh, baohiem_yte) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, hoSoDTO.getId_nv(), hopdonglaodongPath, bangluongPath, baohiemXhPath,
				baohiemYtePath);
	}

	public int updateHoSo(int id_hoso, HoSoDTO hoSoDTO, String hopdonglaodongPath, String bangluongPath,
			String baohiemXhPath, String baohiemYtePath) {
		StringBuilder sql = new StringBuilder("UPDATE hoso SET ");
		boolean first = true;

		if (hoSoDTO.getId_nv() != null) {
			sql.append("id_nv = ?");
			first = false;
		}
		if (hopdonglaodongPath != null) {
			if (!first)
				sql.append(", ");
			sql.append("hopdonglaodong = ?");
			first = false;
		}
		if (bangluongPath != null) {
			if (!first)
				sql.append(", ");
			sql.append("bangluong = ?");
			first = false;
		}
		if (baohiemXhPath != null) {
			if (!first)
				sql.append(", ");
			sql.append("baohiem_xh = ?");
			first = false;
		}
		if (baohiemYtePath != null) {
			if (!first)
				sql.append(", ");
			sql.append("baohiem_yte = ?");
			first = false;
		}
		sql.append(" WHERE id_hoso = ?");

		return jdbcTemplate.update(sql.toString(), ps -> {
			int index = 1;
			if (hoSoDTO.getId_nv() != null)
				ps.setInt(index++, hoSoDTO.getId_nv());
			if (hopdonglaodongPath != null)
				ps.setString(index++, hopdonglaodongPath);
			if (bangluongPath != null)
				ps.setString(index++, bangluongPath);
			if (baohiemXhPath != null)
				ps.setString(index++, baohiemXhPath);
			if (baohiemYtePath != null)
				ps.setString(index++, baohiemYtePath);
			ps.setInt(index, id_hoso);
		});
	}

	public int deleteHoSo(int id_hoso) {
		String sql = "DELETE FROM hoso WHERE id_hoso = ?";
		return jdbcTemplate.update(sql, id_hoso);
	}

	// Hàm lấy danh sách tất cả hồ sơ
	public List<HosoResponse> getAllHoSo() {
		String sql = "SELECT h.*, n.hoten FROM hoso h INNER JOIN nhanvien n ON h.id_nv = n.id_nv";
		return jdbcTemplate.query(sql, new HoSoRowMapper());
	}

	// Hàm tìm kiếm hồ sơ theo tên nhân viên
	public List<HosoResponse> searchHoSoByTenNhanVien(String tenNhanVien) {
		String sql = "SELECT h.*, n.hoten FROM hoso h INNER JOIN nhanvien n ON h.id_nv = n.id_nv WHERE n.hoten LIKE ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + tenNhanVien + "%" }, new HoSoRowMapper());
	}

}

// Hàm map dữ liệu từ ResultSet sang HoSoDTO
class HoSoRowMapper implements RowMapper<HosoResponse> {
	@Override
	public HosoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		HosoResponse hoSo = new HosoResponse();
		hoSo.setId(rs.getInt("id_hoso"));
		hoSo.setIdNhanVien(rs.getInt("id_nv"));
		hoSo.setBangluongPath(rs.getString("bangluong"));
		hoSo.setHopdonglaodongPath(rs.getString("hopdonglaodong"));
		hoSo.setBaohiemxahoiPath(rs.getString("baohiem_xh"));
		hoSo.setBaohiemytePath(rs.getString("baohiem_yte"));
		hoSo.setHoten(rs.getString("hoten"));
		return hoSo;
	}
}
