
/*

*****************************************************
*           �����������Զ�����ϵͳ��                *
*                                                   *
*                �������15��                       *
*                                                   *
*       ��Ա�����ࡢ���������ʤ�ܡ�л����          *
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
#include <windows.h>         //���ֺ�������Ҫ��ͷ�ļ���

using namespace std;         //�����ٵ������ռ䡣

int a;                   //�����1
int b;                   //�����2
int c;                   //�����3
int d;                   //�����4
int e;                   //�����5
	
int choose;              //ѡ��
char choose1;            //�ԼӼ��˳���ѡ��
char choose2;            //���Ѷȵ�ѡ��
	
int key;                 //�û��ش�Ĵ𰸡�
int key1;                //�������û��ش���̵�������
int realkey;             //��ȷ�Ĵ𰸡�
int realkey1;            //�������̵���ȷ������
	
int judgment=1;          //�ж��û��Ƿ����Ĳ�����
int times=0;             //����Ĵ�����		
int& times1=times;

//���ϱ����������main�����Լ����ֺ���֮ǰ������˸��ֺ�����ʹ�ñ���ʱ������δ�����bug����ʼֵĬ��Ϊ1��

int r(int fanwei)            //����������ĺ�����
{
	srand((unsigned)time(NULL));
	return rand()%fanwei;
}

void funGreen()              //����һ����������ɫ��Ϊ��ɫ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN);
	Sleep(400);              //��ʱ0.7�룬���γ���Ч����
}

void funRed()                //����һ����������ɫ��Ϊ��ɫ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_RED);
	Sleep(400);              //��ʱ0.7�룬���γ���Ч����
}

void funRed1()                //����һ����������ɫ��Ϊ��ɫ�Ĳ���ʱ������
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_RED);          
}

void funBlue()               //����һ����������ɫ��Ϊǳ��ɫ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_BLUE);
	Sleep(400);              //��ʱ0.7�룬���γ���Ч����
}

void funBlue1()               //����һ����������ɫ��Ϊǳ��ɫ�Ĳ���ʱ������
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_BLUE);
}

void funYellow()             //����һ����������ɫ��Ϊ��ɫ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED);
	Sleep(400);              //��ʱ0.7�룬���γ���Ч����
}

void funYellow1()             //����һ����������ɫ��Ϊ��ɫ�Ĳ���ʱ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED);
}

void funfenzise()            //����һ����������ɫ��Ϊ����ɫ�ĺ���
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_BLUE | FOREGROUND_RED);
	Sleep(400);

}
void funWhite()             //����һ����������ɫ��Ϊ��ɫ�ĺ�����
{
	HANDLE consolehwnd;      //�������
	consolehwnd = GetStdHandle(STD_OUTPUT_HANDLE); //ʵ�������
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY );
	SetConsoleTextAttribute(consolehwnd, FOREGROUND_INTENSITY | FOREGROUND_GREEN | FOREGROUND_RED| FOREGROUND_BLUE);
}

void funWrong()
{
	cout<<"��";
	Sleep(400);
	cout<<"��";
	Sleep(400);
	cout<<"��";
	Sleep(400);
	cout<<"QAQ"<<endl;
	Sleep(400);
}

void funWrong1()
{
	cout<<"��";
	Sleep(400);
	cout<<"��";
	Sleep(400);
	cout<<"��";
	Sleep(400);
	cout<<"���������֪��ô(+_+)?"<<endl; 
}

char funlevel1()             //����һ��ѡ��Ӽ��˳��ĺ�������Ҫѡ��Ӽ��˳���ֱ�ӵ��ô˼��ɡ�
{
	char A;
	a=r(10);
	b=r(15)+2;
	c=r(20)+5;
	d=r(25)+11;
	e=r(10)+23;              //�������������ɡ�
	
	funGreen();
	cout<<"(��_��)";
	funWhite();
	cout<<"��ӭ�����������㿼��ϵͳ";
	funGreen();
	cout<<"(��_��)"<<endl;
	funWhite();
	cout<<"��ѡ��Ӽ��˳�";
	funfenzise();
	cout<<"��ע���СдŶ��"<<endl;
    funWhite();
	cout<<"A �ӷ� B ���� C �˷� D ����"<<endl;
	cin>>A;
    return A;
}
char funlevel2()             //����һ��ѡ���Ѷȵĺ������Ӽ�������Ҫѡ���Ѷȣ�ֱ�ӵ��ô˼��ɡ�
{
	char B;
	cout<<"��ѡ���Ѷȡ�"<<endl;
	funGreen();
	cout<<"1 ��  ��O��";
	funBlue();
	cout<<"  2 һ��  ��.��";
	funRed();
	cout<<"  3 ���� ( >�n< )"<<endl;
	funBlue();
	cin>>B;
	return  B;               //���û������ֵ���ظ�level������
}

void funOver()
{
	funRed();
	cout<<"��";
	funYellow();
	cout<<"��";
	funBlue();
	cout<<"��";
	funGreen();
	cout<<"��";
	funfenzise();
	cout<<"����";
    funRed();
	cout<<"��";
    funYellow();
	cout<<"��";
	funBlue();
	cout<<"��";
	funGreen();
	cout<<"��";
	funfenzise();
	cout<<"Ϣ";
	funRed();
	cout<<"�ɡ�~~~"<<endl;

}

void main()                  //main������ʼ����
{


	do
	{
		system("cls");       //����ָ����ڶ��δ���ʱ������ϴεļ�¼��

		times1=0;
        
		funWhite();
		cout<<"***************************************************"<<endl;
		cout<<"*           ";
		funYellow1();
		cout<<"�����������Զ�����ϵͳ��              ";
		funWhite();
		cout<< "*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"*                ";
		funRed1();
		cout<<"�������15��                     ";
		funWhite();
		cout<<"*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"*       ";
		funBlue1();
		cout<<"��Ա�����ࡢ���������ʤ�ܡ�л����        ";
		funWhite();
		cout<<"*"<<endl;
		cout<<"*                                                 *"<<endl;
		cout<<"***************************************************"<<endl;
		
		choose1=funlevel1(); //choose1��funlevel1�õ�ֵ��
		                                                            
		switch (choose1)     //��ʼ�ԼӼ��˳���ѡ��
		{
		    case'A':                                               //����ӷ���
				{
				
				choose2=funlevel2();   
				
				switch (choose2)                                   //��ζ��Ѷȵ�ѡ��
			       { 
				    case'1':                                       //���򵥵ȼ���ѡ���µļӷ���
						
						cout<<"����"<<a<<"+"<<d<<"���ڶ��٣�"<<endl;
						realkey=a+d;
					    cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;

					case'2':                                       //��һ��ȼ���ѡ���µļӷ���
						
						cout<<"����"<<a<<"+"<<b<<"+"<<c<<"���ڶ��٣�"<<endl;
						realkey=a+b+c;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;

					case'3':                                       //�����ѵȼ���ѡ���µļӷ���
						
						cout<<"����"<<a<<"+"<<b<<"+"<<c<<"+"<<d<<"+"<<e<<"���ڶ��٣�"<<endl;
						realkey=a+b+c+d+e;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;
					default:                                       //�������������
						
						judgment=0;                                //��������ʱ�����ж�ֵΪ0���Է����롰�ش���ȷ��ʱ����䡣
						funWrong();
						funRed();
						cout<<"�������󣡣���"<<endl;
						funBlue();
						
				    }
				break;
				}
				

		    case'B':                                               //���������
				{
	     		choose2=funlevel2();   

				switch (choose2)
			       { 
				    case'1':                                       //���򵥵ȼ���ѡ���µļ�����
						
						cout<<"����49-"<<a<<"-"<<b<<"���ڶ��٣�"<<endl;
						realkey=49-a-b;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;
					case'2':                                       //��һ��ȼ���ѡ���µļ�����
						
						cout<<"����78-"<<a<<"-"<<b<<"-"<<c<<"���ڶ��٣�"<<endl;
						realkey=78-a-b-c;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;
					case'3':                                       //�����ѵȼ���ѡ���µļ�����
						
						cout<<"����123-"<<a<<"-"<<b<<"-"<<c<<"-"<<d<<"-"<<e<<"���ڶ��٣�"<<endl;
						realkey=123-a-b-c-d-e;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;
					default:                                       //�������������
						judgment=0;                                //��������ʱ�����ж�ֵΪ0���Է����롰�ش���ȷ��ʱ����䡣
						funWrong();
						funRed();
						cout<<"�������󣡣���"<<endl;
						funBlue(); 
				    }	
				break;
				}
				

			case'C':                                               //����˷���
				{
				choose2=funlevel2();   
				
				switch (choose2)
			       { 
				    case'1':                                       //���򵥵ȼ���ѡ���µĳ˷���
						
						cout<<"����"<<a<<"*"<<b<<"���ڶ��٣�"<<endl;
						realkey=a*b;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;

					case'2':                                       //��һ��ȼ���ѡ���µĳ˷���
						
						cout<<"����"<<a<<"*"<<b<<"*"<<c<<"���ڶ��٣�"<<endl;
						realkey=a*b*c;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;

					case'3':                                       //�����ѵȼ���ѡ���µĳ˷���
						
						cout<<"����"<<a<<"*"<<b<<"*"<<c<<"*"<<d<<"*"<<e<<"���ڶ��٣�"<<endl;
						realkey=a*b*c*d*e;
						cout<<"��������Ĵ𰸡�"<<endl;
		                cin>>key;
						
						break;
					default:                                       //�������������
						judgment=0;                                //��������ʱ�����ж�ֵΪ0���Է����롰�ش���ȷ��ʱ����䡣
						funRed();
						funWrong();
						cout<<"�������󣡣���"<<endl;
						funBlue();
				    }
				break;
				}
				
			case'D':                                               //���������
				cout<<"����"<<d<<"/"<<a<<"���ڶ��٣�"<<endl;
				cout<<"�����̺�������"<<endl;
				realkey=d/a;	
				realkey1=d%a;
				cin>>key>>key1;
				
				break;


			default:                                               //�������������
				judgment=0;                                        //��������ʱ�����ж�ֵΪ0���Է����롰�ش���ȷ��ʱ����䡣
				funWrong();
				funRed();                                          
				cout<<"�������󣡣���"<<endl;
				funBlue();
		}
		
		while(realkey!=key||realkey1!=key1)                        //�𰸴���ʱ���롣(���ڼӼ����ﲻ��Ҫ�õ�realkey1��key1��������main����֮�ⶨ�壬��ʼֵ��Ϊ1��һ����ȣ�
		{                                                          //��Ҫ���ǣ����ǵ�����ʱ��Ҫ�õ��̺������������жϣ��ŷ������á��˴��޸��˳������ж�����ֻ�������Ƿ�Ե�bug��
			funRed();
			cout<<"�𰸴������ٴ����룡"<<endl;
			funBlue();
			cin>>key;
			times++;                                               //ѭ����¼���������
			if(times>=3)                                           //��������ʱʹ��break����ѭ�����Ӷ��ﵽ��3�α�Ҫѯ���Ƿ������Ч����
			{
			    funWrong1();		
				funGreen();
				cout<<"��ȷ����"<<realkey<<"����"<<endl; 
				funBlue();
				break;			
			}
		}

		if(realkey==key&&judgment==1)                              //����ȷʱ���롣�����ǰ������������judgment��ֵΪ0���޸�����������Ҳ���Իش���ȷ��bug����
		{
			funGreen();
			cout<<"��ϲ�㣬����ȷ��o(��v��)o ~~~~~ "<<endl;
			funBlue();
		}
        
		funBlue();
		cout<<"�������Ƿ������ "<<endl;                            //ѯ���Ƿ������
		cout<<"1:�ǡ� ��_��     2:�� �t_�s "<<endl;
		cin>>choose;
				
	}
	while(choose==1);                                              //do while�ǰ�����Ŀ�Ĵ�ѭ�������ش��2��ʱ�ſ��������������ѭ����
   
	funOver();
}