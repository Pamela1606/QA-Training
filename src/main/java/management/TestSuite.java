package management;

import java.util.ArrayList;

public class TestSuite {
    String name;
    String description;
    ArrayList<TestCase> testCases;

    public TestSuite(String name, String description, ArrayList<TestCase> testCases) {
        this.name = name;
        this.description = description;
        this.testCases = testCases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(ArrayList<TestCase> testCases) {
        this.testCases = testCases;
    }
}
