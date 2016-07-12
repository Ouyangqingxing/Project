package inter;

import symbols.Type;
import lexer.Word;

public class Id extends Expr{
	public int offset;	//相对地址
	public Id(Word id , Type p , int b){
		super(id,p);
		offset = b;
	}
}