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
    public void tc_1_addTemaValid() {

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
    public void tc_2_addTemaDuplicateID() {

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
        Tema t = new Tema("1", "alta descriere", 3, 3);
        Tema nt = service.addTema(t);
        Tema t2 = new Tema("1", "alta descriere", 3, 3);
        Tema nt2 = service.addTema(t2);
        System.out.println("t:" + t);
        System.out.println("nt:" + nt);
        System.out.println("t2:" + t2);
        System.out.println("nt2:" + nt2);
        assertNotNull(nt2);
    }

    @Test
    public void tc_3_addTemaIDInvalid() {

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
            Tema t = new Tema(null, "descriere", 3, 3);
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
    public void tc_4_addTemaDescriptionInvalid() {

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
            Tema t = new Tema("2", "", 3, 3);
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
    public void tc_5_addTemaDeadlineInvalid() {

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
            Tema t = new Tema("3", "descriere", -1, 3);
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
    public void tc_6_addTemaPrimireInvalid() {

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
            Tema t = new Tema("4", "descriere", 3, 16);
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
