package learn.anotation.sptingbootrestapi.controller;

import learn.anotation.sptingbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller@ResponseBody
@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public Student getStudent(){
        Student student = new Student(1,"rj","bs");
        return student;
    }

    // ResponseEntity
    @GetMapping("all")
    public ResponseEntity<Student> getNewStudent(){
        Student student = new Student(1,"rj","bs");
//        return ResponseEntity.ok(student);
//        return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("name", "Rajesh")
                .body(student);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"rj","bs"));
        students.add(new Student(2,"ravi","np"));
        students.add(new Student(3,"isha","jp"));

        return ResponseEntity.ok(students);
    }

    // Spring boot rest api with path variable
    // {id} - URI template variable
    //http://localhost:8080/student/5/raja/bis
    @GetMapping("/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){

        return ResponseEntity.ok(new Student(studentId,"rj","bs"));
    }

    @GetMapping("/{id}/{fName}/{lName}")
    public ResponseEntity<Student> studentPathVariables(@PathVariable int id,
                                        @PathVariable("fName") String fn,
                                        @PathVariable String lName){

        return ResponseEntity.ok(new Student(id,fn,lName));
    }

    //Request Param
    //http://localhost:8080/student/query?id=1
    @GetMapping("query")
    public Student studentQueryParam(@RequestParam int id){

        return new Student(id,"rj","bs");
    }

    //http://localhost:8080/student/querys?id=1&fn=rj&ln=bs
    @GetMapping("querys")
    public Student studentQueryParams(@RequestParam int id,
                                      @RequestParam String fn,
                                      @RequestParam  String ln){

        return new Student(id,fn,ln);
    }

    // API Post request
    //http://localhost:8080/student/create
    //with body {"id" : 55,"firstName" : "maa","lastName" : "mom"}
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId()+ student.getFirstName()+ student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    // PUT API
    // http://localhost:8080/student/743/update
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        Student student1 = new Student(55,"ram","jav");
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setId(studentId);
        return student1;
    }

    // Delete api
    //http://localhost:8080/student/743/delete
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable int id){
        return "Student delete successfully. id = "+id;
    }
}
