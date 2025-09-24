package Task2;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoneyExchange {
    private Map<String, Double> arr = new LinkedHashMap<>();
    private final String from_rate;
    private double amount =0;
    private static final DecimalFormat df = new DecimalFormat("#.####");
    public MoneyExchange(String from_rate, Map<String, Double> arr) {
        this.from_rate = from_rate;
        this.arr = arr;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void run() throws InterruptedException {

        double total = amount * arr.get(from_rate);
        for (var v: arr.entrySet()){
            v.setValue(total/v.getValue());
        }
        arr.remove(from_rate);
        Thread.sleep(400);
        System.out.println(amount + " (" + from_rate + ")  - это:");
        for (var v: arr.entrySet()){
            Thread.sleep(400);
            System.out.println(v.getKey() + " - " + df.format(v.getValue()));
        }
    }
    @Override
    public String toString() {
        return "MoneyExchange{" +
                "arr=" + arr +
                ", from_rate='" + from_rate + '\'' +
                '}';
    }
}