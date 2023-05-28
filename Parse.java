

public class Parse<T> {

  T object;
  String residual;
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
  
  // stuff for number conversion
  // 
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
  public static double stringToDouble(String str) {
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
      if (str.charAt(index) == '.') {
        pastDecimal = true;
      } else {
        if (pastDecimal) {
          place /= 10;
        } else {
          out *= 10;
        }
        try {
          digit = charToDigit(str.charAt(index));
        } catch (Exception e) {
          throw new IllegalArgumentException("String failed to covert to double");
        }
        out += digit * place;
      }
      index ++;
    }
    return out * sign;
    // get inegerpart until decimal or end
    // if decimal stop int start decimal till end
  }
}
