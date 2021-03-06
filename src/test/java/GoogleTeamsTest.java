/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Tests GoogleTeams.java
 * Due Date: ¯\_(ツ)_/¯
 *
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTeamsTest
{

    PagerankTeams googleTeams;
    

    @Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
            System.out.println("Starting test: " + description.getMethodName());
            googleTeams.reset();
    	}
    };
    
    @Before
    public void initialize() {
		googleTeams = new PagerankTeams();
    }


    @Test
    public void test1ReadFile()
    {
        boolean worked = googleTeams.readFile("Test.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }




    @Test
    public void testCreateAdjacencyMatrix()
    {
        /*
        String Matrix
        A B C D
        B A
        C D B
        D B C A

        Int Matrix
        0, 1, 1, 1
        1, 0, 0, 0
        0, 1, 0, 1
        1, 1, 1, 0
        */
        ArrayList<String> newAllNames = new ArrayList<String>();
        ArrayList<ArrayList<String>> outerMatrix = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner = new ArrayList<String>();      

        inner.add("A");     
        inner.add("B");
        inner.add("C");
        inner.add("D");
        outerMatrix.add(inner); // add first list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("B");     
        inner.add("A");                                   
        outerMatrix.add(inner); // add second list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("C");     
        inner.add("D");
        inner.add("B");                                 
        outerMatrix.add(inner); // add third list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("D");     
        inner.add("B");
        inner.add("C"); 
        inner.add("A");                                  
        outerMatrix.add(inner); // add fourth list

        newAllNames.add("A");
        newAllNames.add("B");
        newAllNames.add("C");
        newAllNames.add("D");

        googleTeams.setAllNames(newAllNames);
        googleTeams.createAdjacencyMatrix();
        ArrayList<ArrayList<Integer>> matrixReturn = googleTeams.getIntMatrix(); // returns integer matrix
        System.out.println("Output Testmatrix");
        googleTeams.outputAdjacencyMatrix(matrixReturn); // test
        System.out.println("End test: testCreateAdjacencyMatrix");
    }



    @Test
    public void testOutputAdjacencyMatrix()
    {
        ArrayList<ArrayList<Integer>> outerMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner = new ArrayList<Integer>();        

        inner.add(0);     
        inner.add(1);
        inner.add(1);
        inner.add(1);
        outerMatrix.add(inner); // add first list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(1);     
        inner.add(0);
        inner.add(0);
        inner.add(0);                                  
        outerMatrix.add(inner); // add second list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(0);     
        inner.add(1);
        inner.add(0);
        inner.add(1);                           
        outerMatrix.add(inner); // add third list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(1);     
        inner.add(1);
        inner.add(1);
        inner.add(0);                           
        outerMatrix.add(inner); // add fourth list
        
        googleTeams.outputAdjacencyMatrix(outerMatrix);
        System.out.println("End test: TestOutputMatrix");
    }



    @Test
    public void test1point5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase1_Nar.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test2ReadFile()
    {
        googleTeams.reset();
    	boolean worked = googleTeams.readFile("testCases/testcase2_CAH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");

        System.out.println("Output String Matrix");
        ArrayList<ArrayList<String>> STRINGMATRIX = googleTeams.getStringMatrix();
        googleTeams.outputStringMatrix(STRINGMATRIX);

        System.out.println("Create Adjacency Matrix:");
        googleTeams.createAdjacencyMatrix();

        System.out.println("Output Adjacency Matrix");
        googleTeams.outputAdjacencyMatrix(googleTeams.intMatrix);
        System.out.println("FINISH TEST 2 READFILE\n");
    }

    @Test
    public void test3ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase3_DP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test4ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase4_Bio.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase5_HP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test6ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase6_Blank.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test7ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase7_GG_Num.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test8ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase8_FMA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test9ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase9_MCU.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test10ReadFile()
    {
        boolean worked = googleTeams.readFile("testCases/testcase10_MASH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test11ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase11_UT.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test12ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase12_OHSHC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test13ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase13_MHA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test14ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase14_SW.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test15ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase15_CH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test16ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase16_AC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }


    // Should be true somethingis wrong
    @Test
    public void test17ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase17_PMK.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test18ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase18_SM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test19ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase19_BM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test20ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase20_ATLA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test21ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase21_Port.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test22ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase22_GF.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test23ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase23_OPM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test24ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase24_LOTR.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test25ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase25_BATIM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test26ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase26_MNT.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test27ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase27_LCITS.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test28ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase28_SA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test29ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase29_HMC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test30ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase30_PM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test31ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase31_KDS.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test32ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase32_PN.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test33ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase33_DW.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test34ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase34_SN.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test35ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase35_Friend.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test36ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase36_ADF.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test37ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase37_PAR.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test38ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase38_ST.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test39ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase39_ST.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test40ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase40_MP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test40pt5ReadFile()
    {
        googleTeams.reset();
        ArrayList<String> newAllNames = new ArrayList<String>();
        ArrayList<ArrayList<String>> outerMatrix = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner = new ArrayList<String>();      

        inner.add("A");     
        inner.add("B");
        inner.add("C");
        inner.add("D");
        outerMatrix.add(inner); // add first list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("B");     
        inner.add("A");                                   
        outerMatrix.add(inner); // add second list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("C");     
        inner.add("D");
        inner.add("B");                                 
        outerMatrix.add(inner); // add third list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("D");     
        inner.add("B");
        inner.add("C"); 
        inner.add("A");                                  
        outerMatrix.add(inner); // add fourth list

        newAllNames.add("A");
        newAllNames.add("B");
        newAllNames.add("C");
        newAllNames.add("D");

        googleTeams.setAllNames(newAllNames);
        googleTeams.createAdjacencyMatrix();
        //googleTeams.pageRank();
    }

    @Test
    public void test41ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase41_JL.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test42ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase42_AOT.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test43ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase43_HAP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test44ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase44_BJ.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test45ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase45_PAF.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test46ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase46_Simp.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test47ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase47_SBSP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test48ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase48_SWL.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test49ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase49_TCR.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test50ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase50_ITSV.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test51ReadFile()
    {
        // ArrayList<String> newAllNames = new ArrayList<String>();
        // ArrayList<ArrayList<Integer>> correctMatrix = new ArrayList<ArrayList<Integer>>();
        // ArrayList<ArrayList<String>> outerMatrix = new ArrayList<ArrayList<String>>();
        // ArrayList<String> inner = new ArrayList<String>();      

        // inner.add("A");     
        // inner.add("B");
        // inner.add("C");
        // inner.add("D");
        // outerMatrix.add(inner); // add first list
        // inner = new ArrayList<String>(); // create a new inner list

        // inner.add("B");     
        // inner.add("A");                                   
        // outerMatrix.add(inner); // add second list
        // inner = new ArrayList<String>(); // create a new inner list

        // inner.add("C");     
        // inner.add("D");
        // inner.add("B");                                 
        // outerMatrix.add(inner); // add third list
        // inner = new ArrayList<String>(); // create a new inner list

        // inner.add("D");     
        // inner.add("B");
        // inner.add("C"); 
        // inner.add("A");                                  
        // outerMatrix.add(inner); // add fourth list

        // newAllNames.add("A");
        // newAllNames.add("B");
        // newAllNames.add("C");
        // newAllNames.add("D");

        // googleTeams.setAllNames(newAllNames);
        // googleTeams.createAdjacencyMatrix(outerMatrix);
        googleTeams.pageRank();
        googleTeams.teamMaker();
    }

}