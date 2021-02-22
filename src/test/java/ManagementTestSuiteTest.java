import management.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagementTestSuiteTest {
    ArrayList<Owner> owners;
    ArrayList<TestCase> testCases;
    ArrayList<TestSuite> suites;

    public void populateOwner(){
        owners = new ArrayList<Owner>();
        owners.add(new Owner("Carlos", "Claros", Role.QA));
        owners.add(new Owner("Pamela", "Norris", Role.LEAD));
        owners.add(new Owner("Mario", "Covarrubias", Role.MANAGER));
        owners.add(new Owner("Dani", "Vidal", Role.QA));
        owners.add(new Owner("Pablo", "Ricaldi", Role.LEAD));
    }

    public void populateTestCase() {
        testCases = new ArrayList<TestCase>();
        testCases.add(new TestCase("TestCase1","Primero","QA In progress","None","Passed",owners.get(0), Priority.LOW,getSteps(1)));
        testCases.add(new TestCase("TestCase2","Segundo","QA In progress","None","Passed",owners.get(0), Priority.MEDIUM,getSteps(2)));
        testCases.add(new TestCase("TestCase3","Tercero","QA In progresss","None","Passed",owners.get(3), Priority.CRITICAL,getSteps(3)));
        testCases.add(new TestCase("TestCase4","Cuarto","QA In progress","None","Passed",owners.get(4), Priority.BLOCKER,getSteps(4)));
        testCases.add(new TestCase("TestCase5","Quinto","QA In progress","None","Passed",owners.get(3), Priority.HIGH,getSteps(5)));
        testCases.add(new TestCase("TestCase6","Sexto","QA In progress","None","Passed",owners.get(4), Priority.MEDIUM,getSteps(6)));
        testCases.add(new TestCase("TestCase7","Septimo","QA In progress","None","Passed",owners.get(1), Priority.BLOCKER,getSteps(7)));
        testCases.add(new TestCase("TestCase8","Octavo","QA In progress","None","Passed",owners.get(1), Priority.MEDIUM,getSteps(8)));
        testCases.add(new TestCase("TestCase9","Noveno","QA In progress","None","Passed",owners.get(2), Priority.CRITICAL,getSteps(9)));
        testCases.add(new TestCase("TestCase10","Decimo","QA In progress","None","Passed",owners.get(1), Priority.LOW,getSteps(10)));
    }

    public ArrayList<TestCase>getTestCases(int id){
        ArrayList<TestCase> currentTesCases = new ArrayList<TestCase>();
        for (int i = 0; i <testCases.size() ; i++) {
            if(i%id==0){
                currentTesCases.add(testCases.get(i));
            }
        }
        return  currentTesCases;
    }

    public void populateTestSuits() {
        suites = new ArrayList<TestSuite>();
        suites.add(new TestSuite("TestSuit1", "Description Testsuit1",getTestCases(1)));
        suites.add(new TestSuite("TestSuit2", "Description Testsuit2",getTestCases(2)));
    }

    public HashMap<Integer,String> getSteps(int type){
        HashMap<Integer, String> steps = new HashMap<Integer, String>();



        switch (type){
            case 1:
                steps.put(1,"Ir login");
                steps.put(2,"Set Usename");
                steps.put(3,"Set password");
                steps.put(4,"Go to Dasboard");
                steps.put(5,"Create Finder");
                steps.put(6,"Close");
                break;
            case 2:
                steps.put(1,"Search");
                steps.put(2,"Select item");
                steps.put(3,"Save");
                steps.put(4,"Return");
                steps.put(5,"Close");
                break;
            case 3:
                steps.put(1,"Cancel");
                steps.put(2,"Select other");
                steps.put(3,"Verify");
                steps.put(4,"Save");

                break;

            default:
                steps.put(1,"Request");
                steps.put(2,"reset");
                steps.put(3,"validate");
                break;



        }
        return steps;
    }




    @Before
    public  void init() {
        populateOwner();
        populateTestCase();
        populateTestSuits();
    }

    @Test
    public void filterByOwner(){
        System.out.println("Filter By Owner");
        for(int i=0;i<=suites.size() ;i++){
            for (TestCase p: suites.get(i).getTestCases()) {
                Assert.assertEquals("Carlos",p.getOwner().getName());
                System.out.println("Ownersss");
                this.recorrerStep(p);
            }
            continue;
        }
    }

    @Test
    public void filterByPriority(){
        //
        int count =0;
        System.out.println("Filter By Priority");
        while (count < suites.size()){

            for (TestCase p: suites.get(count).getTestCases()) {
                Assert.assertEquals(p.getPriority(),Priority.LOW);
                System.out.println(p.toString());
            }
            count ++;
        }
    }


    private void recorrerSuites(ArrayList<TestSuite> suites) {
        for (TestSuite p: suites) {
            this.recorrerTestCase(p.getTestCases());
        }
    }

    private void recorrerTestCase(ArrayList<TestCase> testCases) {
        for (TestCase p: testCases) {
            this.recorrerStep(p);
        }
    }

    private void recorrerStep(TestCase testCase) {
        for (Map.Entry<Integer, String> entry: testCase.getSteps().entrySet()){
            System.out.println("Key : "+ entry.getKey() + "value : " + entry.getValue());
        }
    }

    public Boolean isOwner(String name) {
        Boolean result = false;
        for (TestCase p: testCases) {
            if(p.getOwner().getName().equals(name)){
                return true;
            }
        }
        return  result;
    }



}
