package inter;

import symbols.Type;
import lexer.Tag;
import lexer.Word;

public class Access extends Op{
	public Id array;
	public Expr index;
	
	//p为将数组平坦化设计后的元素类型
	public Access(Id a ,Expr i ,Type p){
		super(new Word("[]",Tag.INDEX),p);
	}
	public Expr gen(){
		return new Access(array,index.reduce(),type);
	}
	public void jumping(int t,int f){
		emitjumps(reduce().toString(),t,f);
	}
	public String toString(){
		return array.toString() + " [ " + index.toString() + " ] ";
	}
}