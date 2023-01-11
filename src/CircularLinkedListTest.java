import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularLinkedListTest {
    @Test
    public void unitTest() {
        CircularLinkedList list = new CircularLinkedList();

        list.addNode(3);
        list.addNode(2);
        list.addNode(6);
        list.addNode(19);

        assertTrue(list.containsNode(4));
    }
}
