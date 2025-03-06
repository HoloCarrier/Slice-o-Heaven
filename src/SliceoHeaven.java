import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
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
//添加takeorder方法
    public void takeorder() {
         String orderTotal = "";
        System.out.println("Enter three ingredients for your pizza (use spaces to separate\n" +
                " ingredients):");
        Scanner scanner = new Scanner(System.in);
        String[] ingredients = scanner.nextLine().split("");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];
        //输入pizza尺寸
        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize= scanner.nextLine();
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();
        System.out.println( "Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.nextLine();
        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = scanner.nextLine();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();
        //查看用户输入是Y或N并且调用isItYourBirthday()方法
        if (wantDiscount.equalsIgnoreCase("Y")) {
            if (isItYourBirthday()) {
                System.out.println("Your order is half price!");
            } else
             {
                 makeCardPayment();
                System.out.println("Sorry, you don't qualify for the 50% discount.");
            }
        }



    }
    //创建 isItYourBirthday()方法
    public static boolean isItYourBirthday(){
        System.out.println("Enter your birthdate (YYYY-MM-DD):");
        Scanner scanner = new Scanner(System.in);
        String birthday = scanner.nextLine();
        String birthdate = birthday;
        int year = Integer.parseInt(birthdate.substring(0, 4));
        int month = Integer.parseInt(birthdate.substring(5, 7));
        int day = Integer.parseInt(birthdate.substring(8, 10));
        LocalDate dob = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(dob, now);//判断是否小于十八岁并且今天是否是他的生日
        if (diff.getYears() >= 18 && dob.getMonthValue() == now.getMonthValue() && dob.getDayOfMonth() == now.getDayOfMonth()) {
            System.out.println("Congratulations! You pay only half the price for your order");
            return true;}
            else {
                System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                return false;
            }
    }
    //创建makeCardPayment()
    public void makeCardPayment() {
        System.out.println("Please give your cardNumber");
        Scanner scanner = new Scanner(System.in);
        Long cardNumber = Long.valueOf(scanner.nextLine());
        System.out.println("Please give your expiryDate");
        String expiryDate = scanner.nextLine();
        System.out.println("Please give your cvv");
        int cvv = Integer.parseInt(scanner.nextLine());
        //限制cvv长度为3
        if (String.valueOf(cvv).length() == 3) {
            System.out.println("Valid cvv");
        } else {
            System.out.println("Invalid cvv");
            return;
        }


    }

    //添加 processCardPayment()方法
    public void processCardPayment(Long cardNumber,String expiryDate,int cvv) {
        System.out.println("Processing credit cardNumber");
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() == 14){
            System.out.println("Valid card number");
        } else {
            System.out.println("Invalid card number");
            return;
        }
        //获取卡号第一个字符并转化为整数
        char firstCardDigit = cardNumberStr.charAt(0);
        System.out.println("First card digit: " + firstCardDigit);

        //判断是否为黑名单卡号
        long blacklistedNumbers = 1234567890;
        if (cardNumber == blacklistedNumbers) {
            System.out.println("Card number is blacklisted,Please use another card");
            return;
        }
        //获取卡号后四位并转化为整数
        String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
        int lastFourDigitsInt = Integer.parseInt(lastFourDigits);
        String cardNumberToDisplay = cardNumberStr.charAt(0) + "******" + cardNumberStr.substring(cardNumberStr.length() -4);
        System.out.println("" + cardNumberToDisplay);


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

    private  void printReceipt() {
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
















