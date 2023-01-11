import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList(3, 5, 7, 9);

        System.out.println("Для завершения программы нажмите z");
        System.out.println("Для добавление в стиком числа введите значение и позицию. \n" +
                "Если позиция вставки находится вне диапозона списка, то введеное значение будет добавлено в конец списка\n" +
                "пример : add 4 7 - добавляет элемент со значение 4 в позицию 7\n" +
                "add 4 - добавляет элемент со значением 4 в конец списка");
        System.out.println("Для удаления элемента списка введите значение элемента или его позицию\n" +
                "пример : pos 4 - удаляет элемент в позиции 4\n" +
                "val 4 - удаляет элемент со значение 4");
        System.out.println("Чтобы проверить удовлетворяет ли список закону x=f(x0, h)\n введите f начальное значение и шаг" +
                "пример : f 5 1");

        System.out.println(list.getAllList());
        Scanner scanner = new Scanner(System.in);

        for (String input = scanner.nextLine().trim().replaceAll("[\\s]{2,}", " "); !input.equals("z");
             input = scanner.nextLine().trim().replaceAll("[\\s]{2,}", " ")) {
            if (!input.matches("[a-zA-Z]*\\s+[-+0-9]*\\s*[-+0-9]*")) {
                if (input.length() != 0) {
                    System.out.println("Введена не коректная строка");
                }
                continue;
            }

            List<Integer> inputInt = new ArrayList();
            try {
                inputInt.add(Integer.parseInt(input.split(" ")[1].trim()));
                if (input.contains("f ") || input.split(" ").length == 3) {
                    inputInt.add(Integer.parseInt(input.split(" ")[2].trim()));
                }
            } catch (Exception ex) {
                System.out.println("Введена не коректная строка");
                continue;
            }
            if (input.contains("pos ")) {
                list.deleteNodePosition(inputInt.get(0));
            } else if (input.contains("val ")) {
                list.deleteNodeValue(inputInt.get(0));
            } else if (input.contains("add ")) {
                if (inputInt.size() == 1) {
                    list.addNode(inputInt.get(0));
                } else {
                    list.addNode(inputInt.get(0), inputInt.get(1));
                }
            } else if (input.contains("f ")) {
                System.out.println(list.f(inputInt.get(0), inputInt.get(1)));
            } else {
                System.out.println("Введена не коректная строка");
                continue;
            }

            System.out.println(list.getAllList());
        }
    }
}