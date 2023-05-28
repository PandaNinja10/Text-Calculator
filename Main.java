public class Main {
  public static void main(String[] args) {
    System.out.println("Start");

    String input = MenuUtil.getLine();
    Parse<Double> parse = Parse.parseAddSubtract(input);
    System.out.println(parse.getObject());
    System.out.println(parse.getResidual());
    
    System.out.println("Finish");
  }
}