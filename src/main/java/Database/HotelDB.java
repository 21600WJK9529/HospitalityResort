package Database;
import Register.MaintenanceRegister;
import Staff.Maintenance.Maintenance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelDB {
    Connection con;
    Statement stmt;
    ResultSet resultSet;
    public static String getProgramPath() throws IOException{

        String currentDir = System.getProperty("user.dir");

        currentDir = currentDir.replace("\\", "/");

        return currentDir;

    }

    public void connect() throws IOException {
        String filename = HotelDB.getProgramPath() + "/db/HotelDB.accdb";
        //url to the database to make the java connection
        String dbURL = "jdbc:ucanaccess://" + filename.trim() + ";DriverID=22;READONLY=true}";
        //the driver name
        String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";
        try {

            System.out.println("About to Load the JDBC Driver....");

            Class.forName(driverName);

            System.out.println("Driver Loaded Successfully....");
            System.out.println("About to get a connection....");

            con = DriverManager.getConnection(dbURL, "", "");

            System.out.println("Connection Established Successfully....");
        } catch (Exception err) {

            System.out.println("ERROR: " + err);

        }

    }
    public void disconnect() throws SQLException{

        con.close(); // close the Connection to let the database know we're done with it
        System.out.println("Closed successfully....");

    }
    public void createTables(){
        String employee = "CREATE TABLE EMPLOYEE(EmpId VARCHAR, fName VARCHAR, lName VARCHAR, email VARCHAR, facility VARCHAR, phoneNo VARCHAR)";
        //private String id,fName,lName,email,facility,phoneNo;
        try {

            stmt.execute(employee);
        }catch (SQLException ex){
            Logger.getLogger(HotelDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void populateDatabase() {
        String emp1 = "INSERT INTO EMPLOYEE VALUES('A1', 'John', 'Doe', 'a@fasd.com', 'Restaurant', '0211234567')";
        try {
            stmt.execute(emp1);
        }catch (SQLException ex) {
            Logger.getLogger(HotelDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<MaintenanceRegister> getMeals(){
        String getAll = "SELECT * FROM EMPLOYEE";

        ArrayList<MaintenanceRegister> maintenanceRegister = new ArrayList<>();
        try {

            resultSet = stmt.executeQuery(getAll);

            while(resultSet.next()){

                String id = resultSet.getString("EmpId");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String email = resultSet.getString("Email");
                String facility = resultSet.getString("Facility");
                String phoneNo = resultSet.getString("PhoneNo");

                MaintenanceRegister staffMaintenance = new MaintenanceRegister(id,fName,lName,email,facility,phoneNo);

                maintenanceRegister.add(staffMaintenance);

            }
        }catch(SQLException ex){
            Logger.getLogger(MaintenanceRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maintenanceRegister;
    }
}
