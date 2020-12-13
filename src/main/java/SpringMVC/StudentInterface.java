package SpringMVC;

import java.sql.SQLException;

public interface StudentInterface {
    //interface containing add, delete, update, edit methods
    public void add(StudentData data) throws ClassNotFoundException, SQLException;
    public StudentData edit(StudentData data, String sdata) throws SQLException, ClassNotFoundException;
    public void delete(String snumber) throws SQLException;
    public void display() throws ClassNotFoundException, SQLException;
}
