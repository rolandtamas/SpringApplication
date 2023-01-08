package exercise3;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarController {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(String brand, String registrationNumber, String colour, int manufacturingYear, int mileage)
	{
		String sqlCommand = "INSERT INTO cars (Brand, Colour, ManufacturingYear, Mileage, RegistrationNumber) VALUES (?, ?, ?, ?, ?)";
		int res = jdbcTemplate.update(sqlCommand, brand, colour, manufacturingYear, mileage, registrationNumber);
		if (res == 1)
		{
			getLastCar();
		}
	}
	
	public List<Car> getCars()
	{
		String sqlCommand = "SELECT * FROM cars";
		List<Car> cars;
		try {
			cars = jdbcTemplate.query(sqlCommand, new CarMapper());
			return cars;
		} catch (DataAccessException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Car getCar(int id)
	{
		String sqlCommand = "SELECT * FROM cars WHERE id = ?";
		try {
			Car car = jdbcTemplate.queryForObject(sqlCommand, new Object[]{id}, new CarMapper());
			return car;
		} catch (DataAccessException e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	public Car getLastCar()
	{
		String sqlCommand = "SELECT * FROM cars ORDER BY id DESC LIMIT 1";
		try {
			Car car = jdbcTemplate.queryForObject(sqlCommand, new CarMapper());
			return car;
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public Car getCar(String brand)
	{
		String sqlCommand = "SELECT * FROM cars WHERE Brand = ?";
		try {
			Car car = jdbcTemplate.queryForObject(sqlCommand, new Object[]{brand}, new CarMapper());
			return car;
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public void updateRegistrationNumber(int id, String registrationNumber)
	{
		String sqlCommand = "UPDATE cars SET RegistrationNumber = ? WHERE id = ?";
		jdbcTemplate.update(sqlCommand, registrationNumber, id);
	}
	
	public void updateColour(int id, String colour)
	{
		String sqlCommand = "UPDATE cars SET colour = ? WHERE id = ?";
		jdbcTemplate.update(sqlCommand, colour, id);
	}
	
	public void updateBrand(int id, String brand)
	{
		String sqlCommand = "UPDATE cars SET brand = ? WHERE id = ?";
		jdbcTemplate.update(sqlCommand, brand, id);
	}
	
	public void updateMileage(int id, int mileage)
	{
		String sqlCommand = "UPDATE cars SET mileage = ? WHERE id = ?";
		jdbcTemplate.update(sqlCommand, mileage, id);
	}
	
	public void updateManufacturingYear(int id, int manufacturingYear)
	{
		String sqlCommand = "UPDATE cars SET manufacturingYear = ? WHERE id = ?";
		jdbcTemplate.update(sqlCommand, manufacturingYear, id);
	}
	
	public void delete(int id)
	{
		String sqlCommand = "DELETE FROM cars WHERE id = ?";
		jdbcTemplate.update(sqlCommand, id);		
	}
	
	public void deleteAll()
	{
		String sqlCommand = "DELETE * FROM cars";
		jdbcTemplate.update(sqlCommand);
	}
	
	

}
