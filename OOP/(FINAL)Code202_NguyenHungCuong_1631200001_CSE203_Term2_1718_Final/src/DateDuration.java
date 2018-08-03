
//import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class DateDuration {

    int day;
    int month;
    int year;

    public DateDuration() {
        this.day=0;
        this.month=0;
        this.year=0;
    }

    public DateDuration(String str) {
        String[] res = str.split("/");
        this.day = Integer.parseInt(res[0]);
        this.month = Integer.parseInt(res[1]);
        this.year = Integer.parseInt(res[2]);
    }

    public DateDuration(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public void addDateDuration(DateDuration date){
        if (this.day+date.day>=30){
            this.day=((this.day+date.day)%30);
            this.month++;
        }else{
            this.day+=date.day;
        }
        if (this.month+date.month>=12){
            this.month=((this.month+date.month)%12);
            this.year++;
        }else{
            this.month+=date.month;
        }
        this.year+=date.year;
    }
    public String getDateDurationAsText(){
        return this.day+" days,"+this.month+" months,"+this.year+" years.";
    }
    public String getDateDurationAsNumber(){
        return this.day+"/"+this.month+"/"+this.year+".";
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String a = scan.next();
//        DateDuration res = new DateDuration(a);
//        System.out.println(res.getDateDurationAsText());
//        System.out.println(res.getDateDurationAsNumber());
//        int x=scan.nextInt();
//        int y=scan.nextInt();
//        int z=scan.nextInt();
//        DateDuration temp = new DateDuration(x, y, z);
//        res.addDateDuration(temp);
//        System.out.println(res.getDateDurationAsText());
//        System.out.println(res.getDateDurationAsNumber());
//    }
}
