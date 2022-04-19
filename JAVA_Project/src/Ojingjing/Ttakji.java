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
	
	public void btn_start() { //��ư 2
		btn_start.setLayout(null);
		btn_start.setBounds(690, 712, 150, 90);
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
	        	new TtakjiFrame();
	        }  
	    });
	}

	public void homeframe() {
		setTitle("����ġ�� ����"); //������ ����
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

class TtakjiFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/ttakji.png").getImage();
	private Image player = new ImageIcon("src/image/player.png").getImage();
	
	static int Score = 0;	//�÷��̾� ����
	int red = 0; //���� ���� ���� ��
	int blue = 0; //�Ķ� ���� ���� ��
	int cnt = 0;	//�� �� �ݺ�

	//���� ��ư
	static JButton redttakji = new JButton(); //����
	static JButton bluettakji = new JButton(); //�÷��̾�
	
	//���� �ո� �̹���
	private ImageIcon img_redttakji_1 = new ImageIcon("src/image/redttakji_1.png");
	private ImageIcon img_bluettakji_1 = new ImageIcon("src/image/bluettakji_1.png");
	
	//���� �޸� �̹���
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
		setTitle("����ġ��"); //������ ����
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
	
	JPanel p = new JPanel(); 	 
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
			
	public void redttakji() { //�������� ��ư
		redttakji.setLayout(null);
		redttakji.setBounds(250, 470, 402, 390);
		redttakji.setBackground(new Color(0, 0, 0));
		redttakji.setBorderPainted(false); //�ܰ��� �����ֱ�
		redttakji.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(redttakji);
		redttakji.setIcon(img_redttakji_1);
		
		redttakji.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("��������"); 
	            playSound("src/audio/Slap.wav",false);
	            
	            blue = 0;
	            red = 0;
	            red = (int) (Math.random() * 10) + 1; 	//1~10
				//blue = (int) (Math.random() * 5) + 6;   //6~10
	            
				System.out.println("red : " + red);
				System.out.println("blue : " + blue);
				
				if((red == 2) || (red == 4) || (red == 6) || (red == 8) || (red == 9) || (red == 10)) { //�ȵ�����		
					label2.setText("�÷��̾� �����Դϴ�.");
					label2.setHorizontalAlignment(JLabel.CENTER);
					p.add(label2);
					add(p);
					label2.setFont(label2.getFont().deriveFont(15.0f));
					p.setBackground(Color.WHITE);
					p.setBounds(690, 350, 160, 40);
				}
				else if((red == 1) || (red == 3) || (red == 5) || (red == 7)) { //������	
					playSound("src/audio/lose.wav",false);
					label2.setText("�÷��̾� �й�..");
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
	
	public void bluettakji() { //�Ķ����� ��ư
		bluettakji.setLayout(null);
		bluettakji.setBounds(900, 470, 402, 390);
		bluettakji.setBackground(new Color(0, 0, 0));
		bluettakji.setBorderPainted(false); //�ܰ��� �����ֱ�
		bluettakji.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
		add(bluettakji);
		bluettakji.setIcon(img_bluettakji_1);
		
		bluettakji.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            System.out.println("�Ķ�����"); 
	            playSound("src/audio/Slap.wav",false);
	            
	            //red = (int) (Math.random() * 5) + 1; 	//1~5
	            red = 0;
	            blue = 0;
				blue = (int) (Math.random() * 10) + 11;   //11~20
	            
				System.out.println("red : " + red);
				System.out.println("blue : " + blue);
				
				if((blue == 11) || (blue == 13) || (blue == 15) ||(blue == 17)) { //������
					playSound("src/audio/winner.wav",false);
					label2.setText("�÷��̾� �¸�!!");
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
				else if((blue == 12) || (blue == 14)||(blue == 16) || (blue == 18) || (blue == 19) || (blue == 20)) { //�ȵ�����
					label2.setText("���� �����Դϴ�.");
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
