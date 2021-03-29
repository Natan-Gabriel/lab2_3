package app;

import domain.Student;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class MainApplicationTest {

    @Test
    public void ec_1_addStudentValid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student st= new Student("100","ana",937,"a@y.com");
        Student res=service.addStudent(st);
        System.out.println("st:"+st);
        System.out.println("res:"+res);
//        rep = new Repository("FileParticipantsMaxAll.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();

        assertEquals(res.getID(), st.getID());
    }

    @Test
    public void ec_2_addStudentInvalid() {

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        boolean aux=true;
        try {
            Student st = new Student("113", "113", -10, "113");
            Student res = service.addStudent(st);
            System.out.println("st:" + st);
            System.out.println("res:" + res);


        }
        catch(Exception e){
            aux=false;
        }
//        rep = new Repository("FileParticipantsMaxAll.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();

//        assertEquals(res.getID(), st.getID());
        assertFalse(aux);
    }


//    @Test
//    public void tc_3_AllParticipantsOnlyOne() {
//        rep = new Repository("FileParticipantsMaxOne.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();
//
//        assertEquals(1, noParticipantsMax);
//    }
}
