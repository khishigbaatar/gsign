package biz.gsign.user;

import biz.gsign.restutils.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataMapper {
    private static RowMapper<DatabaseUser> userDataMapper = (rs, rownum) ->
            new DatabaseUser(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("fullName"),
                    rs.getString("company_name")
            );
    private JdbcTemplate jdbcTemplate;

    public UserDataMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DatabaseUser getByUsername(String username) {
        String queryString = "SELECT * FROM gsignuser WHERE username=?";
        try {
            DatabaseUser user = jdbcTemplate.queryForObject(
                    queryString,
                    (rs, i) ->
                            new DatabaseUser(
                                    rs.getLong("id"),
                                    rs.getString("username"),
                                    rs.getString("fullname"),
                                    rs.getString("company_name"), rs.getString("password")
                            ), username
            );
            return user;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("User not found for name: " + username);
        }
    }
}
