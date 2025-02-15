package ru.leonchenko.users.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.leonchenko.users.entity.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<User> rowMapper = (rs, rowNum) ->
            new User(rs.getLong("id"), rs.getString("username"));

    public void createUser(String username) {
        var sql = "INSERT INTO users (username) VALUES (?) ON CONFLICT DO NOTHING";
        jdbcTemplate.update(sql, username);
    }

    public Optional<User> getUserById(Long id) {
        var sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.query(sql, rowMapper, id).stream().findFirst();
    }

    public List<User> getAllUsers() {
        var sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void updateUser(Long id, String newUsername) {
        var sql = "UPDATE users SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql, newUsername, id);
    }

    public void deleteUser(Long id) {
        var sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
