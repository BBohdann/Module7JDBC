package mapper;

import config.ResultSetMapper;
import storage.YoungestEldestWorkers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class YoungestEldestWorkersMapper implements ResultSetMapper<YoungestEldestWorkers> {
    @Override
    public YoungestEldestWorkers map(ResultSet resultSet) throws SQLException {
        String type = resultSet.getString(1);
        String name = resultSet.getString(2);
        Date date = resultSet.getDate(3);
        LocalDate birthday = date.toLocalDate();
        return new YoungestEldestWorkers(type, name , birthday);
    }
}
