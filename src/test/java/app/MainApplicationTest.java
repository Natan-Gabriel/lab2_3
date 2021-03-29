package app;

import domain.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class MainApplicationTest {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("fisiere/Studenti.xml");
        writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><inbox></inbox>");
        // other operations
        writer.close();
    }

    @Test
    public void tc_1_addStudentValid()  {


        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("100","ana",937,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_2_addStudentGroupInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("101", "ana", -10, "a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_3_addStudentIDInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student(null, "ana", 937, "a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);

        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_4_addStudentIDInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("", "ana", 937, "a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_5_addStudentNameInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("102", null, 937, "a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_6_addStudentNameInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("103", "", 937, "a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_7_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("104", "ana", 937,null);
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_8_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("105", "ana", 937,"ana");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_9_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("106", "ana", 937,"");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_10_addStudentIDValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("a","ana",937,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(service.findStudent(st.getID()), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_11_addStudentNameValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("200","a",937,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_12_addStudentGroupInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("201", "ana", -1,"a@yahoo.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_13_addStudentGroupValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("202","ana",0,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_14_addStudentGroupValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("203","ana",1,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_15_addStudentGroupValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("204","ana", Integer.MAX_VALUE-1,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_16_addStudentGroupValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("205","ana", Integer.MAX_VALUE,"a@yahoo.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findStudent(st.getID()));
    }

    @Test
    public void tc_17_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("206", "ana", 937,"@a.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_18_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("207", "ana", 937,"a@.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_19_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("208", "ana", 937,"a@a");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_20_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("209", "ana", 937,"aa.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_21_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("210", "ana", 937,"a@-y.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_22_addStudentEmailInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";


        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("211", "ana", 937,".com@y.com");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }
}