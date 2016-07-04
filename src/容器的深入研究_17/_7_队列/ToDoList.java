package 容器的深入研究_17._7_队列;

import java.util.PriorityQueue;

/**
 * Created by biezhihua on 16-6-30.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {

        private char primary;

        private int secondary;

        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return 1;
            }

            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return 1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }

            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + " : " + item;
        }
    }

    public void add(String id, char pri, int sec) {
        super.add(new ToDoItem(pri, sec, id));
    }


    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add("Empty trash", 'C', 4);
        toDoItems.add("Feed dog", 'A', 2);
        toDoItems.add("Feed bird", 'B', 7);
        toDoItems.add("Mow lawn", 'C', 3);
        toDoItems.add("Water lawn", 'A', 1);
        toDoItems.add("Feed cat", 'B', 1);

        while (!toDoItems.isEmpty()) {
            System.out.println(toDoItems.poll());
            System.out.println(toDoItems.remove());
        }
    }
}
