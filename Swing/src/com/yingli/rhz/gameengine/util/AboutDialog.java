package com.yingli.rhz.gameengine.util;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AboutDialog extends JDialog {
	private JButton OKBtn;
	
	public AboutDialog(JFrame frame){
		super(frame);
		OKBtn = new JButton("确定");
		OKBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AboutDialog.this.dispose();
//				AboutDialog.this.setVisible(false);
			}
		});
		add(OKBtn,BorderLayout.SOUTH);
		setModal(true);
		setBounds(frame.getX() + frame.getWidth() / 3,frame.getY() + frame.getHeight() / 3,200,100);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("关于");
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		String s = "山寨编辑器，哈哈";
		g.drawString(s, 50, getHeight() / 2);
		
	}
	
}
