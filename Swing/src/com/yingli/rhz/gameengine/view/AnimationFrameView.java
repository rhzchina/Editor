package com.yingli.rhz.gameengine.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 * 动画的每一帧预览视图，位于右下窗格
 * @author 大钊
 * 
 *
 */
public class AnimationFrameView extends JPanel{
	private JToolBar toolBar;
	
	public AnimationFrameView(){
		setLayout(new BorderLayout());
		init();
	}
	
	private void init(){
		toolBar = new JToolBar();
		toolBar.add(new JButton("删除帧"));
		add(toolBar,BorderLayout.NORTH);
	}
	
	
}
