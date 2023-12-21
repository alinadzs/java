public class Main {
    public static void main(String[] args) {
        HashTable<String, Order> orders = new HashTable<>();

        System.out.println("Стол пуст: " + orders.isEmpty());

        orders.put("1", new Order(new String[]{"french fries", "milkshake"}, 12, "12:00"));

        System.out.println("Заказ: " + orders.size());

        orders.put("2", new Order(new String[]{"beef steak", "orange juice"}, 12, "12:51"));

        System.out.println("Заказ: " + orders.size());

        System.out.println("Время заказа: " + orders.getValue("2").orderTime);

        orders.remoteKey("1");
        System.out.println("Заказ: " + orders.size());
        System.out.println("Время заказа: " + orders.getValue("1"));
    }
}