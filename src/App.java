public class App {
    public static void main(String[] args) throws Exception {
        leiste<Integer> app = new leiste<>();

        Integer[] numbers = new Integer[] { 12, 34, 345, 234, 5634, 56, 467, 354, 62, 5, 2354, 23, 45, 12, 2, 345, 26,
                345, 4, 67, 34, 23, 562, 345, 26, 3434 };

        for (Integer integer : numbers) {
            app.enque(integer);
        }

        app.debug();

        for (int i = 0; i < app.size() + 1; i++) {

            try {
                System.out.println(app.deque());

            } catch (Exception e) {

                System.out.println("Das war richtig");

            }

            app.debug();

        }

        for (Integer integer : numbers) {
            app.enque(integer);
        }

    }
}
