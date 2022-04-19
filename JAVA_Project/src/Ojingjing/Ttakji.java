package Ojingjing;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TtakjiEx extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/ttakji_ex.png").getImage();

	TtakjiEx() {
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
	        	new TtakjiFrame();
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

class TtakjiFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/ttakji.png").getImage();
	private Image player = new ImageIcon("src/image/player.png").getImage();
	
	static int Score = 0;	//플레이어 점수
	int red = 0; //빨간 딱지 랜덤 수
	int blue = 0; //파랑 딱지 랜덤 수
	int cnt = 0;	//몇 번 반복

	//딱지 버튼
	static JButton redttakji = new JButton(); //상대방
	static JButton bluettakji = new JButton(); //플레이어
	
	//딱지 앞면 이미지
	private ImageIcon img_redttakji_1 = new ImageIcon("src/image/redttakji_1.png");
	private ImageIcon img_bluettakji_1 = new ImageIcon("src/image/bluettakji_1.png");
	
	//딱지 뒷면 이미지
	private ImageIcon img_redttakji_2 = new ImageIcon("src/image/redttakji_2.png");
	private ImageIcon img_bluettakji_2 = new ImageIcon("src/image/bluettakji_2.png");
	
	public TtakjiFrame() {
		homeframe();
		redttakji();
		bluettakji();
		//ff();
		//Red_Blue();
	}
	
	private Clip clip;
	public void homeframe() {
		setTitle("딱지치기"); //프레임 제목
		setSize(1600, 925); //프레임 크기
		setResizable(false); //창 크기 변경 금지
		setLocationRelativeTo(null); //창 가운데 나오게
		setLayout(null);
		setVisible(true); //창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 정상적으로 종료
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
	
	JPanel p = new JPanel(); 	 
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
			
	public void redttakji() { //빨간딱지 버튼
		redttakji.setLayout(null);
		redttakji.setBounds(250, 470, 402, 390);
		redttakji.setBackground(new Color(0, 0, 0));
		redttakji.setBorderPainted(false); //외곽선 없애주기
		redttakji.setFocusPainted(false);	//버튼 선택되었을 때 생기는 테두리 안함
		add(redttakji);
		redttakji.setIcon(img_redttakji_1);
		
		redttakji.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("빨간딱지"); 
	            playSound("src/audio/Slap.wav",false);
	            
	            blue = 0;
	            red = 0;
	            red = (int) (Math.random() * 10) + 1; 	//1~10
				//blue = (int) (Math.random() * 5) + 6;   //6~10
	            
				System.out.println("red : " + red);
				System.out.println("blue : " + blue);
				
				if((red == 2) || (red == 4) || (red == 6) || (red == 8) || (red == 9) || (red == 10)) { //안뒤집힘		
					label2.setText("플레이어 차례입니다.");
					label2.setHorizontalAlignment(JLabel.CENTER);
					p.add(label2);
					add(p);
					label2.setFont(label2.getFont().deriveFont(15.0f));
					p.setBackground(Color.WHITE);
					p.setBounds(690, 350, 160, 40);
				}
				else if((red == 1) || (red == 3) || (red == 5) || (red == 7)) { //뒤집힘	
					playSound("src/audio/lose.wav",false);
					label2.setText("플레이어 패배..");
					label2.setHorizontalAlignment(JLabel.CENTER);
					p.add(label2);
					add(p);
					label2.setFont(label2.getFont().deriveFont(15.0f));
					p.setBackground(Color.WHITE);
					p.setBounds(690, 350, 160, 40);
					
					add(bluettakji);
					bluettakji.setIcon(img_bluettakji_2);
					
					Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							setVisible(false);
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2000);
				}
	        }  
	    });
	}
	
	public void bluettakji() { //파랑딱지 버튼
		bluettakji.setLayout(null);
		bluettakji.setBounds(900, 470, 402, 390);
		bluettakji.setBackground(new Color(0, 0, 0));
		bluettakji.setBorderPainted(false); //외곽선 없애주기
		bluettakji.setFocusPainted(false);	//버튼 선택되었을 때 생기는 테두리 안함
		add(bluettakji);
		bluettakji.setIcon(img_bluettakji_1);
		
		bluettakji.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("파랑딱지"); 
	            playSound("src/audio/Slap.wav",false);
	            
	            //red = (int) (Math.random() * 5) + 1; 	//1~5
	            red = 0;
	            blue = 0;
				blue = (int) (Math.random() * 10) + 11;   //11~20
	            
				System.out.println("red : " + red);
				System.out.println("blue : " + blue);
				
				if((blue == 11) || (blue == 13) || (blue == 15) ||(blue == 17)) { //뒤집힘
					playSound("src/audio/winner.wav",false);
					label2.setText("플레이어 승리!!");
					label2.setHorizontalAlignment(JLabel.CENTER);
					p.add(label2);
					add(p);
					label2.setFont(label2.getFont().deriveFont(15.0f));
					p.setBackground(Color.WHITE);
					p.setBounds(690, 350, 160, 40);
					
					add(redttakji);
					redttakji.setIcon(img_redttakji_2);
					
					Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							setVisible(false);
		    	        	new Marble();
		    	        	clip.stop();
						}
					};
					m_timer.schedule(m_task, 2000);
				}
				else if((blue == 12) || (blue == 14)||(blue == 16) || (blue == 18) || (blue == 19) || (blue == 20)) { //안뒤집힘
					label2.setText("상대방 차례입니다.");
					label2.setHorizontalAlignment(JLabel.CENTER);
					p.add(label2);
					add(p);
					label2.setFont(label2.getFont().deriveFont(15.0f));
					p.setBackground(Color.WHITE);
					p.setBounds(690, 350, 160, 40);
				}	         
	        }  
	    });
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, null);
		g.drawImage(player, 1350, 700, null);
	}
}

public class Ttakji {
	Ttakji() {
		TtakjiEx exframe = new TtakjiEx();
	}
	public static void main(String[] args) {
	}
}
