package bugiraportti.domain;

import java.util.*;

/**
 * Bug-olion luokka, mistä löytyy konstruktorit, getterit ja setterit.
 */
public class Bug {

    private int id;
    private String title;
    private String summary;
    private int priority;
    private String steps;
    private String expectedResult;
    private String actualResult;
    private boolean solved;

    public Bug(int id, String title, String summary, int priority, String steps, String expectedResult,
            String actualResult, boolean solved) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.priority = priority;
        this.steps = steps;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.solved = solved;
    }

    public Bug(String title, String summary, int priority, String steps, String expectedResult, String actualResult,
            boolean solved) {
        this.title = title;
        this.summary = summary;
        this.priority = priority;
        this.steps = steps;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.solved = solved;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getSteps() {
        return this.steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getExpectedResult() {
        return this.expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getActualResult() {
        return this.actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public boolean getSolved() {
        return this.solved;
    }

    public void setBoolean(boolean solved) {
        this.solved = solved;
    }
}
