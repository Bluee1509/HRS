package hrs.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hrs.entities.Nhanvien;

@Repository
public class NhanvienRepositoryImpl implements NhanvienRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Nhanvien nhanvien) {
		String sql = "INSERT INTO nhanvien (hoten, ngaysinh, diachi, sdt, email) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, nhanvien.getHoten(), nhanvien.getNgaysinh(), nhanvien.getDiachi(),
				nhanvien.getSdt(), nhanvien.getEmail());
	}

	@Override
	// Phương thức cập nhật các trường của nhân viên theo id_nv
	public int updateNhanvien(Long id_nv, Nhanvien nhanVien) {
		StringBuilder sql = new StringBuilder("UPDATE nhanvien SET ");
		List<Object> params = new ArrayList<>();

		// Xây dựng câu lệnh SQL dynamic
		if (nhanVien.getHoten() != null) {
			sql.append("hoten = ?, ");
			params.add(nhanVien.getHoten());
		}
		if (nhanVien.getNgaysinh() != null) {
			sql.append("ngaysinh = ?, ");
			params.add(nhanVien.getNgaysinh());
		}
		if (nhanVien.getDiachi() != null) {
			sql.append("diachi = ?, ");
			params.add(nhanVien.getDiachi());
		}
		if (nhanVien.getSdt() != null) {
			sql.append("sdt = ?, ");
			params.add(nhanVien.getSdt());
		}
		if (nhanVien.getEmail() != null) {
			sql.append("email = ?, ");
			params.add(nhanVien.getEmail());
		}

		// Xóa dấu phẩy cuối cùng và thêm điều kiện WHERE
		sql.delete(sql.length() - 2, sql.length()).append(" WHERE id_nv = ?");
		params.add(id_nv);

		// Thực thi câu lệnh SQL
		return jdbcTemplate.update(sql.toString(), params.toArray());
	}

	@Override
	public int delete(Long id_nv) {
		String sql = "DELETE FROM nhanvien WHERE id_nv=?";
		return jdbcTemplate.update(sql, id_nv);
	}
	// Hàm hiển thị toàn bộ nhân viên
	public List<Nhanvien> getAllEmployees() {
		String sql = "SELECT * FROM nhanvien";
		return jdbcTemplate.query(sql, new NhanvienMapper());
	}

	// Hàm tìm kiếm nhân viên theo tên
	public List<Nhanvien> findEmployeesByName(String name) {
		String sql = "SELECT * FROM nhanvien WHERE hoten LIKE ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + name + "%" }, new NhanvienMapper());
	}

}

class NhanvienMapper implements RowMapper<Nhanvien> {

	@Override
	public Nhanvien mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setId_nv(rs.getLong("id_nv"));
		nhanvien.setHoten(rs.getString("hoten"));
		nhanvien.setNgaysinh(rs.getString("ngaysinh"));
		nhanvien.setDiachi(rs.getString("diachi"));
		nhanvien.setSdt(rs.getInt("sdt"));
		nhanvien.setEmail(rs.getString("email"));
		return nhanvien;
	}

}
