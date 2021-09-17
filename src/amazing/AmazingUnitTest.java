package amazing;

import java.util.function.Consumer;

class AmazingTestRunner implements Asserts {

    private boolean success;

    public void runTest(Consumer<Asserts> body) {
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

    void expectTestFailed() {
        success = !success;
    }

    @Override
    public void assertTrue(boolean b) {
        success = success && b;
    }

}

public class AmazingUnitTest {

    private static void failingAssertShouldFail(Asserts a) {
        a.assertTrue(false);

        // assert: will Red
        expectTestFailed(a);
    }

    private static void successAssertShouldSucceed(Asserts a) {
        a.assertTrue(true);
    }

    private static void failingAssertThenSuccessfulShouldFail(Asserts a) {
        a.assertTrue(false);
        a.assertTrue(true);

        // assert: will Red
        expectTestFailed(a);
    }

    private static void expectTestFailed(Asserts a) {
        ((AmazingTestRunner) a).expectTestFailed();
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
