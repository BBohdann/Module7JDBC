package mapper;

import config.ResultSetMapper;
import storage.MaxProjectCountClient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaxProjectCountClientMapper implements ResultSetMapper<MaxProjectCountClient> {
    @Override
    public MaxProjectCountClient map(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(1);
        int projectCount = resultSet.getInt(2);
        return new MaxProjectCountClient(name, projectCount);
    }
}

