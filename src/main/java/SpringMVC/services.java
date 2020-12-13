package SpringMVC;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class services {


    private static List<StudentData> records = new ArrayList<StudentData>();
    private static int recordCount = 3;

    static {
        records.add(new StudentData(10006, "Johny Jacobi", 3.0, false));
        records.add(new StudentData(10007, "Joseph Phil", 3.6, false));
        records.add(new StudentData(1008, "Jammer Diaz", 3.2, false));
    }


    public List<StudentData> retrieveTodos(String user) {
        List<StudentData> filteredTodos = new ArrayList<StudentData>();
        for (StudentData todo : records) {
            if (todo.getUser().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

//    public void addTodo(String num, String name, double gpa) {
//        records.add(new StudentData(++recordCount, num, name, gpa));
//    }


    public void addRecords(int id, String user, int snumber, String name, double gpa) {
        records.add(new StudentData(id, user, snumber, name, gpa));
    }

    public void deleteTodo(int id) {
        Iterator<StudentData> iterator = records.iterator();
        while (iterator.hasNext()) {
            StudentData todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public StudentData retrieve(int id){

        for(StudentData data: records){
            if(data.getId()==id){
                return data;
            }
        }
        return null;

    }

    public void update(StudentData data){
        records.remove(data);
        records.add(data);
    }
}
