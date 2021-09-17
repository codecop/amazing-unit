package amazing;

public class AmazingUnitTest {

    private static boolean success = true;

    public static void main(String[] args) {
        // (1) failing assertTrue should set state to failed
        beforeTest();
        
        assertTrue(false);
        
        if (result().contentEquals("Red")) {
            System.out.println("Green");
        } else {
            System.out.println("Red");
        }

        beforeTest();
        assertTrue(true);
        if (result().contentEquals("Green")) {
            // assert: will Green
            System.out.println("Green");
        } else {
            System.out.println("Red");
        }

        beforeTest();
        assertTrue(false);
        assertTrue(true);
        if (result().contentEquals("Red")) {
            System.out.println("Green");
        } else {
            // assert: will sehen Red
            System.out.println("Red");
        }
        // TODO refactor duplication
    }

    private static void beforeTest() {
        success = true;
    }
    
    private static String result() {
        if (success) {
            return "Green";
        }
        return "Red";
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
