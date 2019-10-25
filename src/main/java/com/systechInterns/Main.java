package com.systechInterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter date one: ");
        String inputString1 = scan.nextLine();
        System.out.println("Enter date two: ");
        String inputString2 = scan.nextLine();

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//            int di = date2.getDay() - date1.getDay();
//            System.out.println(di);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
