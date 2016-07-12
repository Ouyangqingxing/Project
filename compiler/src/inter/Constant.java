package inter;

import lexer.Num;
import lexer.Token;
import lexer.Word;
import symbols.Type;

public class Constant extends Expr{
	public final static Constant
		True  = new Constant(Word.True  , Type.Bool),
		False = new Constant(Word.False , Type.Bool);
	
	public Constant(Token tok , Type p){
		super(tok,p);
	}
	public Constant(int i){
		super(new Num(i) , Type.Int);
	}
	public void jumping(int t , int f){
		if(this == True && t != 0){
			emit("goto L" + t);
		}
	}
}