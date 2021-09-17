package amazing;

public class AmazingUnitTest {

    private static boolean success = true;

    public static void main(String[] args) {
        runTest(AmazingUnitTest::failingAssertShouldFail);
        runTest(AmazingUnitTest::successAssertShouldSucceed);
        runTest(AmazingUnitTest::failingAssertThenSuccessfulShouldFail);
    }

    private static void runTest(Runnable body) {
        beforeTest();
        
        body.run();
        
        reportTestState();
    }

    private static void failingAssertThenSuccessfulShouldFail() {
        assertTrue(false);
        assertTrue(true);
        // assert: will sehen Red
        success = !success;
    }

    private static void successAssertShouldSucceed() {
        assertTrue(true);
    }

    private static void failingAssertShouldFail() {
        assertTrue(false);
        // assert: will sehen Red
        success = !success;
    }

    private static void reportTestState() {
        if (success) {
            System.out.println("Green");
        } else {
            System.out.println("Red");
        }
    }

    private static void beforeTest() {
        success = true;
    }
    
    private static void assertTrue(boolean b) {
        success = success && b;
    }
}

/*
 * Test List
 * - assertTrue
 * - assertEqual
 * - define test, find test, run test
 * - fixtures (before, after)
 */
