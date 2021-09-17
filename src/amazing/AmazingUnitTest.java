package amazing;

import static amazing.AmazingUnit.*;

class AmazingUnit {

    static boolean success = true;

    public static void runTest(Runnable body) {
        beforeTest();

        body.run();

        reportTestState();
    }

    private static void beforeTest() {
        success = true;
    }

    private static void reportTestState() {
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
        AmazingUnit.success = !AmazingUnit.success;
    }

    private static void successAssertShouldSucceed() {
        assertTrue(true);
    }

    private static void failingAssertThenSuccessfulShouldFail() {
        assertTrue(false);
        assertTrue(true);
        
        // assert: will Red
        AmazingUnit.success = !AmazingUnit.success;
    }

    public static void main(String[] args) {
        runTest(AmazingUnitTest::failingAssertShouldFail);
        runTest(AmazingUnitTest::successAssertShouldSucceed);
        runTest(AmazingUnitTest::failingAssertThenSuccessfulShouldFail);
    }

}

/*
 * Test List
 * - assertTrue
 * - assertEqual
 * - define test, find test, run test
 * - fixtures (before, after)
 */
