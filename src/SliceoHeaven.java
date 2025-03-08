import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public static final String blacklistedNumber = "12345678901234";

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
    //添加新的takeOrder()方法
    public void takeOrder() {
        //存储用户输入用户输入的数字范围为1-5否则重新输入,直到用户输入的数字在1-5之间
        Scanner scanner = new Scanner(System.in);
        int ingChoice1, ingChoice2, ingChoice3;
        String ing1 = "", ing2 = "", ing3 = "";

        boolean allValid;
        do {
            allValid = true;
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.println("Enter any three choices (1, 2, 3,...) separated by spaces:");

            try {
                ingChoice1 = scanner.nextInt();
                ingChoice2 = scanner.nextInt();
                ingChoice3 = scanner.nextInt();

                if (ingChoice1 < 1 || ingChoice1 > 5 || ingChoice2 < 1 || ingChoice2 > 5 || ingChoice3 < 1 || ingChoice3 > 5) {
                    allValid = false;
                    System.out.println("Invalid choice(s). Please pick only from the given list.");
                    continue;
                }

                switch (ingChoice1) {
                    case 1:
                        ing1 = "Mushroom";
                        break;
                    case 2:
                        ing1 = "Paprika";
                        break;
                    case 3:
                        ing1 = "Sun-dried tomatoes";
                        break;
                    case 4:
                        ing1 = "Chicken";
                        break;
                    case 5:
                        ing1 = "Pineapple";
                        break;
                }

                switch (ingChoice2) {
                    case 1:
                        ing2 = "Mushroom";
                        break;
                    case 2:
                        ing2 = "Paprika";
                        break;
                    case 3:
                        ing2 = "Sun-dried tomatoes";
                        break;
                    case 4:
                        ing2 = "Chicken";
                        break;
                    case 5:
                        ing2 = "Pineapple";
                        break;
                }

                switch (ingChoice3) {
                    case 1:
                        ing3 = "Mushroom";
                        break;
                    case 2:
                        ing3 = "Paprika";
                        break;
                    case 3:
                        ing3 = "Sun-dried tomatoes";
                        break;
                    case 4:
                        ing3 = "Chicken";
                        break;
                    case 5:
                        ing3 = "Pineapple";
                        break;
                }
            } catch (InputMismatchException e) {
                allValid = false;
                System.out.println("Invalid input. Please enter valid numbers.");
                scanner.nextLine();
            }
        } while (!allValid);

        System.out.println("You chose: " + ing1 + ", " + ing2 + ", " + ing3);

        scanner.close();

        //让用户选择pizza的大小
        int sizeChoice;
        String pizzaSize = "";
        String extraCheese = "";

        do {
            try {
                System.out.println("What size should your pizza be?");
                System.out.println("1. Large");
                System.out.println("2. Medium");
                System.out.println("3. Small");
                System.out.println("Enter only one choice (1, 2, or 3):");
                sizeChoice = scanner.nextInt();

                switch (sizeChoice) {
                    case 1:
                        pizzaSize = "Large";
                        break;
                    case 2:
                        pizzaSize = "Medium";
                        break;
                    case 3:
                        pizzaSize = "Small";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        } while (true);

        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();

        scanner.close();
        int sideDishChoice;
        String sideDish = "";

        do {
            try {
                System.out.println("Following are the side dish that go well with your pizza:");
                System.out.println("1. Calzone");
                System.out.println("2. Garlic bread");
                System.out.println("3. Chicken puff");
                System.out.println("4. Muffin");
                System.out.println("5. Nothing for me");
                System.out.println("What would you like? Pick one (1, 2, 3,...):");
                sideDishChoice = scanner.nextInt();

                switch (sideDishChoice) {
                    case 1:
                        sideDish = "Calzone";
                        break;
                    case 2:
                        sideDish = "Garlic bread";
                        break;
                    case 3:
                        sideDish = "Chicken puff";
                        break;
                    case 4:
                        sideDish = "Muffin";
                        break;
                    case 5:
                        sideDish = "Nothing for me";
                        break;
                    default:
                        System.out.println("Invalid choice. Please pick a number between 1 and 5.");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        } while (true);

        System.out.println("You chose: " + sideDish);

        scanner.close();
        int drinkChoice;
        String drinks = "";

        do {
            try {
                System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
                System.out.println("1. Coca Cola");
                System.out.println("2. Cold coffee");
                System.out.println("3. Cocoa Drink");
                System.out.println("4. No drinks for me");
                System.out.println("Enter your choice:");
                drinkChoice = scanner.nextInt();

                switch (drinkChoice) {
                    case 1:
                        drinks = "Coca Cola";
                        break;
                    case 2:
                        drinks = "Cold coffee";
                        break;
                    case 3:
                        drinks = "Cocoa Drink";
                        break;
                    case 4:
                        drinks = "No drinks for me";
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        } while (true);

        System.out.println("You chose: " + drinks);

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String halfPriceChoice = scanner.next();

        scanner.close();

        System.out.println("Drink choice: " + drinks);
        System.out.println("Half price option: " + halfPriceChoice);


    }


    //创建 isItYourBirthday()方法
    public static boolean isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        LocalDate now = LocalDate.now();

        while (true) {
            try {
                System.out.println("Enter your birthdate (YYYY-MM-DD):");
                String birthday = scanner.nextLine();
                LocalDate dob = LocalDate.parse(birthday);

                Period diff = Period.between(dob, now);

                if (diff.getYears() < 5 || diff.getYears() > 120) {
                    System.out.println("Invalid date. You are either too young or too old to order. Please enter a valid date.");
                    continue;
                }

                if (diff.getYears() >= 18 && dob.getMonthValue() == now.getMonthValue() && dob.getDayOfMonth() == now.getDayOfMonth()) {
                    System.out.println("Congratulations! You pay only half the price for your order");
                    return true;
                } else {
                    System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date in YYYY-MM-DD format.");
            }
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
        // 假设这是黑名单号码，实际应用中可能从其他地方获取



            java.util.Scanner scanner = new java.util.Scanner(System.in);

            while (true) {
                System.out.println("Enter your 14 - digit card number:");
                String cardNumber1 = scanner.nextLine();

                if (cardNumber1.length() == 14 &&!cardNumber.equals(blacklistedNumber)) {
                    // 这里可以添加实际处理信用卡支付的逻辑
                    System.out.println("Valid card number. Proceeding with payment...");
                    break;
                } else {
                    System.out.println("Invalid card number. Please enter a 14 - digit number that is not blacklisted.");
                }
            }



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
















