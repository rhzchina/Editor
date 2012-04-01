package com.yingli.rhz.gameengine.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import com.yingli.rhz.gameengine.util.AboutDialog;
import com.yingli.rhz.gameengine.view.AnimationFrameView;
import com.yingli.rhz.gameengine.view.AnimationPropertyView;
import com.yingli.rhz.gameengine.view.ChooseAnimationView;
import com.yingli.rhz.gameengine.view.ChooseImageView;
import com.yingli.rhz.gameengine.view.FrameEditorView;
import com.yingli.rhz.gameengine.view.ImageTileView;


public class MyFrame extends JFrame{
	private JMenuBar mainMenuBar;
	private JMenu fileMenu;
	private JMenu helpMenu;
	
	private JMenuItem openItem;
	private JMenuItem exitItem;
	private JMenuItem helpItem;
	private JMenuItem aboutItem;
	
	
	private JLabel stateLabel;
	
	private JPanel centerPanel;
	
	private JToolBar toolBar;
	
	private JSplitPane leftSplitPane;
	private JSplitPane rightSplitPane;
	
	private JSplitPane leftSubSplitPane;
	private JSplitPane centerSplitPane;
	private JSplitPane rightSubSplitPane;
	
	private ChooseImageView leftTopView;
	private ChooseAnimationView leftBottomView;
	private ImageTileView centerTopView;
	private AnimationPropertyView centerBottomView;
	private AnimationFrameView rightBottomView;
	private FrameEditorView rightTopView;
	
	public MyFrame(){	
		setBounds(200,100,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initUI();
		setVisible(true);
	}
	
	/**
	 * 初始化布局
	 */
	private void initUI(){
		setTitle("山寨动画编辑器");
		initMenu();
		initMainPanel();
		initToolBar();
		initPane();
		initStateBar();
		
	}
	
	/**
	 * 菜单栏的初始化
	 */
	private void initMenu(){
		mainMenuBar = new JMenuBar();
		add(mainMenuBar,BorderLayout.NORTH);
		
		//菜单栏
		fileMenu = new JMenu("文件");
		helpMenu = new JMenu("帮助");
		mainMenuBar.add(fileMenu);
		mainMenuBar.add(helpMenu);
		
		//文件菜单
		openItem = new JMenuItem("打开");
		
		exitItem = new JMenuItem("退出");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		//帮助菜单
		helpItem = new JMenuItem("帮助");
		
		aboutItem = new JMenuItem("关于");
		aboutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new AboutDialog(MyFrame.this);
			}
		});
		
		helpMenu.add(helpItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);
		
	}

	
	/**
	 * 低部的状态栏
	 */
	private void initStateBar(){
		stateLabel = new JLabel("状态显示");
		add(stateLabel,BorderLayout.SOUTH);
	}
	
	
	/**
	 * 主界面的主部再添加一个面板，部局管理器为BorderLayout
	 */
	private void initMainPanel(){
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		add(centerPanel,BorderLayout.CENTER);
				
	}
	
	/**
	 * 对主界面的工具条初始化
	 */
	private void initToolBar(){
		toolBar = new JToolBar();
		toolBar.add(new JButton("hello"));
		toolBar.addSeparator();
		toolBar.add(new JButton("hello1"));
		toolBar.add(new JButton("hello2"));
		centerPanel.add(toolBar,BorderLayout.NORTH);
	}
	
	/**
	 * 对主界面的窗格初始化，包含有六个视图
	 */
	private void initPane(){

		leftSplitPane = new JSplitPane();
		leftSplitPane.setDividerLocation(getWidth()/3);
		centerPanel.add(leftSplitPane,BorderLayout.CENTER);
		
		rightSplitPane = new JSplitPane();
		rightSplitPane.setDividerLocation(getWidth() / 3);
		leftSplitPane.add(rightSplitPane,JSplitPane.RIGHT);
		
		//左边窗格
		leftSubSplitPane = new JSplitPane();
		leftSubSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		leftSubSplitPane.setDividerLocation(getHeight() / 2);
		leftSplitPane.add(leftSubSplitPane,JSplitPane.LEFT);
		
		leftTopView = new ChooseImageView();
		leftBottomView = new ChooseAnimationView();
		leftSubSplitPane.add(leftTopView,JSplitPane.TOP);
		leftSubSplitPane.add(leftBottomView,JSplitPane.BOTTOM);

		//中间窗格
		centerSplitPane = new JSplitPane();
		centerSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		centerSplitPane.setDividerLocation(getHeight() / 3);
		rightSplitPane.add(centerSplitPane,JSplitPane.LEFT);
		
		centerTopView = new ImageTileView();
		centerSplitPane.add(centerTopView,JSplitPane.TOP);
		
		centerBottomView = new AnimationPropertyView();
		centerSplitPane.add(centerBottomView,JSplitPane.BOTTOM);
		
	
		//右边窗格
		rightSubSplitPane = new JSplitPane();
		rightSubSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		rightSubSplitPane.setDividerLocation(getHeight() / 2);
		rightSplitPane.add(rightSubSplitPane,JSplitPane.RIGHT);
		
		rightTopView = new FrameEditorView();
		rightSubSplitPane.add(rightTopView,JSplitPane.TOP);
		
		rightBottomView = new AnimationFrameView();
		rightSubSplitPane.add(rightBottomView,JSplitPane.BOTTOM);
	}
	
	
}
