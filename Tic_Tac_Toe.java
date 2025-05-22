import java.awt.*;
import java.awt.event.*;
class FDemo extends Frame{
	Button b1[]=new Button[9];
	int x=100,y=100;
	int c=1;
	FDemo(){
		Font f=new Font(" ",Font.ITALIC,30);
		setFont(f);
		setLayout(null);
		int k=0;
		for(int i=1;i<=3;i++){
			for(int j=1;j<=3;j++){
				b1[k]=new Button();
				b1[k].setSize(100,100);
				b1[k].setLocation(x,y);
				add(b1[k]);
				k++;
				x+=100;
			}
			y+=100;
			x=100;
		}
	}
	
}

class Tic_Tac_Toe{
	public static void main(String ar[]){
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setLocation(200,200);
		f.setSize(500,600);
		// f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
