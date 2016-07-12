package inter;

/**
 * 使用stmt来保存外围语句构造
 * @author Jason
 */
public class Break extends Stmt{
	Stmt stmt;
	
	public Break(){
		if(Stmt.Enclosing == Stmt.Null){
			error("unenclosed break");
		}
		stmt = Stmt.Enclosing;
	}
	public void gen(int b,int a){
		emit("goto L" + stmt.after);
	}
}