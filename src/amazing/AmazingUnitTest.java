package amazing;

import static amazing.AmazingTestRunner.*;

class AmazingTestRunner {

    static boolean success = true;

    public void runTest(Runnable body) {
        beforeTest();

        body.run();

        reportTestState();
    }

    private void beforeTest() {
        success = true;
    }

    private void reportTestState() {
        if (success) {
            System.out.println("Green");
        } else {
            System.out.println("Red");
        }
    }

    public static void assertTrue(boolean b) {
        success = success && b;
    }

}

public class AmazingUnitTest {

    private static void failingAssertShouldFail() {
        assertTrue(false);
        
        // assert: will Red
        AmazingTestRunner.success = !AmazingTestRunner.success;
    }

    private static void successAssertShouldSucceed() {
        assertTrue(true);
    }

    private static void failingAssertThenSuccessfulShouldFail() {
        assertTrue(false);
        assertTrue(true);
        
        // assert: will Red
        AmazingTestRunner.success = !AmazingTestRunner.success;
    }

    public static void main(String[] args) {
        AmazingTestRunner runner = new AmazingTestRunner();
        runner.runTest(AmazingUnitTest::failingAssertShouldFail);
        runner.runTest(AmazingUnitTest::successAssertShouldSucceed);
        runner.runTest(AmazingUnitTest::failingAssertThenSuccessfulShouldFail);
    }

}

/*
 * Test List
 * - assertTrue (DONE)
 * - assertEqual
 * - define test (DONE) 
 *   find test
 *   run test (DONE)
 * - fixtures (before, after)
 */
