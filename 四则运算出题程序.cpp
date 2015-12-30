
/*

*****************************************************
*           【四则运算自动出题系统】                *
*                                                   *
*                软件工程15班                       *
*                                                   *
*       组员：罗青、彭惠阳、张胜杰、谢骥。          *
*                                                   *
*****************************************************


*/


#include <iostream>
#include <cstdlib>
#include <ctime>
#include <tchar.h>
#include <stdio.h> 
#include <conio.h> 
#include <stdlib.h> 
#include <windows.h>         //各种函数所需要的头文件。

using namespace std;         //不可少的命名空间。

int a;                   //随机数1
int b;                   //随机数2
int c;                   //随机数3
int d;                   //随机数4
int e;                   //随机数5
	
int choose;              //选择。
char choose1;            //对加减乘除的选择。
char choose2;            //对难度的选择。
	
int key;                 //用户回答的答案。
int key1;                //除法中用户回答的商的余数。
int realkey;             //正确的答案。
int realkey1;            //除法中商的正确余数。
	
int judgment=1;          //判断用户是否错误的参数。
int times=0;             //错误的次数。		
int& times1=times;

//以上变量定义均在main函数以及各种函数之前，解决了各种函数中使用变量时变量还未定义的bug。初始值默认为1。

int r(int fanwei)            //生成随机数的函数。
{
	srand((unsigned)time(NULL));
	return rand()%fanwei;
}

void funGreen()              //定义一个将字体颜色改为绿色的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN);
	Sleep(400);              //延时0.7秒，修饰程序效果。
}

void funRed()                //定义一个将字体颜色改为红色的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_RED);
	Sleep(400);              //延时0.7秒，修饰程序效果。
}

void funRed1()                //定义一个将字体颜色改为红色的不延时函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_RED);          
}

void funBlue()               //定义一个将字体颜色改为浅蓝色的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_BLUE);
	Sleep(400);              //延时0.7秒，修饰程序效果。
}

void funBlue1()               //定义一个将字体颜色改为浅蓝色的不延时函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_BLUE);
}

void funYellow()             //定义一个将字体颜色改为黄色的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED);
	Sleep(400);              //延时0.7秒，修饰程序效果。
}

void funYellow1()             //定义一个将字体颜色改为黄色的不延时的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED);
}

void funfenzise()            //定义一个将字体颜色改为粉紫色的函数
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_BLUE | FOREGROUND_RED);
	Sleep(400);

}
void funWhite()             //定义一个将字体颜色改为白色的函数。
{
	HANDLE consolehwnd;      //创建句柄
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //实例化句柄
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED| FOREGROUND_BLUE);
}

void funWrong()
{
	cout<<"。";
	Sleep(400);
	cout<<"。";
	Sleep(400);
	cout<<"。";
	Sleep(400);
	cout<<"QAQ"<<endl;
	Sleep(400);
}

void funWrong1()
{
	cout<<"。";
	Sleep(400);
	cout<<"。";
	Sleep(400);
	cout<<"。";
	Sleep(400);
	cout<<"连这个都不知道么(+_+)?"<<endl; 
}

char funlevel1()             //定义一个选择加减乘除的函数，需要选择加减乘除，直接调用此即可。
{
	char A;
	a=r(10);
	b=r(15)+2;
	c=r(20)+5;
	d=r(25)+11;
	e=r(10)+23;              //五个随机数的生成。
	
	funGreen();
	cout<<"(→_→)";
	funWhite();
	cout<<"欢迎进入四则运算考试系统";
	funGreen();
	cout<<"(←_←)"<<endl;
	funWhite();
	cout<<"请选择加减乘除";
	funfenzise();
	cout<<"（注意大小写哦）"<<endl;
    funWhite();
	cout<<"A 加法 B 减法 C 乘法 D 除法"<<endl;
	cin>>A;
    return A;
}
char funlevel2()             //定义一个选择难度的函数，加减乘中需要选择难度，直接调用此即可。
{
	char B;
	cout<<"请选择难度。"<<endl;
	funGreen();
	cout<<"1 简单  ≥O≤";
	funBlue();
	cout<<"  2 一般  ⊙.⊙";
	funRed();
	cout<<"  3 困难 ( >﹏< )"<<endl;
	funBlue();
	cin>>B;
	return  B;               //将用户输入的值返回给level函数。
}

void funOver()
{
	funRed();
	cout<<"答";
	funYellow();
	cout<<"题";
	funBlue();
	cout<<"已";
	funGreen();
	cout<<"结";
	funfenzise();
	cout<<"束，";
    funRed();
	cout<<"快";
    funYellow();
	cout<<"回";
	funBlue();
	cout<<"家";
	funGreen();
	cout<<"休";
	funfenzise();
	cout<<"息";
	funRed();
	cout<<"吧。~~~"<<endl;

}

