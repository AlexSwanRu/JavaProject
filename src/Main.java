import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkList<rating> nomenclature = new SingleLinkList<>();

        nomenclature.addToEnd(new rating(1, "Director", "$1000000"));
        nomenclature.addToEnd(new rating(2, "Assistant Manager", "$100000"));
        nomenclature.addToEnd(new rating(3, "Accountant", "$10000"));
        nomenclature.addToEnd(new rating(4, "Programmer", "$1000"));
        nomenclature.addToEnd(new rating(5, "Cleaning lady", "$100"));

        for (Object rating : nomenclature) {
            System.out.println(rating);
        }
        nomenclature.reverse();

        System.out.println("-------------------------------------");

        for (Object rating : nomenclature) {
            System.out.println(rating);
        }
    }

    static class rating {

        int id;
        String position;
        String salary;

        public rating(int id, String position, String salary) {
            this.id = id;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "rating{" +
                    "id=" + id +
                    ", position='" + position + '\'' +
                    ", salary='" + salary + '\'' +
                    '}';
        }
    }


    /**
     * List class
     *
     * @param <T>
     */
    public static class SingleLinkList<T> implements Iterable {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        /**
         * The class of an individual element
         *
         * @param <T>
         */
        private static class ListItem<T> {

            T data;
            ListItem<T> next;
        }

        //The head is empty
        public boolean isEmpty() {
            return head == null;
        }

        //filling in the list
        public void addToEnd(T item) {

            //Memory allocation for the list
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            //If, the head and tail are empty
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else { //If it is not empty, then we pass the address to the element and put it in the tail
                tail.next = newItem;
                tail = newItem;
            }
        }

        //list reversal method
        public void reverse() {
            if (!isEmpty() && head.next != null) {//If the head is not zero
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}