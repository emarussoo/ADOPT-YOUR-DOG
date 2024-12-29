package view.kennel.addadogview;
import exceptions.EmptyFieldsException;
import exceptions.InvalidFieldException;
import utils.GraphicalController;

import java.util.List;

public abstract class AddDogPageController implements GraphicalController {
    public abstract void createAddForm();
    public abstract List<String> getDogInfo() throws EmptyFieldsException;
    public abstract void createMessage(String message);
    public void validateDogAge(String age) throws InvalidFieldException{
        try{
            Integer.parseInt(age);
        }catch(NumberFormatException e){
            throw new InvalidFieldException("Make sure that dog age is valid");
        }
    }
}
