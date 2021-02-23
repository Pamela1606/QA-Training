package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagementTestSuite {
    static ArrayList<Owner> owners;
    static ArrayList<TestCase> testCases;
    static ArrayList<TestSuite> suites;

    public static void populateOwner(){
        owners = new ArrayList<Owner>();
        owners.add(new Owner("Carlos", "Claros", Role.QA));
        owners.add(new Owner("Pamela", " Cardozo", Role.LEAD));
        owners.add(new Owner("Mario", "Covarrubias", Role.MANAGER));
        owners.add(new Owner("Dani", "Vidal", Role.QA));
        owners.add(new Owner("Pablo", "Ricaldi", Role.LEAD));
    }

    public static void populateTestCase() {
        testCases = new ArrayList<TestCase>();
        testCases.add(new TestCase("TestCase1","Primero","QA In progress","None","Passed",owners.get(0), Priority.LOW,getSteps(1)));
        testCases.add(new TestCase("TestCase2","Segundo","QA In progress","None","Passed",owners.get(2), Priority.MEDIUM,getSteps(2)));
        testCases.add(new TestCase("TestCase3","Tercero","QA In progresss","None","Passed",owners.get(1), Priority.CRITICAL,getSteps(3)));
        testCases.add(new TestCase("TestCase4","Cuarto","QA In progress","None","Passed",owners.get(2), Priority.BLOCKER,getSteps(4)));
        testCases.add(new TestCase("TestCase5","Quinto","QA In progress","None","Passed",owners.get(0), Priority.HIGH,getSteps(5)));
        testCases.add(new TestCase("TestCase6","Sexto","QA In progress","None","Passed",owners.get(4), Priority.MEDIUM,getSteps(6)));
        testCases.add(new TestCase("TestCase7","Septimo","QA In progress","None","Passed",owners.get(1), Priority.BLOCKER,getSteps(7)));
        testCases.add(new TestCase("TestCase8","Octavo","QA In progress","None","Passed",owners.get(1), Priority.MEDIUM,getSteps(8)));
        testCases.add(new TestCase("TestCase9","Noveno","QA In progress","None","Passed",owners.get(2), Priority.CRITICAL,getSteps(9)));
        testCases.add(new TestCase("TestCase10","Decimo","QA In progress","None","Passed",owners.get(1), Priority.LOW,getSteps(10)));
    }

    public static  ArrayList<TestCase>getTestCases(int id){
        ArrayList<TestCase> currentTesCases = new ArrayList<TestCase>();
        if(id ==0) {
            for (int i = 0; i <testCases.size()/2 ; i++) {
                    currentTesCases.add(testCases.get(i));
            }
        }else {
            for (int i = 5; i <testCases.size() ; i++) {
                    currentTesCases.add(testCases.get(i));
            }
        }

        return  currentTesCases;
    }

    public static  void populateTestSuits() {
        suites = new ArrayList<TestSuite>();
        suites.add(new TestSuite("TestSuit1", "Description Testsuit1",getTestCases(0)));
        suites.add(new TestSuite("TestSuit2", "Description Testsuit2",getTestCases(1)));
    }

    public static HashMap<Integer,String> getSteps(int type){
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
            case 4:
                steps.put(1,"Cancel1");
                steps.put(2,"Select other2");
                steps.put(3,"Verify1");
                break;
            case 5:
                steps.put(1,"Cancel11");
                steps.put(2,"Select other22");
                steps.put(3,"Verify12");
            case 7:
                steps.put(1,"Cancel12");
                steps.put(2,"Select other22");
                steps.put(3,"Verify123");
                steps.put(4,"Verify121");
                steps.put(5,"Verify121");


                break;

            default:
                steps.put(1,"Request");
                steps.put(2,"reset");
                steps.put(3,"validate");
                break;



        }
        return steps;
    }

     public static void initData() {
        populateOwner();
        populateTestCase();
        populateTestSuits();

     }


    public static  void filterByOwner(String name){
        System.out.println("Filter By Owner");
        for(int i=0;i<suites.size() ;i++){
            for (TestCase p: suites.get(i).getTestCases()) {
                if(p.getOwner().getName().equals(name)) {
                    System.out.println("======================================");
                    System.out.println("Owner: "+p.getOwner().getFullName());
                    System.out.println("TesCase: "+p.title);
                    System.out.println("DescriptionTest: "+p.description);
                    System.out.println("======================================");
                    recorrerStep(p);
                    System.out.println("\n");
                }

            }
        }
    }


    public static void filterByPriority(Priority priority){
        //
        int count =0;
        System.out.println("Filter By Priority");
        while (count < suites.size()){

            for (TestCase p: suites.get(count).getTestCases()) {
                if(p.getPriority().equals(priority)){
                    System.out.println(p.toString());
                    System.out.println("\n");
                }
            }
            count ++;
        }
    }


    private static void recorrerSuites(ArrayList<TestSuite> suites) {
        for (TestSuite p: suites) {
            recorrerTestCase(p.getTestCases());
        }
    }

    private static  void recorrerTestCase(ArrayList<TestCase> testCases) {
        for (TestCase p: testCases) {
            recorrerStep(p);
        }
    }

    private static  void recorrerStep(TestCase testCase) {
        for (Map.Entry<Integer, String> entry: testCase.getSteps().entrySet()){
            System.out.println("Step"+ entry.getKey()+": "  + entry.getValue());
        }
    }

    public static  Boolean isOwner(String name) {
        Boolean result = false;
        for (TestCase p: testCases) {
            if(p.getOwner().getName().equals(name)){
                return true;
            }
        }
        return  result;
    }

    public static void main(String arg[]) {
        initData();
        System.out.println("Management Tetsuite::");
        filterByOwner("Carlos");
        filterByPriority(Priority.LOW);
        System.out.println("fin Management Tetsuite ::");
    }
}
