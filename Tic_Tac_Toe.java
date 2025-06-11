import java.awt.*;
import java.awt.event.*;
class FDemo extends Frame implements ActionListener{
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
				b1[k].addActionListener(this);
				k++;
				x+=100;
			}
			y+=100;
			x=100;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
    Button b = (Button) e.getSource(); 
	if(!b.getLabel().equals(""))return;
    if (c % 2 == 0) {
        b.setLabel("0"); 
    } else {
        b.setLabel("X"); 
    }
    c++;
	
	if(checkWinner()){
		String winner=(c%2==1)?"Player 0":"Player X";
		showDialog(winner+ " wins");
	}
}

     public boolean checkWinner(){
		 String [][]board =new String[3][3];
		 for(int i=0;i<9;i++){
			 board[i/3][i%3]=b1[i].getLabel();
		 }
		 
		 //check rows winner
		    for (int i = 0; i < 3; i++) {
		  if (!board[i][0].equals("") &&
                board[i][0].equals(board[i][1]) &&
                board[i][1].equals(board[i][2])) return true;
				
				 // Check columns
            if (!board[0][i].equals("") &&
                board[0][i].equals(board[1][i]) &&
                board[1][i].equals(board[2][i])) return true;
			}
		 
		 return false;
	 }
	 
	 public void showDialog(String message){
		   Dialog d = new Dialog(this, "Game Over", true);
        d.setLayout(new FlowLayout());
        d.setSize(250, 100);
        d.setLocation(200, 200);
        d.add(new Label(message));
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.add(ok);
        d.setVisible(true);
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
