package Task3;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("Введите количество символов в пароле (от 8 до 12):");
            String regex = "(8|9|1[0-2])";
            String length = sc.nextLine();
            if (length.matches(regex)) {
                Password password = new Password(Integer.parseInt(length));
                String generatedPassword = password.generatePassword();
                System.out.println("сгенерированный пароль - " + generatedPassword);
                break;
            } else {
                System.out.println("Ошибка в вводе количества символов.");
                Thread.sleep(1000);
            }
        }

    }
}
