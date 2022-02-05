import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> studentArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionArray = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 1000; i++) {
            if (solutionArray.size() == 0) {
                int number = StdRandom.uniform(1000);
                int flag = StdRandom.uniform(2);
                if (flag == 0) {
                    message = message + "addFirst(" + number + ")\n";
                    studentArray.addFirst(number);
                    solutionArray.addFirst(number);
                } else {
                    message = message + "addLast(" + number + ")\n";
                    studentArray.addLast(number);
                    solutionArray.addLast(number);
                }
            } else {
                int condition = StdRandom.uniform(4);
                int number = StdRandom.uniform(1000);
                Integer studentRemoveNumber = 1;
                Integer solutionRemoveNumber = 1;
                switch (condition) {
                    case 0:
                        message = message + "addFirst(" + number + ")\n";
                        studentArray.addFirst(number);
                        solutionArray.addFirst(number);
                        break;
                    case 1:
                        message = message + "addLast(" + number + ")\n";
                        studentArray.addLast(number);
                        solutionArray.addLast(number);
                        break;
                    case 2:
                        message = message + "removeFirst()\n";
                        studentRemoveNumber = studentArray.removeFirst();
                        solutionRemoveNumber = solutionArray.removeFirst();
                        break;
                    case 3:
                        message = message + "removeLast()\n";
                        studentRemoveNumber = studentArray.removeLast();
                        solutionRemoveNumber = solutionArray.removeLast();
                        break;
                    default:
                }
                assertEquals(message, solutionRemoveNumber, studentRemoveNumber);
            }
        }

    }
}
