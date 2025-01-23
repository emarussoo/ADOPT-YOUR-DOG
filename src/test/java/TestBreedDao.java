import exceptions.DogNotFoundException;
import exceptions.InvalidBreedTestInput;
import model.breed.dao.BreedDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class TestBreedDao {
        int flag = 0;

        void executeWithInvalidNumberOfAnswers(List<String> invalidAnswers){
            BreedDao breedDao = new BreedDao();
            try{
                breedDao.getBreedByAnswers(invalidAnswers);
            }catch(InvalidBreedTestInput e){
                flag = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void executeWithNotExistingCombinationOfAnswers(List<String> invalidAnswers){
            BreedDao breedDao = new BreedDao();
            try{
                breedDao.getBreedByAnswers(invalidAnswers);
            }catch(DogNotFoundException e){
                flag = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        void testGetBreedByAnswersInvalidNumberOfAnswers(){
            List<String> invalidAnswers = new ArrayList<>();
            //the number of expected answers is 6, so we are putting just 1 answer in input
            invalidAnswers.add("1");
            executeWithInvalidNumberOfAnswers(invalidAnswers);
            assertEquals(1, flag);
        }

        @Test
        void testGetBreedByAnswersNotExistingDogBreed(){
            List<String> invalidCombinationOfAnswers = new ArrayList<>();
            //a dog breed who fits those parameters does not exist
            invalidCombinationOfAnswers.add("1");
            invalidCombinationOfAnswers.add("1");
            invalidCombinationOfAnswers.add("1");
            invalidCombinationOfAnswers.add("1");
            invalidCombinationOfAnswers.add("1");
            invalidCombinationOfAnswers.add("1");
            executeWithNotExistingCombinationOfAnswers(invalidCombinationOfAnswers);
            assertEquals(1, flag);
        }
}