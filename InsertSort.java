import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
import java.io.*;
import java.util.Random;
class Canvas extends JComponent{
	public int height;
	public int x=50;
	public int y=50;
	public Canvas(){
		super();
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setPaint(Color.GREEN);
		int maxSize=20;
		ArrayIns arr;
		arr=new ArrayIns(maxSize,g2d);
		arr.insertionSort(g2d);
		//super.repaint();
}
}
class Rect
{
	public int x;
	public int height;
	public Rect(int num,int heightP)
	{
		x=num;
		height=heightP;
	}
	public void FillRect(Graphics2D g2d,int y)
	{
		g2d.fillRect(x,y,15,height);
		
	}
}
class ArrayIns
{
	private long[]a;
	private int nElems;
	public Rect[] rect;
	Random rand=new Random();
	public int heightP;
	public ArrayIns(int max,Graphics2D g2d)
	{
		nElems=max;
		rect=new Rect[nElems];
		a=new long[nElems];
		
		int x=100;
		for(int i=0;i<nElems;i++)
		{
			heightP=rand.nextInt(100);
			System.out.print(heightP+ " ");
			rect[i]=new Rect(x,heightP);
			rect[i].FillRect(g2d,100);
			x+=1000/nElems;
		}
	}
	public void display()
	{
		for(int j=0;j<nElems;j++)
		{
			System.out.print(a[j]+" ");
		}
		System.out.println("");
	}
	public void insertionSort(Graphics2D g2d)
	{
		int in,out;
		Rect temp;
		for(out=1;out<nElems;out++)
		{
			temp=rect[out];
			//temp.height=rect[out].height;
			//temp.x=rect[out].x;
			in=out;
			while(in>0 && rect[in-1].height>=temp.height)
			{
				rect[in].height=rect[in-1].height;
				rect[in].x=rect[in-1].x;
				--in;
			}
		//rect[in]=temp;
		rect[in].height=temp.height;
		rect[in].x=temp.x;
		}
		for(int i=0;i<nElems;i++)
		{
			rect[i].FillRect(g2d,200);
		}
	}
}

class insertSort
{
	public static void main(String[] args)
	{
		
		
		JFrame w=new JFrame("MY window");
		w.setSize(1000,1000);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setLayout(new BorderLayout(1,1));
		Canvas canv=new Canvas();
		w.add(canv);
		w.setVisible(true);
	}
}
	