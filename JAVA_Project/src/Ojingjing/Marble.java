package Ojingjing;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MarbleEx extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/marble_ex.png").getImage();

	MarbleEx() {
		homeframe();
		btn_start();
	}
	
	static JButton btn_start = new JButton();
	
	public void btn_start() { //버튼 2
		btn_start.setLayout(null);
		btn_start.setBounds(690, 712, 150, 90);
		btn_start.setBackground(Color.WHITE);
		btn_start.setText("다음");
		btn_start.setFont(btn_start.getFont().deriveFont(30.0f));
		btn_start.setForeground(Color.BLACK);
		btn_start.setBorderPainted(false); //외곽선 없애주기
		btn_start.setFocusPainted(false);	//버튼 선택되었을 때 생기는 테두리 안함
		add(btn_start);
		
		btn_start.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e) { 
	        	setVisible(false);
	        	new MarbleFrame();
	        }  
	    });
	}
	
	public void homeframe() {
		setTitle("딱지치기 설명"); //프레임 제목
		setSize(1600, 925); //프레임 크기
		setResizable(false); //창 크기 변경 금지
		setLocationRelativeTo(null); //창 가운데 나오게
		setLayout(null);
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 정상적으로 종료
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, 1600, 900, null);
	}
}

class MarbleFrame extends JFrame{
   private Image background = new ImageIcon("src/image/marblebackground.png").getImage();
   JLabel main_Label = new JLabel();
   JButton btn_hand = new JButton();
   JButton marble_1 = new JButton();
   JButton marble_2 = new JButton();
   JButton marble_3 = new JButton();
   JButton marble_4 = new JButton();
   JButton marble_5 = new JButton();
   JButton marble_6 = new JButton();
   JButton marble_7 = new JButton();
   JButton marble_8 = new JButton();
   JButton marble_9 = new JButton();
   JButton marble_10 = new JButton();
   
   private static Image hand1 = new ImageIcon("src/image/hand1.png").getImage();
   ImageIcon hand2 = new ImageIcon("src/image/hand2.png");
   ImageIcon marble1 = new ImageIcon("src/image/marble_1.png");
   ImageIcon marble2 = new ImageIcon("src/image/marble_2.png");
   ImageIcon marble3 = new ImageIcon("src/image/marble_3.png");
   ImageIcon marble4 = new ImageIcon("src/image/marble_4.png");
   ImageIcon marble5 = new ImageIcon("src/image/marble_5.png");
   ImageIcon marble6 = new ImageIcon("src/image/marble_6.png");
   ImageIcon marble7 = new ImageIcon("src/image/marble_7.png");
   ImageIcon marble8 = new ImageIcon("src/image/marble_8.png");
   ImageIcon marble9 = new ImageIcon("src/image/marble_9.png");
   ImageIcon marble10 = new ImageIcon("src/image/marble_10.png");

   private Clip clip;
   public MarbleFrame() {
      //playSound("src/audio/marble.wav",false);
      frame(); //배경
      ff();
   }
   
   public void playSound(String pathName, boolean isLoop) {
	   try {
		   clip = AudioSystem.getClip();
		   File audioFile = new File(pathName);
		   AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		   clip.open(audioStream);
		   clip.start();
		   if(isLoop)
			   clip.loop(Clip.LOOP_CONTINUOUSLY);
	   }catch(LineUnavailableException e) {
		   e.printStackTrace();
	   }catch(UnsupportedAudioFileException e) {
		   e.printStackTrace();
	   }catch(IOException e) {
		   e.printStackTrace();
	   }
   }
   
   public void btn_hand() {
      btn_hand.setLayout(null);
      btn_hand.setBounds(340, 115, 516, 610);
      btn_hand.setBorderPainted(false);
      btn_hand.setFocusPainted(false);  
      
      add(btn_hand);
      btn_hand.setIcon(hand2);
   }
   public void marble_1() {
      marble_1.setLayout(null);
      marble_1.setBounds(340, 115, 516, 610);
      marble_1.setOpaque(false);
      marble_1.setBorderPainted(false);
      marble_1.setFocusPainted(false);  
      
      add(marble_1);
      marble_1.setIcon(marble1);
   }
   
   public void marble_2() {
      marble_2.setLayout(null);
      marble_2.setBounds(340, 115, 516, 610);
      marble_2.setBorderPainted(false);
      marble_2.setFocusPainted(false);  
      
      add(marble_2);
      marble_2.setIcon(marble2);
   }
   
   public void marble_3() {
      marble_3.setLayout(null);
      marble_3.setBounds(340, 115, 516, 610);
      marble_3.setBorderPainted(false);
      marble_3.setFocusPainted(false);  
      
      add(marble_3);
      marble_3.setIcon(marble3);
   }
   
   public void marble_4() {
      marble_4.setLayout(null);
      marble_4.setBounds(340, 115, 516, 610);
      marble_4.setBorderPainted(false);
      marble_4.setFocusPainted(false);  
      
      add(marble_4);
      marble_4.setIcon(marble4);
   }
   
   public void marble_5() {
      marble_5.setLayout(null);
      marble_5.setBounds(340, 115, 516, 610);
      marble_5.setBorderPainted(false);
      marble_5.setFocusPainted(false);  
      
      add(marble_5);
      marble_5.setIcon(marble5);
   }
   
