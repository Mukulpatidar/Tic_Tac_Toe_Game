import java.awt.*;
import java.awt.event.*;
class FDemo extends Frame implements ActionListener{
	Button b1[]=new Button[9];
	Button restart;
	int turn=1;
	int x=40,y=60;
	int c=1;
	FDemo(){
		Font f=new Font(" ",Font.ITALIC,30);
		
		setFont(f);
		setLayout(null);
		  setBackground(new Color(240, 248, 255)); 
		
		int k=0;
		for(int i=1;i<=3;i++){
			for(int j=1;j<=3;j++){
				b1[k]=new Button();
				 b1[k].setFont(new Font("Arial", Font.BOLD, 30));
                b1[k].setBackground(Color.WHITE);
                b1[k].setForeground(Color.DARK_GRAY);
				b1[k].setSize(100,100);
				b1[k].setLocation(x,y);
				add(b1[k]);
				b1[k].addActionListener(this);
				k++;
				x+=100;
			}
			y+=100;
			x=40;
		}
		
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	});
	
	
	 restart = new Button("Restart");
        restart.setFont(new Font("Arial", Font.BOLD, 20));
		restart.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        restart.setForeground(Color.WHITE);
        restart.setBounds(100, 370, 200, 50);
		restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               resetGame();
            }
        });
        add(restart);
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
		disableButtons();
	}else if(isBoardFull()){
		 showDialog("It's a Tie!");
	}
}


      public boolean isBoardFull(){
		   for (Button button : b1) {
            if (button.getLabel().equals("")) return false;
        }
        return true;
	  }
	  
	    public void disableButtons() {
        for (int i = 0; i < 9; i++) {
            b1[i].setEnabled(false);
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
			
			 // Check diagonals
        if (!board[0][0].equals("") &&
            board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2])) return true;

        if (!board[0][2].equals("") &&
            board[0][2].equals(board[1][1]) &&
            board[1][1].equals(board[2][0])) return true;
		 
		 return false;
	 }
	 
	 public void showDialog(String message){
		   Dialog d = new Dialog(this, "Game Over", true);
        d.setLayout(new FlowLayout());
        d.setSize(250, 100);
        d.setLocationRelativeTo(this);
        d.add(new Label(message));
        Button ok = new Button("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.add(ok);
		
		 d.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            d.setVisible(false);
        }
    });
        d.setVisible(true);
	 }
	 
	 
	  public void resetGame() {
        for (int i = 0; i < 9; i++) {
            b1[i].setLabel("");
            b1[i].setEnabled(true);
        }
        turn = 1;
    }

	
}

class Tic_Tac_Toe{
	public static void main(String ar[]){
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setLocation(200,200);
		f.setSize(380,430);
		f.setResizable(false);
		f.setTitle("Tic Tac Toe - AWT Game");
		f.setLocationRelativeTo(null); // Center the window

		
	}
}
