package calculator;

public enum OperatorType { //OperatorType enum
  ADD('+'),SUB('-'),MUL('*'),DIV('/'),MOD('%'); //상수('기호') 형식으로 초기화
  final private char opChar; //상수에 맞는 기호를 저장할 opchar
  private OperatorType(char op){ // 상수에 맞는 연산기호 초기화
    this.opChar = op;
  }
  public char getOpChar() { //opChar Getter
    return opChar;
  }
  public static OperatorType fromOperator(char opChar) throws IllegalArgumentException{ // 입력된 연산기호에 맞는 enum 반환,enum은 외부에서 인스턴스를 생성할 수 없으므로 static으로 메소드 선언
    for(OperatorType op : OperatorType.values()){
      if(op.getOpChar() == opChar){
        return op;
      }
    }
    throw new IllegalArgumentException("잘못된 연산 기호입니다.");
  }
}
