一、 填空题（20 分=2 分×10 题）

1.	表达式 125&10 的值是8_，表达式 125 | 10 的值是_127_。
    &同1为1，否则为0，|同0为0 否则为1
125: 1111 1100   125&10=0000 1000=8
10 ：0000 1010   125|10=1111 1110=127
2.	设 char ch 表示 16 进制的一个数字字符，获得 ch 对应整数值的条件表达式是。

3.	设 byte b=127;，表达式 b+"+1="+(++b)的运算结果是127+1=-128_。

4.	设 String str="Hello"，通过求子串使 str 值变为"elloH"，则需执行语句是_str=substring(1)+substring(0,1)_。

5.	以下声明，编译后生成的文件名是_Pixel.class、Pixel$ColorConstant.class_和Pixel$Color.class__。

public class Pixel

{public static interface ColorConstant

public static class Color extends Object implements ColorConstant

}

6. 以下声明有什么错误？为什么？。

public class MyString extends java.lang.String
        java.lang.string不能声明子类，因为他是最终类，最终类不能被继承

7.	获得当前日期月份的语句是。

8.	下列语句的执行结果是。

    System.out.println(new javax.swing.JButton().getClass().getSuperClass().getPackage().getName());
    答：java.swing.

9.	javax.swing.JComponent 声明继承_java.awt.container类（写出包名），作用是_。

10.	调用__Thread.sleep(1000)___方法（包含类名）可使线程暂停运行 1 秒，该方法抛出__中断InteruptedException_________异常。

二、 问答题（30 分=5 分×6 题）

1.	在什么情况下需要使用“super 引用”？举例说明。

2.	举例说明 Java 声明了哪些接口，各起什么作用。

3.	JTextField 能够响应 java.awt.event.ActionEvent 和 javax.swing.event.CaretEvent 事件，两事件触发条

件有什么不同？需要同时响应两者吗？

4.	什么是交互线程？什么是线程互斥与同步？说明线程互斥与同步机制怎样保证交互线程对共享变

量操作的正确性，不产生与时间有关的错误。

5. 已知数据字节流能够读写字符，DataInputStream 和 DataOutputStream 类分别声明以下方法：

public final char readChar() throws IOException	//读取 Unicode 字符，2 字节

- 1 -
 
public final void writeChar(int value) throws IOException	//写入 Unicode 字符，2 字节

public final void writeChars(String s) throws IOException	//写入字符串

那么，Java 为什么还要声明字符流？字符流与字节流是什么关系？

6.	什么是 Socket，作用是什么？什么是 Socket 通信？TCP Socket 和 UDP Socket 通信各有什么特点？
各采用什么方式传输数据？Java 是如何实现 TCP Socket 和 UDP Socket 通信的？（64 学时）

三、 程序阅读、改错和填空题（20 分=5 分×4 题）

1.	以下声明 Point 坐标点类和 Pixel 像素类，有什么错误？为什么？如何改正？

public class Point	//坐标点类	import java.awt.Color;	
{		//像素类，继承 Point 类。像素是一个带颜色的坐标点
private int x,y;	//点的坐标	public class Pixel extends Point	
public Point(int x,int y)		{		
{this.x = x;		private Color color;	//像素颜色
this.y = y;		public Pixel(int x, int y, Color color)	
}		{	super(x,y);	
}			this.color = color;	
		}		
		public Pixel(Point p, Color color)	
		{	this(p.x, p.y, color);	
		}		
		public Pixel()	
		{	this.color = new Color(0,0,0);	
		}		
		}		

2. 已知 Point 和 Polygon 类声明如下：

public class Point	//坐标点类

{	private int x,y;	//点的坐标

}

public class Polygon	//凸多边形类

{

private Point points[];	//多边形的各点坐标，边数为数组长度

//比较 this 与 obj 对象是否相等，约定相等条件是多边形的各点对应相等

public boolean equals(Object obj)

{

if (this==obj)

return true;

if (obj instanceof Polygon)

{Polygon poly=(Polygon)obj;

for (int i=0; i<poly.points.length; i++)

if (this.points[i].equals(poly.points[i]))

return false;

return true;

}

return false;

}

}

问题：① this==obj 表示什么含义？说明各种情况及其返回值。

②	obj instanceof Polygon 表示什么含义？返回值类型是什么？

③ (Polygon)obj 会抛出强制类型转换异常吗？为什么？

④ this.points[i].equals(poly.points[i])调用的是 Point 类的 equals()方法。但上述 Point 类并没
 

- 2 - 
有声明 equals()方法，为什么能够调用？此时，Point 类的 equals()方法体是怎样的？执行什么操作？是否符合 Point 类的需要？

⑤	Point 类希望 equals()方法比较 this 和 obj 对象分别引用实例的各成员变量是否对应相等。写出该方法实现。
该方法与 Object 类的 equals(obj)方法是什么关系？

3. 已知

public interface Perimeter	//可计算周长接口

{	public abstract double perimeter();	//抽象方法，计算周长

}

public class Point	//点类

public abstract class Figure	//图形抽象类

public class Line extends Figure	//直线类

public abstract class ClosedFigure extends Figure implements Area, Perimeter	//闭合图形抽象类

public class Triangle extends ClosedFigure	//三角形类

问题：① 以下声明对象 per 的各句是否正确？若有错误，说明有什么错误？为什么？

Point p1=new Point(100,100), p2=new Point(100,130), p3=new Point(140,130);

Perimeter per = new Perimeter();

per = new Line(p1, p2);

per = new ClosedFigure(p1);

per = new Triangle(p1, p2, p3);

System.out.println(per.toString()+"，周长"+String.format("%1.2f", per.perimeter()));

② 上述语句中，per.perimeter()执行的是哪个类的方法？为什么？

4.	以下发送线程使用数据字节流向管道字节流写入 int 整数，填空。

import java.io.*;

public class IntSender extends Thread	//发送线程

{

private PipedOutputStream out;

private int min, max;

public IntSender(PipedOutputStream out, int min, int max)

{

this.out = out;

this.min = min;

this.max = max;

}

public IntSender(PipedOutputStream out)

{this(out,1,10);

}

_______________________________________________________________

{

try

{DataOutputStream dout = _____________________________________

for (int i=min; i<=this.max; i++)

_____________________________________	//向数据流写入 i

dout.close();

________________________________________

}

________________________________________

{	e.printStackTrace();

}

}

 
}

