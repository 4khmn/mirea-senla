package Task2;

import java.util.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        // ВАЛЮТЫ
        Map<String, Double> arr = new LinkedHashMap<>();
        arr.put("Рубль RUB", 1.0000);
        arr.put("Доллар USD", 83.5888);
        arr.put("Евро EUR", 98.6561);
        arr.put("Китайский Юань CNY", 11.7495);
        arr.put("Японская йена JPY", 0.5659);
        arr.put("Британский Фунт стерлингов GBP", 112.9700);

        System.out.println("Добро пожаловать в обменник валюты!");


        System.out.println("Введите 1 для константного значения валюты, 2 для ручного ввода с консоли");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String choice = sc.nextLine();
            String regex = "(1|2)";
            if (choice.matches(regex)) {
                if (Integer.parseInt(choice) == 1) {
                    System.out.println("константные значения (относительно рубля)");
                    for (var v : arr.entrySet()) {
                        Thread.sleep(400);
                        System.out.println(v.getKey() + " - " + v.getValue());
                    }



                } else if (Integer.parseInt(choice) == 2) {
                    System.out.println("Введите курсы валют (относительно рубля)");
                    for (var v : arr.entrySet()) {
                        if (!v.getKey().equals("Рубль RUB")) {
                            System.out.print("Введите значение для валюты: " + v.getKey() + " ");
                            double value;
                            while (true) {
                                try {
                                    value = sc.nextDouble();
                                    if (value <= 0) {
                                        System.out.println("значение для валюты должно быть больше 0");
                                        Thread.sleep(500);
                                        System.out.print("Введите значение для валюты: " + v.getKey() + " ");
                                        continue;
                                    }
                                    sc.nextLine();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Попробуйте еще раз!");
                                    sc.nextLine();
                                    Thread.sleep(1000);
                                    System.out.print("Введите значение на валюты: " + v.getKey() + " ");
                                }
                            }
                            v.setValue(value);
                        }
                    }
                }
                break;

            } else {
                System.out.println("Ошибка, попробуйте еще раз!");
                continue;
            }
        }
        Thread.sleep(700);
        System.out.println("================================================");


        String rate;
        MoneyExchange exchange = null;
        while(true) {
            System.out.println("Введите валюту, которую вы хотите конвертировать: ");
            int count=1;
            for (var v : arr.entrySet()) {
                System.out.println(count++ + " - " + v.getKey());
            }
            switch (rate = sc.nextLine()) {
                case "1":
                    exchange = new MoneyExchange("Рубль RUB", arr);
                    break;
                case "2":
                    exchange = new MoneyExchange("Доллар USD", arr);
                    break;
                case "3":
                    exchange = new MoneyExchange("Евро EUR", arr);
                    break;
                case "4":
                    exchange = new MoneyExchange("Китайский Юань CNY", arr);
                    break;
                case "5":
                    exchange = new MoneyExchange("Японская йена JPY", arr);
                    break;
                case "6":
                    exchange = new MoneyExchange("Британский Фунт стерлингов GBP", arr);
                    break;
                default:
                    System.out.println("Ошибка! Попробуйте еще раз!");
                    Thread.sleep(1000);
                    continue;

            }
            break;
        }
        System.out.print("Введите количество: ");
        double amount;
        while (true) {
            try {
                amount = sc.nextDouble();
                if (amount <= 0) {
                    System.out.println("Количество должно быть больше 0");
                    Thread.sleep(500);
                    System.out.print("Введите количество: ");
                    continue;
                }
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Попробуйте еще раз!");
                sc.nextLine();
                Thread.sleep(1000);
                System.out.print("Введите количество: ");
            }

        }
        exchange.setAmount(amount);


        exchange.run();
    }
}