void main()                  //main函数开始啦！
{


	do
	{
		system("cls");       //清屏指令，当第二次答题时清理掉上次的记录。

		times1=0;
        
		funWhite();
		cout<<"***************************************************"<<endl;
		cout<<"*           ";
		funYellow1();
		cout<<"【四则运算自动出题系统】              ";
		funWhite();
		cout<< "*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"*                ";
		funRed1();
		cout<<"软件工程15班                     ";
		funWhite();
		cout<<"*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"*       ";
		funBlue1();
		cout<<"组员：罗青、彭惠阳、张胜杰、谢骥。        ";
		funWhite();
		cout<<"*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"***************************************************"<<endl;
		
		choose1=funlevel1(); //choose1从funlevel1得到值。
		                                                            
		switch (choose1)     //开始对加减乘除的选择。
		{
		    case'A':                                               //进入加法。
				{
				
				choose2=funlevel2();   
				
				switch (choose2)                                   //其次对难度的选择。
			       { 
				    case'1':                                       //“简单等级”选择下的加法。
						
						cout<<"请问"<<a<<"+"<<d<<"等于多少？"<<endl;
						realkey=a+d;
					    cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;

					case'2':                                       //“一般等级”选择下的加法。
						
						cout<<"请问"<<a<<"+"<<b<<"+"<<c<<"等于多少？"<<endl;
						realkey=a+b+c;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;

					case'3':                                       //“困难等级”选择下的加法。
						
						cout<<"请问"<<a<<"+"<<b<<"+"<<c<<"+"<<d<<"+"<<e<<"等于多少？"<<endl;
						realkey=a+b+c+d+e;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;
					default:                                       //输入错误的情况。
						
						judgment=0;                                //输入有误时，另判断值为0，以防进入“回答正确”时的语句。
						funWrong();
						funRed();
						cout<<"输入有误！！！"<<endl;
						funBlue();
						
				    }
				break;
				}
				

		    case'B':                                               //进入减法。
				{
	     		choose2=funlevel2();   

				switch (choose2)
			       { 
				    case'1':                                       //“简单等级”选择下的减法。
						
						cout<<"请问49-"<<a<<"-"<<b<<"等于多少？"<<endl;
						realkey=49-a-b;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;
					case'2':                                       //“一般等级”选择下的减法。
						
						cout<<"请问78-"<<a<<"-"<<b<<"-"<<c<<"等于多少？"<<endl;
						realkey=78-a-b-c;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;
					case'3':                                       //“困难等级”选择下的减法。
						
						cout<<"请问123-"<<a<<"-"<<b<<"-"<<c<<"-"<<d<<"-"<<e<<"等于多少？"<<endl;
						realkey=123-a-b-c-d-e;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;
					default:                                       //输入错误的情况。
						judgment=0;                                //输入有误时，另判断值为0，以防进入“回答正确”时的语句。
						funWrong();
						funRed();
						cout<<"输入有误！！！"<<endl;
						funBlue(); 
				    }	
				break;
				}
				

			case'C':                                               //进入乘法。
				{
				choose2=funlevel2();   
				
				switch (choose2)
			       { 
				    case'1':                                       //“简单等级”选择下的乘法。
						
						cout<<"请问"<<a<<"*"<<b<<"等于多少？"<<endl;
						realkey=a*b;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;

					case'2':                                       //“一般等级”选择下的乘法。
						
						cout<<"请问"<<a<<"*"<<b<<"*"<<c<<"等于多少？"<<endl;
						realkey=a*b*c;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;

					case'3':                                       //“困难等级”选择下的乘法。
						
						cout<<"请问"<<a<<"*"<<b<<"*"<<c<<"*"<<d<<"*"<<e<<"等于多少？"<<endl;
						realkey=a*b*c*d*e;
						cout<<"请输入你的答案。"<<endl;
		                cin>>key;
						
						break;
					default:                                       //输入错误的情况。
						judgment=0;                                //输入有误时，另判断值为0，以防进入“回答正确”时的语句。
						funRed();
						funWrong();
						cout<<"输入有误！！！"<<endl;
						funBlue();
				    }
				break;
				}
				
			case'D':                                               //进入除法。
				cout<<"请问"<<d<<"/"<<a<<"等于多少？"<<endl;
				cout<<"请问商和余数。"<<endl;
				realkey=d/a;	
				realkey1=d%a;
				cin>>key>>key1;
				
				break;


			default:                                               //输入错误的情况。
				judgment=0;                                        //输入有误时，另判断值为0，以防进入“回答正确”时的语句。
				funWrong();
				funRed();                                          
				cout<<"输入有误！！！"<<endl;
				funBlue();
		}
		
		while(realkey!=key||realkey1!=key1)                        //答案错误时进入。(由于加减乘里不需要用到realkey1和key1，所以在main函数之外定义，初始值都为1，一定相等，
		{                                                          //不要考虑，但是当除法时需要用到商和余数的两次判断，才发挥作用。此处修复了除法中判断正误只依靠商是否对的bug）
			funRed();
			cout<<"答案错误！请再次输入！"<<endl;
			funBlue();
			cin>>key;
			times++;                                               //循环记录错误次数。
			if(times>=3)                                           //错误三次时使用break跳出循环，从而达到错3次便要询问是否继续的效果。
			{
			    funWrong1();		
				funGreen();
				cout<<"正确答案是"<<realkey<<"啊！"<<endl; 
				funBlue();
				break;			
			}
		}

		if(realkey==key&&judgment==1)                              //答案正确时进入。（如果前面输入有误，则judgment赋值为0，修复了输入有误也可以回答正确的bug。）
		{
			funGreen();
			cout<<"恭喜你，答案正确！o(≥v≤)o ~~~~~ "<<endl;
			funBlue();
		}
        
		funBlue();
		cout<<"请问你是否继续？ "<<endl;                            //询问是否继续。
		cout<<"1:是。 〒_〒     2:否。 ╰_╯ "<<endl;
		cin>>choose;
				
	}
	while(choose==1);                                              //do while是包括题目的大循环，当回答否（2）时才可跳出结束答题大循环。
   
	funOver();
}