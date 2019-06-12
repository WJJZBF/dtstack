import bean.Testcase;
import bean.Testsuit;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetXmlDatas {
//    public static void main(String[] args) throws Exception {
//        SAXReader reader = new SAXReader();
//        File xmlFile = new File("/Users/wujiaojiao/XmlAndExcelToConvert/src/main/resources/TestLink.xml");
//        Document document = reader.read(xmlFile);
//        Element root = document.getRootElement();
//        Testsuit suit = new Testsuit();
//        item2(root, suit);
//        System.out.println(JSONObject.toJSON(suit));
//    }
//
//    public static void item(Element element, Testsuit t) {
//        if (element == null) {
//            return;
//        }
//        Attribute attr = element.attribute("name");
//        if (element.getName().equals("testsuite")) {
//            List<Testsuit> testsuits = t.getTestsuits();
//            if (testsuits == null) {
//                testsuits = new ArrayList();
//            }
//            List<Element> eleList = element.elements();
//            for (Element ele : eleList) {
//                Testsuit testsuit = new Testsuit();
//                testsuit.setName(attr.getValue());
//                testsuits.add(testsuit);
//                item(ele, testsuit);
//            }
//            t.setTestsuits(testsuits);
//        } else if (element.getName().equals("testcase")) {
//            Testcase testcase = new Testcase();
//            testcase.setName(attr.getValue());
//            List<Testcase> testcases = t.getTestcases();
//            if (testcases == null) {
//                testcases = new ArrayList<Testcase>();
//            }
//            testcases.add(testcase);
//            t.setTestcases(testcases);
//        }
//    }
//
//    public static void item2(Element element, Testsuit testsuit) {
//        if (element == null) {
//            return;
//        }
//        Attribute attr = element.attribute("name");
//        if (attr != null) {
//            testsuit.setName(attr.getValue());
//        }
//        List<Element> eleList = element.elements();
//
//        List<Testsuit> testsuits = null;
//        List<Testcase> testcases = null;
//        for (Element ele : eleList) {
//            if (ele.getName().equals("testsuite")) {
//                testsuits = testsuit.getTestsuits();
//                if (testsuits == null) {
//                    testsuits = new ArrayList();
//                }
//                Testsuit child = new Testsuit();
//                testsuits.add(child);
//                item2(ele, child);
//            } else if (ele.getName().equals("testcase")) {
//                Testcase testcase = new Testcase();
//                Attribute attribute = ele.attribute("name");
//                if (attribute != null) {
//                    testcase.setName(attribute.getValue());
//                }
//                testcases = testsuit.getTestcases();
//                if (testcases == null) {
//                    testcases = new ArrayList<Testcase>();
//                }
//                testcases.add(testcase);
//            }
//        }
//        testsuit.setTestsuits(testsuits);
//        testsuit.setTestcases(testcases);
//    }
}
