package bean;

import com.dtstack.plat.excelplus.annotation.ExcelCollection;
import com.dtstack.plat.excelplus.annotation.ExcelFiles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "testsuite")
public class Testsuit {
    private Integer id;
    private String name;
    private String nodeOrder;
    private String details;

    private List<Testcase> testcases;
    private List<Testsuit> testsuits;

    @XmlAttribute(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "node_order")
    public String getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(String nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    @XmlElement(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @XmlElement(name = "testcase")
    public List<Testcase> getTestcases() {
        return testcases;
    }

    public void setTestcases(List<Testcase> testcases) {
        this.testcases = testcases;
    }

    @XmlElement(name = "testsuite")
    public List<Testsuit> getTestsuits() {
        return testsuits;
    }

    public void setTestsuits(List<Testsuit> testsuits) {
        this.testsuits = testsuits;
    }
}
