public class Parse {
  
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
    // get inegerpart until decimal or end
    // if decimal stop int start decimal till end
  }
}
