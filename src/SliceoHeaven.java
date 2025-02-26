public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    private String storeMenu;
    public double pizzaPrice;

    private String ordersides;
    private String orderdrinks;
    private String orderID;
    private double orderTotal;
    private String pizzaIngredients;
    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final double DEF_ORDER_TOTAL = 15.00;
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";

    public void takeorder(String id, String sides, String drinks, double total) {
        orderdrinks = drinks;
        this.orderID = DEF_ORDER_ID;
        ordersides = sides;
        this.orderTotal = DEF_ORDER_TOTAL;
        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");

        printReceipt();
    }

    // 设置Getter和Setter方法
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String id) {
        this.orderID = id;
    }

    public static double getDefOrderTotal() {
        return DEF_ORDER_TOTAL;
    }

    public void setOrderTotal(double total) {
        this.orderTotal = total;
    }

    public void setPizzaIngredients(String ingredients) {
        this.pizzaIngredients = ingredients;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    // 默认构造函数
    public SliceoHeaven() {
        this.storeName = "Sliceo Heaven";
        this.storeAddress = "123 Main St";
        this.storeEmail = "info@sliceoheaven.com";
        this.storePhone = 1234567890;
        this.storeMenu = "Pizza, Pasta, Salads, Desserts, Drinks";
        this.pizzaPrice = 15.00;
        this.orderdrinks = "Water";
        this.ordersides = "Fries";
        this.orderID = DEF_ORDER_ID;
    }

    private void makePizza() {
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");

        System.out.println("Order ID: " + orderID);
        System.out.println("Order drinks: " + orderdrinks);
        System.out.println("Order sides:" + ordersides);
        System.out.println("Order Total: " + orderTotal);
        System.out.println("storename:" + storeName);
        System.out.println("storeAddress:" + storeAddress);
        System.out.println("storephone:" + storePhone);
        System.out.println("storeemail:" + storeEmail);
    }
}














