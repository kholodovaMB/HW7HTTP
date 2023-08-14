package org.HMB;

public class Main {

    public static void main(String[] args) {

        new HttpImageStatusCli().askStatus();

//        try {
//            String url = new HttpStatusChecker().getStatusImage(3000);
//            System.out.println("url = " + url);
//        } catch (ExceptionServerCode e) {
//            System.err.println("HTTP status exception: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("An error occurred while making the HTTP request: " + e.getMessage());
//        } catch (InterruptedException e) {
//            System.err.println("The HTTP request was interrupted: " + e.getMessage());
//        }

//        try {
//            new HttpStatusImageDownloader().downloadStatusImage(202);
//        } catch (ExceptionServerCode e) {
//            System.err.println("HTTP status exception: " + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("An error occurred while making the HTTP request: " + e.getMessage());
//        } catch (InterruptedException e) {
//            System.err.println("The HTTP request was interrupted: " + e.getMessage());
//        }

    }
}