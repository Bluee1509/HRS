package hrs.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hrs.entities.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public User findByEmail(String email) {
		String sql = "SELECT * from taikhoan WHERE email LIKE ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { email }, new UserMapper());
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM taikhoan;";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	


	
}

class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id_taikhoan"));
		user.setEmail(rs.getString("email"));
		user.setFullName(rs.getString("hoten"));
		user.setPassword(rs.getString("pwd"));
		user.setRole(rs.getString("vaitro"));
		return user;
	}
}