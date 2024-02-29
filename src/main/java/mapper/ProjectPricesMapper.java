package mapper;

import config.ResultSetMapper;
import storage.MaxProjectCountClient;
import storage.ProjectPrices;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ProjectPricesMapper implements ResultSetMapper<ProjectPrices> {
    @Override
    public ProjectPrices map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int price = resultSet.getInt(2);
        return new ProjectPrices(id, price);
    }
}
