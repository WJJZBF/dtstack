package bean;

import com.dtstack.plat.excelplus.annotation.ExcelFiles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class Step {
   private String step_number;
   private String actions;
   private String expectedresults;

    @XmlElement(name = "step_number")
    public String getStep_number() {
        return step_number;
    }

    public void setStep_number(String step_number) {
        this.step_number = step_number;
    }

    @XmlElement(name = "actions")
    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    @XmlElement(name = "expectedresults")
    public String getExpectedresults() {
        return expectedresults;
    }

    public void setExpectedresults(String expectedresults) {
        this.expectedresults = expectedresults;
    }

}
