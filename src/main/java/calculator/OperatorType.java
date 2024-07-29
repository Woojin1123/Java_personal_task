package calculator;

public enum OperatorType {
  ADD('+'),SUB('-'),MUL('*'),DIV('/'),MOD('%');
  final private char opChar;
  private OperatorType(char op){
    this.opChar = op;
  }
  public char getOpChar() {
    return opChar;
  }
}
