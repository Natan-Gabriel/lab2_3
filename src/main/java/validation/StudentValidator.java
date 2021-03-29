package validation;

import domain.Student;

import java.util.regex.Pattern;

public class StudentValidator implements Validator<Student> {

    /**
     * Valideaza un student
     * @param entity - studentul pe care il valideaza
     * @throws ValidationException - daca studentul nu e valid
     */
    @Override
    public void validate(Student entity) throws ValidationException {
        String regex="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);

        if(entity.getID().equals("")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID() == null){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getNume() == ""){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getGrupa() < 0 ) {
            throw new ValidationException("Grupa incorecta!");
        }
        if(entity.getEmail() == null){
            throw new ValidationException("Email incorect!");
        }
        if(entity.getNume() == null){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getEmail().equals("")){
            throw new ValidationException("Email incorect!");
        }
//        if(!pattern.matcher(entity.getEmail()).matches()){
//            throw new ValidationException("Email format incorect!");
//        }
    }
}
