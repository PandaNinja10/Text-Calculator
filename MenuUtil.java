import java.util.Scanner;

public class MenuUtil{
    
    private static Scanner sc = new Scanner(System.in);
    private static Scanner scStr = new Scanner(System.in);
    
    public static int getInt(int min, int max){
        int num = sc.nextInt();
        while(num < min || num > max){
            System.out.println("the number must be between " + min + " and " + max);
            num = sc.nextInt();
        }
        return num;
    }
    public static double getDouble(double min, double max){
        double num = sc.nextDouble();
        while(num < min || num > max){
            System.out.println("the number must be between " + min + " and " + max);
            num = sc.nextDouble();
        }
        return num;
    }
    
    public static double getDoubleEnd(double min, double max){
        double num = sc.nextDouble();
        while( ( num < min || num > max ) && num != -1){
            System.out.println("the number must be between " + min + " and " + max + "or -1 to end");
            num = sc.nextDouble();
        }
        return num;
    }
    
    public static int getIntEnd(int min, int max){
        int num = sc.nextInt();
        while( ( num < min || num > max ) && num != -1){
            System.out.println("the number must be between " + min + " and " + max + "or -1 to end");
            num = sc.nextInt();
        }
        return num;
    }
    
    public static int genRandInt(int min, int max){
        return (int) ( Math.random() * ( max - min + 1) )+min;
    }
    public static double genRandDouble(int min, int max){
        return Math.random() * ( max - min ) +min;
    }
    
    public static String getLine(){
        return scStr.nextLine();
    }
    public static char getChar(){
        return scStr.next().charAt(0);
    }
    public static int getInt(){
        return sc.nextInt();
    }
}
