public class Main {
  public static void main(String[] args) {
    System.out.println("Start");
    while (true) {
      String input = MenuUtil.getLine();
      Parse<Double> parse = Parse.stringToDouble(input);
      System.out.println(parse.getObject());
      System.out.println(parse.getResidual());
    }
    // System.out.println("Finish");
  }
}