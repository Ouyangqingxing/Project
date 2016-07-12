package inter;

import symbols.Type;
import lexer.Token;

/**
 * 表达式
 * @author Jason
 */
public class Expr extends Node{
	public Token op;	//结点上的运算符
	public Type type;	//节点上的类型
	Expr(Token tok,Type p){
		op = tok;
		type = p;
	}
	public Expr gen(){
		return this;
	}
	public Expr reduce(){
		return this;
	}
	public void jumping(int t, int f){
		emitjumps(toString() , t ,f);
	}
	public void emitjumps(String test , int t, int f){
		if(t != 0 && f != 0){
			emit("if " +test+" goto L" + t);
			emit("goto L" + f);
		}
		else if(t != 0){
			emit("if " + test + " goto L" + t);
		}
		else if(f != 0){
			emit("iffalse " + test + " goto L" + f );
		}
		else{};//该情况下不生成三地址代码	 t f直接穿过
	}
	public String toString(){
		return op.toString();
	}
}