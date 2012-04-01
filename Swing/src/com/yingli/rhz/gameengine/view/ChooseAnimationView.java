package com.yingli.rhz.gameengine.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 * 动画的效果预览视图，位于左下窗格
 * @author 大钊
 *
 */
public class ChooseAnimationView extends JPanel{
	private JToolBar toolBar;
	
	public ChooseAnimationView(){
		setLayout(new BorderLayout());
		init();
	}
	
	private void init(){
		toolBar = new JToolBar();
		toolBar.add(new JButton("删动画"));
		add(toolBar,BorderLayout.NORTH);
	}
	
}
