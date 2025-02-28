public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    private String storeMenu;
    public double pizzaPrice;
    public String pizzaOfTheDay;
    public String sideOfTheDay;
    public String specialPrice;

    private String ordersides;
    private String orderdrinks;
    private String orderID;
    private double orderTotal;
    private String pizzaIngredients;
    private String cardNumber;
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
    //添加 processCardPayment()方法
    public void processCardPayment(String cardNumber,String expiryDate,int cvv) {
        System.out.println("Processing credit cardNumber");
        int cardNumberLength = cardNumber.length();
        if (cardNumberLength == 14){
            System.out.println("Valid card number");
        } else {
            System.out.println("Invalid card number");
            return;
        }
        //获取卡号第一个字符并转化为整数
        int firstcardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        //判断是否为黑名单卡号
        String blackListCardNumber = "1234567890123456";
        if (cardNumber.equals(blackListCardNumber)) {
            System.out.println("Card number is blacklisted");
            return;
        }
        //获取卡号后四位并转化为整数
        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumberLength - 4));
        //处理卡号字符并保存
        String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1,cardNumber.length() -4).replaceAll(",","*") +
                cardNumber.substring(cardNumberLength - 4);
        System.out.println("Card number: " + cardNumberToDisplay);
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
    //设置specialOfTheDay()方法
    public static void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice){
        StringBuilder sb = new StringBuilder();
        sb.append("Today's special: ").append(pizzaOfTheDay).append(" with ").append(sideOfTheDay).append(" for only $").append(specialPrice).append("!");
        System.out.println(sb.toString());
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
















