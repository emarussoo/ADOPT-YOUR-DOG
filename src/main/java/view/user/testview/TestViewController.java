package view.user.testview;

import bean.BreedBean;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class TestViewController {
    public abstract void createTest();
    public abstract void submitTest() throws URISyntaxException, IOException, InterruptedException;
    public abstract List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException;
    public abstract void createTestResult(BreedBean breedBean);
}
