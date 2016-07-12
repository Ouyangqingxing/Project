package inter;

import lexer.Lexer;

public class Node {
	int lexline = 0;
	static int labels = 0;
	Node(){
		lexline = Lexer.line;
	}
	void error(String s){
		throw new Error("near line" + lexline + ": "+s);
	}
	//下面三个方法用来生成三地址代码
	public int newlabel(){
		return ++labels;
	}
	public void emitlabel(int i){
		System.out.println("L" + i + ":");
	}
	public void emit(String s){
		System.out.println("\t" + s);
	}
}