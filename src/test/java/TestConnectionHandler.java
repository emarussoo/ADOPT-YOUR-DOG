import exceptions.GenericSystemException;
import org.junit.jupiter.api.Test;
import utils.ConnectionHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestConnectionHandler {
    int flag = 0;

    @Test
    void testGetConnection() {
        try{
            ConnectionHandler.getInstance().getConnection();
        }catch(GenericSystemException e){
            flag = 1;
        }

        assertEquals(0, flag);
    }
}
