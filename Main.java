public class Main {
  public static void main(String[] args) {
    System.out.println("Start");
    while (true) {
      String input = MenuUtil.getLine();
      Parse<Double> parse = Parse.parseAddSubtract(input);
      System.out.println("Out: " + parse.getObject());
      System.out.println("Resid: " + parse.getResidual());
    }
    // System.out.println("Finish");
  }
}