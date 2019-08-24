import java.sql.*;

public class Crud {

	public static void createTable()
	{
		try(Connection connection=DB.getConnection(); Statement st=connection.createStatement();) {
			String SQLCREATE= "CREATE TABLE employee (" 
            + "id INT(64) NOT NULL AUTO_INCREMENT,"    
            + "name VARCHAR(64), "
			+ "salary VARCHAR(40), "
            + "PRIMARY KEY(id))";  
			int executeUpdate=st.executeUpdate(SQLCREATE);
			System.out.println("Table created");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmployeeById() {
		try(Connection connection = DB.getConnection();Statement st = connection.createStatement();) {
			
			String SQLDELETE = "DELETE FROM employee WHERE id=1";
			int executeUpdate = st.executeUpdate(SQLDELETE);
			if(executeUpdate ==1){
				System.out.println("Employee is deleted..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void readEmployee() {
		try(Connection connection=DB.getConnection();Statement st=connection.createStatement();) {
			String SQLREAD="SELECT * FROM employee";
			ResultSet rs=st.executeQuery(SQLREAD);
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("name") + " Salary: " + rs.getString("salary"));
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	
	protected static void updateEmployeeEmailById(String name) {
		try(Connection connection = DB.getConnection();Statement st = connection.createStatement();) {
			
			String SQLUPDATE = "UPDATE employee set name='"+name+"' WHERE id=13";
			int executeUpdate = st.executeUpdate(SQLUPDATE);
			if(executeUpdate ==1){
				System.out.println("Name is updated..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createEmployee(String name) {
		try(Connection connection = DB.getConnection();Statement st = connection.createStatement();) {
			System.out.println(name);
			String SQLINSERT = "INSERT INTO employee(name,salary)VALUES('"+name+"',60000.10)";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("Employee is created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}