package bean;

import com.dtstack.plat.excelplus.annotation.ExcelFiles;

public class Excel {

    @ExcelFiles(name = "测试案例模块", width = 35)
    private String testCasePath;
    @ExcelFiles(name = "测试案例名称",width = 80)
    private String testCaseName;
    @ExcelFiles(name = "前提",width = 10)
    private String preConditions;
    @ExcelFiles(name = "操作步骤",height =50,width=100)
    private String stepActions;
    @ExcelFiles(name = "预期效果",width = 100)
    private String stepResult;
    @ExcelFiles(name = "优先级")
    private String levelImportance;
    @ExcelFiles(name = "执行状态")
    private String down;
    @ExcelFiles(name = "摘要",width=10)
    private String testCaseSummary;

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getStepActions() {
        return stepActions;
    }

    public void setStepActions(String stepActions) {
        this.stepActions = stepActions;
    }

    public String getStepResult() {
        return stepResult;
    }

    public void setStepResult(String stepResult) {
        this.stepResult = stepResult;
    }

    public String getTestCasePath() {
        return testCasePath;
    }

    public void setTestCasePath(String testCasePath) {
        this.testCasePath = testCasePath;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestCaseSummary() {
        return testCaseSummary;
    }

    public void setTestCaseSummary(String testCaseSummary) {
        this.testCaseSummary = testCaseSummary;
    }

    public String getLevelImportance() {
        return levelImportance;
    }

    public void setLevelImportance(String levelImportance) {
        this.levelImportance = levelImportance;
    }

    public String getPreConditions() {
        return preConditions;
    }

    public void setPreConditions(String preConditions) {
        this.preConditions = preConditions;
    }
}
