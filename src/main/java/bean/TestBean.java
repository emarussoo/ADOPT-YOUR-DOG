package bean;
import java.util.List;

public class TestBean {
    private List<Integer> userAnswers;

    public TestBean(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<Integer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
