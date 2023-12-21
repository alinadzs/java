import java.util.EmptyStackException;

public class _Stack_ {
    public static void main(String[] args) {
        // Создаем стек с емкостью 10
        Stack<Integer> stack = new Stack<>(10);

        // Добавляем элементы в стек
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Извлекаем и выводим на экран верхний элемент стека
        System.out.println(stack.pop());

        // Получаем и выводим на экран верхний элемент стека без его удаления
        System.out.println(stack.peek());

        // Добавляем еще один элемент в стек
        stack.push(4);

        // Извлекаем и выводим на экран верхний элемент стека
        System.out.println(stack.pop());
    }

    public static class Stack<T> {
        private T[] data;
        private int size;

        @SuppressWarnings("unchecked")
        public Stack(int capacity) {
            // Создаем массив заданной емкости для хранения элементов стека
            data = (T[]) new Object[capacity];
            size = 0;
        }

        public void push(T element) {
            // Проверяем, не заполнен ли стек
            if (size == data.length) {
                throw new StackOverflowError("Стек заполнен");
            }

            // Добавляем элемент на верхушку стека
            data[size++] = element;
        }

        public T pop() {
            // Проверяем, не пуст ли стек
            if (size == 0) {
                throw new EmptyStackException();
            }

            // Извлекаем элемент с верхушки стека
            T element = data[--size];

            // Удаляем ссылку на извлеченный элемент
            data[size] = null;

            return element;
        }

        public T peek() {
            // Проверяем, не пуст ли стек
            if (size == 0) {
                throw new EmptyStackException();
            }

            // Возвращаем верхний элемент стека без его удаления
            return data[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}