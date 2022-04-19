package Ojingjing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class FirstFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/main_background.png").getImage();

	
	FirstFrame() {
		homeframe();
		btn_start();
		
	}
	
	private Clip clip;
	public void homeframe() {
		playSound("src/audio/backgroundmusic.wav",false);
		setTitle("첫화면"); //프레임 제목
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
	
	static JButton btn_start = new JButton();
	
	public void btn_start() { //버튼 2
		btn_start.setLayout(null);
		btn_start.setBounds(660, 712, 330, 160);
		btn_start.setBackground(new Color(0, 0, 0));
		btn_start.setText("게임 시작");
		btn_start.setFont(btn_start.getFont().deriveFont(30.0f));
		btn_start.setForeground(Color.WHITE);
		btn_start.setBorderPainted(false); //외곽선 없애주기
		btn_start.setFocusPainted(false);	//버튼 선택되었을 때 생기는 테두리 안함
		add(btn_start);
		
		btn_start.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e) { 
	        	setVisible(false);
	        	new Ttakji();
	        	clip.stop();
	        }  
	    });
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, 1600, 900, null);
	}
}

public class First {
	First() {
		FirstFrame fframe = new FirstFrame();
	}
	public static void main(String[] args) {
		new First();
	}
}
