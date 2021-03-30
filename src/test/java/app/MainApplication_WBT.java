package app;


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

import static org.junit.Assert.*;
public class MainApplication_WBT {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("fisiere/Teme.xml");
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><inbox></inbox>");
        writer.close();
    }

    @Test
    public void tc_1_addTemaIDInvalid() {

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
            Tema t = new Tema(null, "descriere", 2, 2);
            Tema nt = service.addTema(t);
            System.out.println("t:" + t);
            System.out.println("nt:" + nt);
        }
	    catch(Exception e){
                aux=false;
        }

        assertFalse(aux);
    }


    @Test
    public void tc_2_addTemaValid() {

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

        Tema tema= new Tema("1","description",12,11);
        Tema res=service.addTema(tema);
        System.out.println("tema:"+tema);
        System.out.println("res:"+res);

        //assertEquals(res.getID(), st.getID());
        assertNotNull(service.findTema(tema.getID()));
    }

    @Test
    public void tc_3_addTemaDescriptionInvalid() {

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
            Tema t = new Tema("2", "", 2, 2);
            Tema nt = service.addTema(t);
            System.out.println("t:" + t);
            System.out.println("nt:" + nt);
        }
        catch(Exception e){
            aux=false;
        }

        assertFalse(aux);
    }

    @Test
    public void tc_4_addTemaDeadlineInvalid() {

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
            Tema t = new Tema("3", "description", 15, 2);
            Tema nt = service.addTema(t);
            System.out.println("t:" + t);
            System.out.println("nt:" + nt);
        }
        catch(Exception e){
            aux=false;
        }

        assertFalse(aux);
    }
    @Test
    public void tc_3_addTemaPrimireInvalid() {

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
            Tema t = new Tema("2", "", 2, 15);
            Tema nt = service.addTema(t);
            System.out.println("t:" + t);
            System.out.println("nt:" + nt);
        }
        catch(Exception e){
            aux=false;
        }

        assertFalse(aux);
    }
}
