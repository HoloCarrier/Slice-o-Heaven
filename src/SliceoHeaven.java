import  java.util.ArrayList;
public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    private String storeMenu;
    public ArrayList<String> pizzaIngredients;
    public double pizzaPrice;

    private String ordersides;
    private String orderdrinks;
    private String orderID;
    private double orderTotal;

    public void takeorder(String id, String sides, String drinks, double total, String menu) {
        orderID = id;
        orderdrinks = drinks;
        ordersides = sides;
        orderTotal = total;
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

    public void makePizza() {
        System.out.println("Making pizza with ingredients: ");
        for (String ingredient : pizzaIngredients) {
            System.out.println(ingredient);
        }
    }
    private void printReceipt(){
        System.out.println("********RECEIPT********");

        System.out.println("Order ID: " + orderID);
        System.out.println("Order drinks: " + orderdrinks);
        System.out.println("Order sides:" +ordersides);
        System.out.println("Order Total: " + orderTotal);
        System.out.println("storename:" + storeName);
        System.out.println("storeAddress:" + storeAddress );
        System.out.println("storephone:" + storePhone);
        System.out.println("storeemail:" + storeEmail);
    }
}


