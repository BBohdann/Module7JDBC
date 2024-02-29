package mapper;

import config.ResultSetMapper;
import storage.MaxSalaryWorker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaxSalaryWorkerMapper implements ResultSetMapper<MaxSalaryWorker> {
    @Override
    public MaxSalaryWorker map(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(1);
        int salary = resultSet.getInt(2);
        return new MaxSalaryWorker(name, salary);
    }
}
