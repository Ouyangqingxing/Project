package lexer;

/**
 * 处理浮点数
 * @author Jason
 */
public class Real extends Token{
	public final float value;
	public Real(float v){
		super(Tag.REAL);
		value = v;
	}
	public String toString(){
		return "" + value;
	}
}