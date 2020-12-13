package SpringMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService implements StudentInterface {
    public DbConnection connection;

    public DbConnection getConnection() {
        return connection;
    }

    public void setConnection(DbConnection connection) {
        this.connection = connection;
    }

    public StudentService(DbConnection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public void add(StudentData data) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO student VALUES ( ?, ? )";
        PreparedStatement query = connection.prepareStatement(quer1);

        query.setString(1, data.getSnumber());
        query.setString(2, data.getSname());
        query.setDouble(3, data.getGpa());

        query.executeUpdate();

        System.out.println("One record added");
    }

    @Override
    public StudentData edit(StudentData data, String sdata) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = connection.prepareStatement("Update student set snumber=?, sname=? where snumber = ?");
        query.setString(1, data.getSnumber());
        query.setString(2, data.getSname());
        query.setDouble(2, data.getGpa());
        query.setString(3, sdata);

        query.executeUpdate();

        System.out.println("One record edited");
        return data;
    }

    @Override
    public void delete(String snumber) throws SQLException {
        String quer1 = "Delete from student where snumber = ?";
        PreparedStatement query = connection.prepareStatement(quer1);
        query.setString(1, snumber);
        query.executeUpdate();

        System.out.println("One record Deleted");

    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from student";
        PreparedStatement query = connection.prepareStatement(quer1);


        ResultSet rs = query.executeQuery();

        StudentData obj1;

        //display records if there is data;

        while (rs.next()) {

            obj1 = new StudentData(rs.getString("snumber"), rs.getString("sname"));


            System.out.println();

            System.out.print("Student number: " + obj1.getSnumber() + "  ");
            System.out.print("Student name " + obj1.getSname());
            System.out.print("Student GPA " + obj1.getGpa());
        }

    }
}
