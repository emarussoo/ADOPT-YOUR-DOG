package view.user.testview;

import bean.BreedBean;
import utils.GraphicalController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class TestPageController implements GraphicalController {
    public abstract void createTest();
    public abstract List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException;
    public abstract void createTestResult(BreedBean breedBean);
}
