package view.user.testview;

import bean.BreedBean;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CLITestViewController extends TestViewController{
    @Override
    public void createTest(){};

    public List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        return null;
    }

    public void createTestResult(BreedBean breedBean){};
}
