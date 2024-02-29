package mapper;

import config.ResultSetMapper;
import storage.LongestProject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LongestProjectMapper implements ResultSetMapper<LongestProject> {
    @Override
    public LongestProject map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int mountsCount = resultSet.getInt(2);
        return new LongestProject(id, mountsCount);
    }
}