package app;

import domain.Nota;
import domain.Student;
import domain.Tema;
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
import java.time.LocalDate;

import static org.junit.Assert.*;

public class MainApplication_BigBang {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("fisiere/Studenti.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><inbox></inbox>");
        writer.close();

        PrintWriter writer2 = new PrintWriter("fisiere/Teme.xml");
        writer2.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><inbox></inbox>");
        writer2.close();

        PrintWriter writer3 = new PrintWriter("fisiere/Note.xml");
        writer3.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><inbox></inbox>");
        writer3.close();
    }

    @Test
    public void tc_1_addStudentValid() {

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
    public void tc_2_addAssignmentValid() {
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

        Tema tema= new Tema("0","descriere",2,2);
        Tema res=service.addTema(tema);
        System.out.println("tema:"+tema);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findTema(tema.getID()));
    }

    @Test
    public void tc_3_addGradeInvalid() {
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
            Nota nota = new Nota("1", "1000", "10", 8, LocalDate.of(2020, 1, 8));
            Double res3 = service.addNota(nota, "feedback");
        }
            catch(Exception e){
            aux=false;
        }
        assertFalse(aux);
    }

    @Test
    public void tc_4_addGradeValid() {
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

        Tema tema= new Tema("400","descriere",8,8);
        Tema res2=service.addTema(tema);

        Nota nota = new Nota("2", "100", "400", 8, LocalDate.of(2021, 4, 13));
        Double res3 = service.addNota(nota, "feedback");

        //TODO assertNull(res3);
        assertEquals((double)res3, 8.0, 0);
    }
}
