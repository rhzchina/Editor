package com.yingli.rhz.gameengine.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 * 动画的编辑视图，位于右上窗格
 * @author 大钊
 *
 */
public class FrameEditorView extends JPanel{
	private JToolBar toolBar;
	
	public FrameEditorView(){
		setLayout(new BorderLayout());
		init();
	}
	
	private void init(){
		toolBar = new JToolBar();
		toolBar.add(new JButton("动画编辑"));
		add(toolBar,BorderLayout.NORTH);
	}
	
}
