package management;

import java.util.HashMap;

public class TestCase {
    String title;
    String description;
    String status;
    String currentResult;
    String expectedResult;
    Owner owner;
    Priority priority;
    HashMap steps;

    public TestCase(String title, String description, String status, String currentResult, String expectedResult, Owner owner, Priority priority,HashMap steps) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.currentResult = currentResult;
        this.expectedResult = expectedResult;
        this.owner = owner;
        this.priority = priority;
        this.steps = steps;
    }

    public void addSteps(Integer step, String description) {
        this.steps.put(step,description);
    }

    public HashMap<Integer, String> getSteps() {
        return steps;
    }

    public void setSteps(HashMap steps) {
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(String currentResult) {
        this.currentResult = currentResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Title: "+this.title+"\n"+
                "Description: "+this.description+"\n"+
                "Priority: "+this.priority+"\n"+
                "Owner: "+this.owner.getFullName();
    }
}