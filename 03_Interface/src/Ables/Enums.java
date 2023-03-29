package Ables;

public class Enums {
    public enum Dice {
        ONE(1) {
            @Override
            public String toString() {
                return "jeden";
            }
        },
        TWO(2),
        THREE(3);

        int value;

        Dice(int value) {
            this.value = value;
        }

        void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + this.value;
        }
    }

    public static void main(String[] args) {
        Dice roll = Dice.TWO;
        System.out.println(roll);
        roll.setValue(5);

        System.out.println(roll);

        Node<Integer> n1 = new Node(3);
        Node<Double> n2 = new Node(2.3);
        Node<String> n3 = new Node("abc");

        Node[] nodes = {
                n1, n2, n3
        };

        for (Node n : nodes) {
            System.out.print(n + "\n");
        }
    }

    public static class Node<Type> {
        Type data;

        public Node(Type data) {
            this.data = data;
        }

        public Type getData() {
            return data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public class List<T> {

    }

    public class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}