   public void marble_6() {
      marble_6.setLayout(null);
      marble_6.setBounds(340, 115, 516, 610);
      marble_6.setBorderPainted(false);
      marble_6.setFocusPainted(false);  
      
      add(marble_6);
      marble_6.setIcon(marble6);
   }
   
   public void marble_7() {
      marble_7.setLayout(null);
      marble_7.setBounds(340, 115, 516, 610);
      marble_7.setBorderPainted(false);
      marble_7.setFocusPainted(false);  
      
      add(marble_7);
      marble_7.setIcon(marble7);
   }
   
   public void marble_8() {
      marble_8.setLayout(null);
      marble_8.setBounds(340, 115, 516, 610);
      marble_8.setBorderPainted(false);
      marble_8.setFocusPainted(false);  
      
      add(marble_8);
      marble_8.setIcon(marble8);
   }
   
   public void marble_9() {
      marble_9.setLayout(null);
      marble_9.setBounds(340, 115, 516, 610);
      marble_9.setBorderPainted(false);
      marble_9.setFocusPainted(false);  
      
      add(marble_9);
      marble_9.setIcon(marble9);
   }
   
   public void marble_10() {
      marble_10.setLayout(null);
      marble_10.setBounds(340, 115, 516, 610);
      marble_10.setBorderPainted(false);
      marble_10.setFocusPainted(false);  
      
      add(marble_10);
      marble_10.setIcon(marble10);
   }
   
   String ch;
   public void game() {
	   int computer_num = (int)(Math.random()*10) +1;
      
	   String computer_ch = "";
      
//	   if(computer_num % 2 == 0) {
//		   computer_ch = "짝";
//	   } else {
//		   computer_ch = "홀";
//	   }
	   ch = "홀";
	   computer_ch = "홀";
	   computer_num = 9;
      
	   if(computer_ch.equals(ch)) { 
		   playSound("src/audio/winner.wav",false);
		   
		   if(computer_num == 1 ) {
			   marble_1();
		   }
		   else if(computer_num == 3 ) {
			   marble_3();
		   }
		   else if(computer_num == 5 ) {
			   marble_5();
		   }
		   else if(computer_num == 7 ) {
			   marble_7();
		   }
		   else if(computer_num == 9 ) {
			   marble_9();
		   }
		   else if(computer_num == 2) {
			   marble_2();
		   }
		   else if(computer_num == 4) {
			   marble_4();
		   }
		   else if(computer_num == 6) {
			   marble_6();
		   }
		   else if(computer_num == 8) {
			   marble_8();
		   }
		   else if(computer_num == 10) {
			   marble_10();
		   }
		   winner();
	   }
	   else if(computer_ch != ch) {
		   playSound("src/audio/lose.wav",false);
		   System.out.println("틀림");
		   lose();
	   }
   	}
   
   public void lose() {
	   Panel pa = new Panel();
	   Label label2 = new Label("실패!");
	   //label2.setFont(label2.getFont().deriveFont(20.0f));
	   pa.add(label2);
	   add(pa);
	   pa.setBounds(650,80,300,50);
	   setVisible(true);
	   
	   Timer m_timer = new Timer();
	   TimerTask m_task = new TimerTask() {
		   @Override
		   public void run() {
			   setVisible(false);
			   clip.stop();
			   clip.close();
			   new End();
			   
		   }
	   };
	   m_timer.schedule(m_task, 2500);
   }
   public void winner() {
	   Panel pa = new Panel();
	   Label label2 = new Label("성공!");
	   //label2.setFont(label2.getFont().deriveFont(20.0f));
	   pa.add(label2);
	   add(pa);
	   pa.setBounds(650,80,300,50);
	   setVisible(true);
	   
	   Timer m_timer = new Timer();
	   TimerTask m_task = new TimerTask() {
		   @Override
		   public void run() {
			   setVisible(false);
			   clip.stop();
			   clip.close();
			   new Stepping_Stone();
			   
		   }
	   };
	   m_timer.schedule(m_task, 2500);
   }
   
   public void ff() {   
	  Panel p = new Panel();
      p.setBackground(Color.decode("#ffffff"));
      Label label1 = new Label();
      Label label = new Label("홀 짝을 고르시오");
      p.add(label);
      add(p);
      
      JTextField choose = new JTextField(20);
      choose.selectAll();
      p.add(choose);
      add(p);
      
      JButton button = new JButton();
      button.setText("입력");
      button.setBackground(Color.decode("#af89eb"));
      button.setLayout(null);
      p.add(button);
      
      p.setSize(100, 80);
      p.setBounds(650,80,300,80);
      setVisible(true);

      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            String cho = choose.getText();
            ch = cho;
            //다이얼로그
            JOptionPane.showMessageDialog(null,cho);
            p.setVisible(false);
            game();
         }
      });
      
   }
   public void paint(Graphics g) {
      g.drawImage(background,0,0,null);
      g.drawImage(hand1, 280, 90, null);
   }

   public void frame() {
      setTitle("구슬치기");
      setSize(1600, 900);
      setResizable(false);
      setLocationRelativeTo(null);
      setLayout(null); //레이아웃을 내맘대로 설정 가능
      setVisible(true); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}



public class Marble { 
	Marble() {
		MarbleEx exframe = new MarbleEx();
	}
	public static void main(String[] args) {
	}
}   