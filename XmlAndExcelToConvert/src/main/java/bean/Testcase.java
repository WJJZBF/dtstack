package bean;

import com.dtstack.plat.excelplus.annotation.ExcelCollection;
import com.dtstack.plat.excelplus.annotation.ExcelFiles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Testcase {
    private String name;
    private String nodeOrder;
    private String summary;
    private String importance;
    private String preconditions;
    private Steps steps;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlElement(name = "node_order")
    public String getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(String nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    @XmlElement(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @XmlElement(name = "importance")
    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    @XmlElement(name = "preconditions")
    public String getPreconditions() {
        return preconditions;
    }

    @XmlElement(name = "steps")
    public Steps getSteps() {
        return steps;
    }

    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
