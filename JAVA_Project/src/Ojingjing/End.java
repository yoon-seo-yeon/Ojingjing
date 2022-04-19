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
		setTitle("����"); //������ ����
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
	
	static JButton btn_end = new JButton();
	
	public void btn_start() { //��ư 2
		btn_end.setLayout(null);
		btn_end.setBounds(660, 712, 330, 160);
		btn_end.setBackground(new Color(0, 0, 0));
		btn_end.setText("���� �ٽ� ����");
		btn_end.setFont(btn_end.getFont().deriveFont(30.0f));
		btn_end.setForeground(Color.WHITE);
		btn_end.setBorderPainted(false); //�ܰ��� �����ֱ�
		btn_end.setFocusPainted(false);	//��ư ���õǾ��� �� ����� �׵θ� ����
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
