public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public CircularLinkedList(int... arr) {
        for (int value : arr) {
            addNode(value);
        }
    }

    public void addNode(int value, int pos) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.nextNode = head;
            return;
        }

        if (pos >= 0) {
            Node previousNode = tail;
            Node currentNode = head;
            int i = 0;
            do {
                if (i == pos) {
                    previousNode.nextNode = newNode;
                    newNode.nextNode = currentNode;
                    if (head == currentNode) {
                        head = newNode;
                    }
                    if (tail == currentNode) {
                        tail = newNode;
                    }
                    return;
                }
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
                i++;
            } while (currentNode != head);
        }
        tail.nextNode = newNode;
        tail = newNode;
        tail.nextNode = head;
    }

    public void addNode(int value) {
        addNode(value, -1);
    }

    public boolean deleteNodePosition(int pos) {
        if (pos < 0) {
            System.out.println("Позиция должна быть положительным числом");
            return false;
        }
        if (head == null) {
            System.out.println("Список пустой");
            return false;
        }
        if (deleteNode(pos, true)) {
            System.out.println("Элемент в позиции " + pos + " удален");
            return true;
        } else {
            System.out.println("В списке нет элемента с позицией " + pos);
            return false;
        }
    }

    public boolean deleteNodeValue(int value) {
        if (head == null) {
            System.out.println("Список пустой");
            return false;
        }
        if (deleteNode(value, false)) {
            System.out.println("Элемент со значение " + value + " удален");
            return true;
        } else {
            System.out.println("В списке нет элемента со значением " + value);
            return false;
        }
    }

    private boolean deleteNode(int paramToDelete, boolean deleteInPosition) {
        Node previousNode = tail;
        Node currentNode = head;
        int i = 0;
        do {
            if ((deleteInPosition & i == paramToDelete) |
                    (!deleteInPosition & currentNode.value == paramToDelete)){
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    previousNode.nextNode = currentNode.nextNode;
                    if (head == currentNode) {
                        head = head.nextNode;
                    }
                    if (tail == currentNode) {
                        tail = previousNode;
                    }
                }
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            i++;
        } while (currentNode != head);
        return false;
    }

    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    public String getAllList() {
        if (head == null) {
            return "Список пустой";
        }
        Node currentNode = head;
        StringBuilder allList = new StringBuilder("Текущий список\n");
        int num = 0;
        do {
            allList.append("pos - " + num + ": value - " + currentNode.value + "\n");
            currentNode = currentNode.nextNode;
            num++;
        } while (currentNode != head);
        return allList.toString();
    }

    public boolean f(int previousValue, int step) {
        Node currentNode = head.nextNode;
        do {
            previousValue += step;
            if (currentNode.value != previousValue) {
                return false;
            }
            currentNode = currentNode.nextNode;
        } while (currentNode != head);
        return true;
    }
}
