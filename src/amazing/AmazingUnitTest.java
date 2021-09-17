package amazing;

public class AmazingUnitTest {

    private static boolean success = true;

    public static void main(String[] args) {
        // (1) failing assertTrue should set state to failed
        success = true;
        assertTrue(false);
        if (success) {
            System.out.println("Green");
        } else {
            // assert: will sehen Red
            System.out.println("expected: Red");
        }

        // (2) success assertTrue should set state to true
        success = true;
        assertTrue(true);
        if (success) {
            // assert: will Green
            System.out.println("expected: Green");
        } else {
            System.out.println("Red");
        }

        // (3) failed followed by success should leave state to false
        success = true;
        assertTrue(false);
        assertTrue(true);
        if (success) {
            System.out.println("Green");
        } else {
            // assert: will sehen Red
            System.out.println("expected: Red");
        }
        // TODO refactor duplication
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
