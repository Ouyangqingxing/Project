package main;

import java.io.IOException;

import parser.Parser;
import lexer.Lexer;

/**
 * 测试时请注意：无法在申明时赋值，不能识别++ --等复杂操作。
 * @author Jason
 *
 */
public class Main {
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		Parser par;
		try {
			par = new Parser(lex);
			par.program();
		} catch (IOException e) {e.printStackTrace();}
		
		System.out.write('\n');
	}
}