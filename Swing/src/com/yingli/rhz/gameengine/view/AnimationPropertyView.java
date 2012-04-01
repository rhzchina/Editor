package com.yingli.rhz.gameengine.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 * 对动画的属性进行设置的视图，位于中下窗格
 * @author  大钊
 *
 */
public class AnimationPropertyView extends JPanel{
	private JToolBar toolBar1;
	private JToolBar toolBar2;
	private JPanel toolBarPanel;
	
	public AnimationPropertyView(){
		setLayout(new BorderLayout());
		init();
	}
	
	private void init(){
		toolBar1 = new JToolBar();
		toolBar2 = new JToolBar();
		
		toolBar1.add(new JButton("h1"));
		toolBar2.add(new JButton("h2"));
		
		toolBarPanel = new JPanel();
		toolBarPanel.setLayout(new GridLayout(2,1));
		toolBarPanel.add(toolBar1);
		toolBarPanel.add(toolBar2);
		add(toolBarPanel,BorderLayout.NORTH);
	}
}
