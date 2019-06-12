package util;

import bean.*;
import com.dtstack.plat.excelplus.ExcelExport;
import com.dtstack.plat.excelplus.impl.ExcelImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.poi.ss.usermodel.Workbook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moyuan
 * @since 2019/1/11
 */
public class XmlToExcel {

    /**
     * xml文件配置转换为对象
     *
     * @param
     * @param load java对象.Class
     * @return java对象
     * @throws JAXBException
     * @throws IOException
     */
    public static Object xmlToBean(InputStream inputStream, Class<?> load) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(inputStream);
        return object;
    }

    public static void main(String[] args) throws IOException, JAXBException {
        String xmlPath = "/Users/wujiaojiao/Downloads/XmlAndExcelToConvert/src/main/resources/TestLink.xml";

        //读取文本，并将里面的\t\n<p></p>过滤,将文本中的特殊字符进行处理，比如：引号，大于号等
        String content = FileUtils.readFileToString(new File(xmlPath), Charset.forName("utf-8"));
        content = content.replace("\t", "");
        content = content.replace("\n", "");
        content = content.replace("<p>", "");
        content = content.replace("</p>", "");
        content = StringEscapeUtils.unescapeHtml4(content);

        ByteArrayInputStream streams = new ByteArrayInputStream(content.getBytes());

        Testsuit testsuit = (Testsuit) XmlToExcel.xmlToBean(streams, Testsuit.class);

        List<Testsuit> suits = testsuit.getTestsuits();
        List<Excel> excels = new ArrayList<>();

        for (Testsuit suit : suits) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(suit.getName());
            iteration(suit, excels, stringBuffer);
        }

        File file = new File("/Users/wujiaojiao/t/C端—测试用例.xlsx");
        ExcelExport excelExport = new ExcelImpl();
        Workbook workbook = excelExport.exportExcel(testsuit.getName(), "测试用例", Excel.class, excels);
        try {
            ByteArrayOutputStream o = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            o.flush();
            o.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void iteration(Testsuit suit, List<Excel> list, StringBuffer s) {
        if (suit == null) {
            return;
        }
        List<Testsuit> suits = suit.getTestsuits();
        List<Testcase> cases = suit.getTestcases();
        //当前为最后文件夹下有测试用例
        if (cases!=null) {
            for (Testcase testcase : cases) {
                Excel excel = new Excel();
                excel.setTestCasePath(s.toString());
                excel.setTestCaseName(testcase.getName());
                excel.setDown("pass");

                //插入优先级
                if (testcase.getImportance().equals("3")) {
                    excel.setLevelImportance("高");
                } else if (testcase.getImportance().equals("2")) {
                    excel.setLevelImportance("中");
                } else {
                    excel.setLevelImportance("低");
                }

                //插入前提
                if (testcase.getPreconditions().equals("")) {
                    excel.setPreConditions("无");
                } else {
                    excel.setPreConditions(testcase.getPreconditions());
                }
                //插入摘要
                if (testcase.getSummary().equals("")) {
                    excel.setTestCaseSummary("无");
                } else {
                    excel.setTestCaseSummary(testcase.getSummary());
                }

                Steps steps = testcase.getSteps();
                StringBuffer sb0 = new StringBuffer();
                StringBuffer sb1 = new StringBuffer();

                if (steps != null) {
                    //循环遍历操作步骤列表，将操作步骤列表中的所有操作合在一起
                    for (Step step : steps.getStep()) {
                        if (step.getActions() != null) {
                            sb0.append(step.getStep_number() + ":" + step.getActions()).append("\r\n");
                        } else {
                            sb0.append("无");
                        }
                    }
                    //插入操作步骤
                    excel.setStepActions(sb0.toString());
                    //遍历操作步骤列表，将预期结果与步骤编号合并成一个字段值
                    for (Step step : steps.getStep()) {
                        if (step.getExpectedresults() != null) {
                            sb1.append(step.getStep_number() + ":" + step.getExpectedresults()).append("\r\n");
                        } else {
                            sb1.append("无");
                        }
                    }
                    //插入预期效果
                    excel.setStepResult(sb1.toString());
                } else {
                    excel.setStepActions("无");
                    excel.setStepResult("无");
                }
                list.add(excel);
            }
        }
        //当前文件夹下有文件夹，也有测试用例
        if (suits != null) {
            for (Testsuit element : suits) {
                StringBuffer str = new StringBuffer();
                str.append(s);
                str.append("-"+element.getName() );
                iteration(element, list, str);
            }
        }
    }

//    private static void fillNamePath(String parentPath, Testsuit testsuit) {
//
//        if (testsuit != null) {
//            if (testsuit.getTestsuits() != null) {
//                for (Testsuit testsuit1 : testsuit.getTestsuits()) {
//                    String path = "";
//                    if (StringUtils.isBlank(parentPath)) {
//                        path = testsuit1.getName();
//                    } else {
//                        path = parentPath + "-" + testsuit1.getName();
//                    }
//                    fillNamePath(path, testsuit1);
//                }
//
//            }
//            if (testsuit.getTestcases() != null) {
//                for (Testcase testcase : testsuit.getTestcases()) {
//                    testcase.setPath(parentPath);
//                }
//            }
//        }
//    }
}