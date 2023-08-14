package org.HMB;

import org.HMB.exeptions.ExceptionServerCode;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpImageStatusCli {

    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        int code = 0;
        String input = "";
        Pattern pattern = Pattern.compile("^\\d{3}$");

        while (!input.equals("exit")) {
            try {
                System.out.println("Enter HTTP status code or exit: ");
                input = scanner.nextLine();
                if (pattern.matcher(input).matches()) {
                    code = Integer.parseInt(input);
                    new HttpStatusImageDownloader().downloadStatusImage(code);
                } else {
                    System.err.println("Is not correct code. Please enter valid number.");
                }
            } catch (ExceptionServerCode e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("The HTTP request was interrupted:");
            }
        }
        scanner.close();
    }
}
