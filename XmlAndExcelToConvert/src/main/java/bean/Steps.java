package bean;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Steps {
    private List<Step> step;

    @XmlElement(name = "step")
    public List<Step> getStep() {
        return step;
    }

    public void setStep(List<Step> step) {
        this.step = step;
    }
}
