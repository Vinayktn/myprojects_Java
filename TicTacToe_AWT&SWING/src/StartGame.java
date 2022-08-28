
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartGame implements ActionListener
{
    JFrame jf;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
    
    String str="";
    int count=0;
    //boolean jb3_enabled=true;
    
    boolean wins=false;
    
    void gameDesign()
    {
        jf=new JFrame("TicTacToe Game by Deepak");
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3, 3));
        
        jb1=new JButton();
        jb1.addActionListener(this);
        jf.add(jb1);
        
        jb2=new JButton();
        jb2.addActionListener(this);
        jf.add(jb2);
        
        jb3=new JButton();
        jb3.addActionListener(this);
        jf.add(jb3);
        
        jb4=new JButton();
        jb4.addActionListener(this);
        jf.add(jb4);
        
        jb5=new JButton();
        jb5.addActionListener(this);
        jf.add(jb5);
        
        jb6=new JButton();
        jb6.addActionListener(this);
        jf.add(jb6);
        
        jb7=new JButton();
        jb7.addActionListener(this);
        jf.add(jb7);
        
        jb8=new JButton();
        jb8.addActionListener(this);
        jf.add(jb8);
        
        jb9=new JButton();
        jb9.addActionListener(this);
        jf.add(jb9);
        
        jf.setVisible(true);
    }



	public static void main(String[] args) {
		StartGame sg=new StartGame();
        sg.gameDesign();
	}
	void setBtnStr()
    {
        count=count+1;
        if(count%2==0)
        {
            str="O";
        }
        else
        {
            str="X";
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton btn=(JButton)e.getSource();
        if(btn != null)
        {
            setBtnStr();
            btn.setFont(new Font("Arial", 1, 50));
            btn.setText(str);
            btn.setEnabled(false);
        }
        
        winningPossibilities();
        whoWins();
        
//        if(e.getSource()==jb1 && jb1.getText().equals(""))
//        {
//            setBtnStr();
//            jb1.setFont(new Font("Arial", 1, 50));
//            jb1.setText(str);
//        }
//        if(e.getSource()==jb2 && jb2.getText().equals(""))
//        {
//            setBtnStr();
//            jb2.setFont(new Font("Arial", 1, 50));
//            jb2.setText(str);
//        }
//        if(e.getSource()==jb3 && jb3_enabled==true)
//        {
//            setBtnStr();
//            jb3.setFont(new Font("Arial", 1, 50));
//            jb3.setText(str);
//            jb3_enabled=false;
//        }
//        if(e.getSource()==jb4)
//        {
//            jb4.setFont(new Font("Arial", 1, 50));
//            jb4.setText(str);
//        }
//        if(e.getSource()==jb5)
//        {
//            jb5.setFont(new Font("Arial", 1, 50));
//            jb5.setText(str);
//        }
//        if(e.getSource()==jb6)
//        {
//            jb6.setFont(new Font("Arial", 1, 50));
//            jb6.setText(str);
//        }
//        if(e.getSource()==jb7)
//        {
//            jb7.setFont(new Font("Arial", 1, 50));
//            jb7.setText(str);
//        }
//        if(e.getSource()==jb8)
//        {
//            jb8.setFont(new Font("Arial", 1, 50));
//            jb8.setText(str);
//        }
//        if(e.getSource()==jb9)
//        {
//            jb9.setFont(new Font("Arial", 1, 50));
//            jb9.setText(str);
//        }
    }
    
    void winningPossibilities()
    {
        //horizontally
        if(jb1.getText()==jb2.getText() && jb2.getText()==jb3.getText() && jb1.getText() != "")
        {
            wins=true;
        }
        else if(jb4.getText()==jb5.getText() && jb5.getText()==jb6.getText() && jb6.getText() != "")
        {
            wins=true;
        }
        else if(jb7.getText()==jb8.getText() && jb8.getText()==jb9.getText() && jb9.getText() != "")
        {
            wins=true;
        }
        //vertically
        else if(jb1.getText()==jb4.getText() && jb4.getText()==jb7.getText() && jb7.getText() != "")
        {
            wins=true;
        }
        else if(jb2.getText()==jb5.getText() && jb5.getText()==jb8.getText() && jb8.getText() != "")
        {
            wins=true;
        }
        else if(jb3.getText()==jb6.getText() && jb6.getText()==jb9.getText() && jb6.getText() != "")
        {
            wins=true;
        }
        //diagonal
        else if(jb1.getText()==jb5.getText() && jb5.getText()==jb9.getText() && jb9.getText() != "")
        {
            wins=true;
        }
        else if(jb3.getText()==jb5.getText() && jb5.getText()==jb7.getText() && jb7.getText() != "")
        {
            wins=true;
        }
        else
        {
            wins=false;
        }
    }
    
    void whoWins()
    {
        if(wins==true)
        {
            JOptionPane.showMessageDialog(jf, str+" wins");
            restartGame();
        }
        else if(count==9)
        {
            JOptionPane.showMessageDialog(jf, "Match Draw");
            restartGame();
        }
    }
    void restartGame()
    {
        int i=JOptionPane.showConfirmDialog(jf, "Do you want to continue the game ?");
        if(i==0)
        {
            jb1.setText("");
            jb2.setText("");
            jb3.setText("");
            jb4.setText("");
            jb5.setText("");
            jb6.setText("");
            jb7.setText("");
            jb8.setText("");
            jb9.setText("");
            
            setBtnEnabled(true);
            
            count=0;
            str="";
            wins=false;
        }
        else if(i==1)
        {
            System.exit(0);
        }
        else
        {
            setBtnEnabled(false);
        }
    }
    
    void setBtnEnabled(boolean b)
    {
        jb1.setEnabled(b);
        jb2.setEnabled(b);
        jb3.setEnabled(b);
        jb4.setEnabled(b);
        jb5.setEnabled(b);
        jb6.setEnabled(b);
        jb7.setEnabled(b);
        jb8.setEnabled(b);
        jb9.setEnabled(b);
    }
}
