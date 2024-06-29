package hrs.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hrs.dtos.QuaTrinhLamViecDTO;

@Repository
public class QuaTrinhLamViecRepositoryImpl implements QuaTrinhLamViecRepository{
	   @Autowired
	   private JdbcTemplate jdbcTemplate;
	   
	   public List<QuaTrinhLamViecDTO> getAllWorkProcesses() {
	        String sql = "SELECT * FROM quatrinhlamviec";
	        return jdbcTemplate.query(sql, new QuaTrinhLamViecMapper());
	    }

	    // Hàm tìm kiếm quá trình làm việc theo ID nhân viên
	    public List<QuaTrinhLamViecDTO> findWorkProcessesByEmployeeId(int id_nv) {
	        String sql = "SELECT * FROM quatrinhlamviec WHERE id_nv = ?";
	        return jdbcTemplate.query(sql, new Object[]{id_nv}, new QuaTrinhLamViecMapper());
	    }

	    // Hàm thêm quá trình làm việc
	    public int addWorkProcess(QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
	        String sql = "INSERT INTO quatrinhlamviec (id_nv, ngayvaolam, bophan, chucvu, trinhdohocvan) VALUES (?, ?, ?, ?, ?)";
	        return jdbcTemplate.update(sql, quaTrinhLamViecDTO.getId_nv(), quaTrinhLamViecDTO.getNgayvaolam(), quaTrinhLamViecDTO.getBophan(), quaTrinhLamViecDTO.getChucvu(), quaTrinhLamViecDTO.getTrinhdohocvan());
	    }

	    // Hàm sửa quá trình làm việc
	    public int updateWorkProcess(int id_qtlv, QuaTrinhLamViecDTO quaTrinhLamViecDTO) {
	        StringBuilder sql = new StringBuilder("UPDATE quatrinhlamviec SET ");
	        List<Object> params = new ArrayList<>();

	        if (quaTrinhLamViecDTO.getNgayvaolam() != null) {
	            sql.append("ngayvaolam = ?, ");
	            params.add(quaTrinhLamViecDTO.getNgayvaolam());
	        }
	        if (quaTrinhLamViecDTO.getBophan() != null) {
	            sql.append("bophan = ?, ");
	            params.add(quaTrinhLamViecDTO.getBophan());
	        }
	        if (quaTrinhLamViecDTO.getChucvu() != null) {
	            sql.append("chucvu = ?, ");
	            params.add(quaTrinhLamViecDTO.getChucvu());
	        }
	        if (quaTrinhLamViecDTO.getTrinhdohocvan() != null) {
	            sql.append("trinhdohocvan = ?, ");
	            params.add(quaTrinhLamViecDTO.getTrinhdohocvan());
	        }

	        // Remove last comma and space
	        if (params.size() > 0) {
	            sql.setLength(sql.length() - 2);
	        }

	        sql.append(" WHERE id_qtlv = ?");
	        params.add(id_qtlv);

	        return jdbcTemplate.update(sql.toString(), params.toArray());
	    }

	    // Hàm xoá quá trình làm việc
	    public int deleteWorkProcess(int id_qtlv) {
	        String sql = "DELETE FROM quatrinhlamviec WHERE id_qtlv = ?";
	        return jdbcTemplate.update(sql, id_qtlv);
	    }

	    private static class QuaTrinhLamViecMapper implements RowMapper<QuaTrinhLamViecDTO> {
	        @Override
	        public QuaTrinhLamViecDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            QuaTrinhLamViecDTO quaTrinhLamViecDTO = new QuaTrinhLamViecDTO();
	            quaTrinhLamViecDTO.setId_qtlv(rs.getInt("id_qtlv"));
	            quaTrinhLamViecDTO.setId_nv(rs.getInt("id_nv"));
	            quaTrinhLamViecDTO.setNgayvaolam(rs.getString("ngayvaolam"));
	            quaTrinhLamViecDTO.setBophan(rs.getString("bophan"));
	            quaTrinhLamViecDTO.setChucvu(rs.getString("chucvu"));
	            quaTrinhLamViecDTO.setTrinhdohocvan(rs.getString("trinhdohocvan"));
	            return quaTrinhLamViecDTO;
	        }
	    }
}
