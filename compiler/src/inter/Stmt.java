package inter;

/**
 * 语句
 * @author Jason
 */
public class Stmt extends Node{
	int after = 0;								//保存下一条指令的标号
	public static Stmt Enclosing = Stmt.Null;	//用于break语句
	
	public Stmt(){}
	public static Stmt Null = new Stmt();
	public void gen(int b,int a){}
}