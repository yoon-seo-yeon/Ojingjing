package Ojingjing;
//¡�˴ٸ�
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

class StepStoneEx extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/step_stone_ex.png").getImage();

	StepStoneEx() {
		homeframe();
		btn_start();
	}
	
	static JButton btn_start = new JButton();
	
	public void btn_start() { //��ư 2
		btn_start.setLayout(null);
		btn_start.setBounds(690, 712, 180, 110);
		btn_start.setBackground(Color.WHITE);
		btn_start.setText("����");
		btn_start.setFont(btn_start.getFont().deriveFont(30.0f));
		btn_start.setForeground(Color.BLACK);
		btn_start.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_start.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_start);
		
		btn_start.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e) { 
	        	setVisible(false);
	        	StepStoneFrame sframe = new StepStoneFrame();
	        	
	        	sframe.PlayerX = 1400;
	    		sframe.PlayerY = 770;
	    		sframe.PWidth = 130;
	    		sframe.PHeight = 130;
	    		
	    		//(�ִ�-�ּ�+1) + �ּ�
	    		int ob1 = (int) (Math.random() * 2) + 1; //1~2
	    		int ob2 = (int) (Math.random() * 2) + 3; //3~4
	    		int ob3 = (int) (Math.random() * 2) + 5; //5~6
	    		int ob4 = (int) (Math.random() * 2) + 7; //7~8
	    		
	    		System.out.println("ob1 : " + ob1);
	    		System.out.println("ob2 : " + ob2);
	    		System.out.println("ob3 : " + ob3);
	    		System.out.println("ob4 : " + ob4);
	    		
	    		sframe.Ob1 = ob1;
	    		sframe.Ob2 = ob2;
	    		sframe.Ob3 = ob3;
	    		sframe.Ob4 = ob4;
	        }  
	    });
	}

	public void homeframe() {
		setTitle("¡�˴ٸ� ����"); //������ ����
		setSize(1600, 925); //������ ũ��
		setResizable(false); //â ũ�� ���� ����
		setLocationRelativeTo(null); //â ��� ������
		setLayout(null);
		setVisible(true); //â�� ���̰�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ���������� ����
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, 1600, 900, null);

	}
}

class StepStoneFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/step_stone.png").getImage();
	
	int PlayerX = 0; //�÷��̾� X��ǥ
	int PlayerY = 0; //�÷��̾� Y��ǥ
	int PWidth = 0; //�÷��̾� ����
	int PHeight = 0; //�÷��̾� ����
	
	int Ob1 = 0;
	int Ob2 = 0;
	int Ob3 = 0;
	int Ob4 = 0;
	
	int last = 0;
	
	//������ư
	static JButton btn_glass_1 = new JButton();
	static JButton btn_glass_2 = new JButton();
	static JButton btn_glass_3 = new JButton();
	static JButton btn_glass_4 = new JButton();
	static JButton btn_glass_5 = new JButton();
	static JButton btn_glass_6 = new JButton();
	static JButton btn_glass_7 = new JButton();
	static JButton btn_glass_8 = new JButton();
	
	//���� ����
	private ImageIcon glass1 = new ImageIcon("src/image/glass_1.png");
	private ImageIcon glass2 = new ImageIcon("src/image/glass_2.png");
	private ImageIcon glass3 = new ImageIcon("src/image/glass_3.png");
	private ImageIcon glass4 = new ImageIcon("src/image/glass_4.png");
	private ImageIcon glass5 = new ImageIcon("src/image/glass_5.png");
	private ImageIcon glass6 = new ImageIcon("src/image/glass_6.png");
	private ImageIcon glass7 = new ImageIcon("src/image/glass_7.png");
	private ImageIcon glass8 = new ImageIcon("src/image/glass_8.png");
	
	//���� ������ ��¡¡
	private ImageIcon pglass1 = new ImageIcon("src/image/pglass_1.png");
	private ImageIcon pglass2 = new ImageIcon("src/image/pglass_2.png");
	private ImageIcon pglass3 = new ImageIcon("src/image/pglass_3.png");
	private ImageIcon pglass4 = new ImageIcon("src/image/pglass_4.png");
	private ImageIcon pglass5 = new ImageIcon("src/image/pglass_5.png");
	private ImageIcon pglass6 = new ImageIcon("src/image/pglass_6.png");
	private ImageIcon pglass7 = new ImageIcon("src/image/pglass_7.png");
	private ImageIcon pglass8 = new ImageIcon("src/image/pglass_8.png");
	
	//���� ���� ��¡¡
	private ImageIcon bglass1 = new ImageIcon("src/image/bglass_1.png");
	private ImageIcon bglass2 = new ImageIcon("src/image/bglass_2.png");
	private ImageIcon bglass3 = new ImageIcon("src/image/bglass_3.png");
	private ImageIcon bglass4 = new ImageIcon("src/image/bglass_4.png");
	private ImageIcon bglass5 = new ImageIcon("src/image/bglass_5.png");
	private ImageIcon bglass6 = new ImageIcon("src/image/bglass_6.png");
	private ImageIcon bglass7 = new ImageIcon("src/image/bglass_7.png");
	private ImageIcon bglass8 = new ImageIcon("src/image/bglass_8.png");

	//��¡¡ ��ư
	static JButton player = new JButton();
	private ImageIcon Imageplayer = new ImageIcon("src/image/player.png");

	public StepStoneFrame() {
		homeframe();
		btn_glass_1();
		btn_glass_2();
		btn_glass_3();
		btn_glass_4();
		btn_glass_5();
		btn_glass_6();
		btn_glass_7();
		btn_glass_8();
	}
	
	private Clip clip;
	
	public void homeframe() {
		playSound("src/audio/step_stone.wav",false);
		setTitle("¡�˴ٸ�"); //������ ����
		setSize(1600, 925); //������ ũ��
		setResizable(false); //â ũ�� ���� ����
		setLocationRelativeTo(null); //â ��� ������
		setLayout(null);
		setVisible(true); //â�� ���̰�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ���������� ����
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
	
	public void btn_glass_1() { //��ư 1
		btn_glass_1.setLayout(null);
		btn_glass_1.setBounds(410, 712, 330, 160); //330
		btn_glass_1.setBackground(new Color(0, 0, 0));
		btn_glass_1.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_1.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_1);
		btn_glass_1.setIcon(glass1);
		
		btn_glass_1.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư1");  
	            if(Ob1 == 1) {
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_1);
	        		btn_glass_1.setIcon(bglass1); //���� ����
	        		//clip.stop();
	        		Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							clip.stop();
							new EndFrame();
							
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            	add(btn_glass_1);
	            	btn_glass_1.setIcon(pglass1); //������ �� ��¡¡
	            }
	        } 
	    });
	}
	
	public void btn_glass_2() { //��ư 2
		btn_glass_2.setLayout(null);
		btn_glass_2.setBounds(838, 712, 330, 160);
		btn_glass_2.setBackground(new Color(0, 0, 0));
		btn_glass_2.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_2.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_2);
		btn_glass_2.setIcon(glass2);
		
		btn_glass_2.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư2");    
	            if(Ob1 == 2) {
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(bglass2);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							clip.stop();
							new EndFrame();
							
						}
					};
					m_timer.schedule(m_task, 2500);
	            	
	            }else {
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(pglass2);	       
	            }
	        }  
	    });
	}
	
	public void btn_glass_3() { //��ư 3
		btn_glass_3.setLayout(null);
		btn_glass_3.setBounds(473, 495, 280, 150);
		btn_glass_3.setBackground(new Color(0, 0, 0));
		btn_glass_3.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_3.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_3);
		btn_glass_3.setIcon(glass3);
		
		btn_glass_3.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư3");  
	            if(Ob2 == 3) {
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(bglass3);
	            	
	            	add(btn_glass_1);
	            	btn_glass_1.setIcon(glass1);
	            	
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(glass2);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(pglass3);
	            	
	            	add(btn_glass_1);
	            	btn_glass_1.setIcon(glass1);
	            	
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(glass2);
	            }
	        }  
	    });
	}
	
	public void btn_glass_4() { //��ư 4
		btn_glass_4.setLayout(null);
		btn_glass_4.setBounds(820, 495, 280, 150);
		btn_glass_4.setBackground(new Color(0, 0, 0));
		btn_glass_4.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_4.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_4);
		btn_glass_4.setIcon(glass4);
		
		btn_glass_4.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư4"); 
	            if(Ob2 == 4) {
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(bglass4);
	            	
	            	add(btn_glass_1);
	            	btn_glass_1.setIcon(glass1);
	            	
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(glass2);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(pglass4);
	            	
	            	add(btn_glass_1);
	            	btn_glass_1.setIcon(glass1);
	            	
	            	add(btn_glass_2);
	            	btn_glass_2.setIcon(glass2);
	            }
	        }  
	    });
	}
	
	public void btn_glass_5() { //��ư 5
		btn_glass_5.setLayout(null);
		btn_glass_5.setBounds(526, 326, 240, 110);
		btn_glass_5.setBackground(new Color(0, 0, 0));
		btn_glass_5.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_5.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_5);
		btn_glass_5.setIcon(glass5);
		
		btn_glass_5.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư5"); 
	            if(Ob3 == 5) {	     
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_5);
	            	btn_glass_5.setIcon(bglass5);
	            	
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(glass3);
	            	
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(glass4);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            	add(btn_glass_5);
	            	btn_glass_5.setIcon(pglass5);
	            	
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(glass3);
	            	
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(glass4);       	
	            }
	        }  
	    });
	}
	
	public void btn_glass_6() { //��ư 6
		btn_glass_6.setLayout(null);
		btn_glass_6.setBounds(803, 326, 240, 110);
		btn_glass_6.setBackground(new Color(0, 0, 0));
		btn_glass_6.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_6.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_6);
		btn_glass_6.setIcon(glass6);
		
		btn_glass_6.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư6"); 
	            if(Ob3 == 6) {	     
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_6);
	            	btn_glass_6.setIcon(bglass6);
	            	
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(glass3);
	            	
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(glass4);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            	add(btn_glass_6);
	            	btn_glass_6.setIcon(pglass6);
	            	
	            	add(btn_glass_3);
	            	btn_glass_3.setIcon(glass3);
	            	
	            	add(btn_glass_4);
	            	btn_glass_4.setIcon(glass4);          
	            }
	        }  
	    });
	}
	
	public void btn_glass_7() { //��ư 7
		btn_glass_7.setLayout(null);
		btn_glass_7.setBounds(572, 188, 200, 90);
		btn_glass_7.setBackground(new Color(0, 0, 0));
		btn_glass_7.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_7.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_7);
		btn_glass_7.setIcon(glass7);
		
		btn_glass_7.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư7"); 
	            if(Ob4 == 7) {
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_7);
	            	btn_glass_7.setIcon(bglass7);
	            	
	            	add(btn_glass_5);
	            	btn_glass_5.setIcon(glass5);
	            	
	            	add(btn_glass_6);
	            	btn_glass_6.setIcon(glass6);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {	            		        
	            	add(btn_glass_7);
		            btn_glass_7.setIcon(pglass7);
		            	
		            add(btn_glass_5);
		            btn_glass_5.setIcon(glass5);
		            	
		            add(btn_glass_6);
		            btn_glass_6.setIcon(glass6);
		            		     
		            playSound("src/audio/winner.wav",false);
		            Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							add(btn_glass_7);
				            btn_glass_7.setIcon(glass7);
				            
							player.setLayout(null);
		        			player.setBounds(730, 20, 110, 130);
		        			player.setBackground(new Color(0, 0, 0));
		        			player.setBorderPainted(false); //�ܰ��� �����ֱ�
		        			player.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		        			add(player);
		        			player.setIcon(Imageplayer);
						}
					};
					m_timer.schedule(m_task, 500);
					
					Timer m_timer2 = new Timer();
					TimerTask m_task2 = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer2.schedule(m_task2, 2500);
	            }
	        }  
	    });
	}
	
	public void btn_glass_8() { //��ư 8
		btn_glass_8.setLayout(null);
		btn_glass_8.setBounds(795, 188, 200, 90);
		btn_glass_8.setBackground(new Color(0, 0, 0));
		btn_glass_8.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_glass_8.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(btn_glass_8);
		btn_glass_8.setIcon(glass8);
		
		btn_glass_8.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��ư8"); 
	            if(Ob4 == 8) {	     
	            	playSound("src/audio/lose.wav",false);
	            	add(btn_glass_8);
	            	btn_glass_8.setIcon(bglass8);
	            	
	            	add(btn_glass_5);
	            	btn_glass_5.setIcon(glass5);
	            	
	            	add(btn_glass_6);
	            	btn_glass_6.setIcon(glass6);
	            	
	            	Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer.schedule(m_task, 2500);
	            }else {
	            		  
	        		add(btn_glass_8);
		            btn_glass_8.setIcon(pglass8);
		            	
		            add(btn_glass_5);
		            btn_glass_5.setIcon(glass5);
		            	
		            add(btn_glass_6);
		            btn_glass_6.setIcon(glass6);		           

		            playSound("src/audio/winner.wav",false);
		            
		            Timer m_timer = new Timer();
					TimerTask m_task = new TimerTask() {
						@Override
						public void run() {		
							add(btn_glass_8);
				            btn_glass_8.setIcon(glass8);
				            
							player.setLayout(null);
		        			player.setBounds(730, 20, 110, 130);
		        			player.setBackground(new Color(0, 0, 0));
		        			player.setBorderPainted(false); //�ܰ��� �����ֱ�
		        			player.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		        			add(player);
		        			player.setIcon(Imageplayer);
						}
					};
					m_timer.schedule(m_task, 500);
					
					Timer m_timer2 = new Timer();
					TimerTask m_task2 = new TimerTask() {
						@Override
						public void run() {
							new End();
							clip.stop();
						}
					};
					m_timer2.schedule(m_task, 2500);
	            }
	        }  
	    });
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, null);
	}
}

public class Stepping_Stone {
	Stepping_Stone() {
		StepStoneEx eframe = new StepStoneEx();
	}
	public static void main(String[] args) {
		new Stepping_Stone();
	}
}