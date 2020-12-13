package SpringMVC;

//https://github.com/Puriaryan/Aryan_300298183.git

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;


@SessionAttributes({"name","id"})


@Controller
@RequestMapping
public class StudentController {

    @Autowired
    services service;


    @RequestMapping(value ="/list-records", method = RequestMethod.GET)
    public String showpage(ModelMap model){
        String user = (String) model.get("name");


        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";

    }


    @RequestMapping(value ="/add-record", method = RequestMethod.GET)
    public String showtodopage(){
        return "StudentRecord";
    }

    @RequestMapping(value ="/add-record", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String num) {
        service.addRecords(10006,"Johny Jocob",10006,"Johny Jacob", 3.0);

        model.clear();
        return "redirect:/list-records";
    }


    @RequestMapping(value = "/update-records", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        model.addAttribute("todo", service.retrieve(id));

        model.put("id", id);

        return "todo";
    }

    //mapping the records to update
    @RequestMapping(value = "/update-records", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String desc) {



        int us = (int) model.get("id");

        System.out.println(us);

        service.deleteRecords(us);

        service.addRecords(us,"1", 10006,"Johny Jacobi",3.0);


        model.clear();
        return "redirect:/list-todos";

    }


    // mapping the records to delete
    @RequestMapping(value ="/delete-records", method = RequestMethod.GET)
    public String deleteRecords(ModelMap model, @RequestParam int id){


        service.deleteRecords(id);

        model.clear();
        return "redirect:/list-todos";
    }

}
