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

class EndFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/main_background.png").getImage();
	
	EndFrame() {
		homeframe();
		btn_start();
	}
	
	private Clip clip;
	public void homeframe() {
		playSound("src/audio/backgroundmusic.wav",false);
		setTitle("종료"); //프레임 제목
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
	
	static JButton btn_end = new JButton();
	
	public void btn_start() { //버튼 2
		btn_end.setLayout(null);
		btn_end.setBounds(660, 712, 330, 160);
		btn_end.setBackground(new Color(0, 0, 0));
		btn_end.setText("게임 다시 시작");
		btn_end.setFont(btn_end.getFont().deriveFont(30.0f));
		btn_end.setForeground(Color.WHITE);
		btn_end.setBorderPainted(false); //외곽선 없애주기
		btn_end.setFocusPainted(false);	//버튼 선택되었을 때 생기는 테두리 안함
		add(btn_end);
		
		btn_end.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent e) { 
	        	setVisible(false);
	        	new First();
	        	clip.stop();
	        }  
	    });
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 25, 1600, 900, null);
	}
}

public class End {
	End() {
		new EndFrame();
	}
	public static void main(String[] args) {
	}
}
