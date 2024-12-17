package bean;
import java.util.List;

public class TestBean {
    private List<String> userAnswers;

    public TestBean(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
