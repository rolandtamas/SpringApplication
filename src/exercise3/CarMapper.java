package exercise3;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CarMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.setID(rs.getInt("ID"));
		car.setMileage(rs.getInt("Mileage"));
		car.setManufacturingYear(rs.getInt("ManufacturingYear"));
		car.setBrand(rs.getString("Brand"));		
		car.setColour(rs.getString("Colour"));		
		car.setRegistrationNumber(rs.getString("RegistrationNumber"));
		
		return car;
	}
		
}
