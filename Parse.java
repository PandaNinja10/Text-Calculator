public class Parse<T> {

  private T object;
  private String residual;
  public Parse(T object, String residual){
    this.object = object;
    this.residual = residual;
  }
  public T getObject() {
    return object;
  }
  public String getResidual() {
    return residual;
  }
  public boolean noResidual() {
    return residual.equals("");
  }
  public boolean isParsed(){
    return object != null;
  }

  // char to digit
  public static int charToDigit(char ch){
    if (ch == '0') return 0;
    if (ch == '1') return 1;
    if (ch == '2') return 2;
    if (ch == '3') return 3;
    if (ch == '4') return 4;
    if (ch == '5') return 5;
    if (ch == '6') return 6;
    if (ch == '7') return 7;
    if (ch == '8') return 8;
    if (ch == '9') return 9;
    throw new IllegalArgumentException("char failed to covert to digit");
  }

  // string to double
  public static Parse<Double> stringToDouble(String str) {
    int index = 0;
    double out = 0;
    int sign = 1;
    boolean pastDecimal = false;
    double place = 1;
    int digit;
    // check for negative sign
    if (str.charAt(index) == '-') {
      sign = -1;
      index++;
    }
    while (index < str.length()) {
      if (str.charAt(index) == '.' && !pastDecimal) {
        pastDecimal = true;
      } else {
        try {
          digit = charToDigit(str.charAt(index));
        } catch (Exception e) {
          return new Parse<Double>(out * sign, str.substring(index));
          //throw new IllegalArgumentException("String failed to covert to double");
        }
        if (pastDecimal) {
          place /= 10;
        } else {
          out *= 10;
        }
        out += digit * place;
      }
      index ++;
    }
    return new Parse<Double>(out * sign, str.substring(index));
    // get ineger part until decimal or end
    // if decimal stop int start decimal till end
  }

  public static Parse<Double> parseAddSubtract(String str) {
    Parse<Double> p1, p2;
    p1 = parseMultiplyDivide(str);
    if (!p1.isParsed()) return p1;
    if (p1.noResidual()) return p1;
    while (!p1.noResidual() && (p1.getResidual().charAt(0) == '+' || p1.getResidual().charAt(0) == '-' )) {
      p2 = parseMultiplyDivide(p1.getResidual().substring(1));
      if (!p2.isParsed()) return p1;
      if (p1.getResidual().charAt(0) == '+') {
        p1 = new Parse<Double>(p1.getObject() + p2.getObject(), p2.getResidual());
      } else if (p1.getResidual().charAt(0) == '-') {
        p1 = new Parse<Double>(p1.getObject() - p2.getObject(), p2.getResidual());
      }
    }
    return p1;
  }
  public static Parse<Double> parseMultiplyDivide(String str) {
    Parse<Double> p1, p2;
    p1 = parseBracket(str);
    if (!p1.isParsed()) return p1;
    if (p1.noResidual()) return p1;
    while (!p1.noResidual() && (p1.getResidual().charAt(0) == '*' || p1.getResidual().charAt(0) == '/')) {
      p2 = parseBracket(p1.getResidual().substring(1));
      if (!p2.isParsed()) return p1;
      if (p1.getResidual().charAt(0) == '*') {
        p1 = new Parse<Double>(p1.getObject() * p2.getObject(), p2.getResidual());
      } else if (p1.getResidual().charAt(0) == '/') {
        p1 = new Parse<Double>(p1.getObject() / p2.getObject(), p2.getResidual());
      }
    }
    return p1;
  }
  public static Parse<Double> parseBracket(String str) {
    Parse<Double> p1;
    // (X)
    if (str.charAt(0) == '(') {
      p1 = parseAddSubtract(str.substring(1));
      if (p1.isParsed() && p1.getResidual().charAt(0) == ')') 
        return new Parse<Double>(p1.getObject(), p1.getResidual().substring(1));
    }
    return stringToDouble(str);
  }
}
