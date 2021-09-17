package amazing;

import java.util.function.Consumer;

class AmazingTestRunner {

    static boolean success = true;

    public void runTest(Consumer<AmazingTestRunner> body) {
        beforeTest();

        body.accept(this);

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

    public void assertTrue(boolean b) {
        success = success && b;
    }

}

public class AmazingUnitTest {

    private static void failingAssertShouldFail(AmazingTestRunner a) {
        a.assertTrue(false);

        // assert: will Red
        AmazingTestRunner.success = !AmazingTestRunner.success;
    }

    private static void successAssertShouldSucceed(AmazingTestRunner a) {
        a.assertTrue(true);
    }

    private static void failingAssertThenSuccessfulShouldFail(AmazingTestRunner a) {
        a.assertTrue(false);
        a.assertTrue(true);

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
 * - statistics
 * - fixtures (before, after)
 */
