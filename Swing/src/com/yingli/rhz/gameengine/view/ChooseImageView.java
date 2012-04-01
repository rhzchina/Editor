package com.yingli.rhz.gameengine.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import com.yingli.rhz.gameengine.util.MyImage;

/**
 * 动画使用的图片选择视图，位于左上窗格
 * 
 * @author 大钊
 * 
 */
public class ChooseImageView extends JPanel {
	private JToolBar toolBar;
	private JButton addImageBtn;
	private JButton delImageBtn;
	private JButton setIdBtn;

	private MyPanel imagePanel;
	private JScrollPane scrollPane;
	private String path = ".";

	private ArrayList<MyImage> imageGroup = new ArrayList<MyImage>();

	private int selectIndex = -1;
	private Color defaultColor;

	public ChooseImageView() {
		setLayout(new BorderLayout());
		init();

	}

	//

	private void init() {
		toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		// 工具条按钮
		addImageBtn = new JButton("添图");
		addImageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChoose = new JFileChooser(path) {
					public void approveSelection() {
						path = getSelectedFile().getPath();
						File file = new File(path);
						if (file.exists()) {
							super.approveSelection();
						} else {
							JOptionPane.showMessageDialog(null, "文件不存在，请重新选择");
						}
					}
				};
				fileChoose.setAcceptAllFileFilterUsed(false);
				fileChoose.addChoosableFileFilter(new FileFilter() {
					@Override
					public boolean accept(File f) {
						// TODO Auto-generated method stub
						if (f.isDirectory())
							return true;

						String name = f.getName();
						int index = name.lastIndexOf('.');

						if (index > 0 && index < name.length() - 1) {
							String extName = name.substring(index + 1)
									.toLowerCase();
							if (extName.equals("png")) {
								return true;
							}
						}
						return false;
					}

					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return "PNG图像文件(*.png)";
					}

				});

				int result = fileChoose.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String fileName = fileChoose.getSelectedFile()
							.getAbsolutePath();
					if (imageGroup.size() == 0)
						imageGroup.add(new MyImage(new File(fileName), 5, 0));
					else
						imageGroup.add(new MyImage(new File(fileName), 5,
								imageGroup.get(imageGroup.size() - 1)
										.getImageY()
										+ imageGroup.get(imageGroup.size() - 1)
												.getImageHeight()));
					updateView();

				}
			}
		});
		toolBar.add(addImageBtn);

		delImageBtn = new JButton("删图");
		delImageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectIndex != -1) {
					int tempHeight = imageGroup.get(selectIndex)
							.getTotalHeight();
					for (int i = selectIndex; i < imageGroup.size() - 1; i++) {
						imageGroup.get(i + 1).setY(
								imageGroup.get(i + 1).getIdY() - tempHeight);
					}
					imageGroup.remove(selectIndex);
					selectIndex = -1;
				}
				updateView();

			}
		});
		toolBar.add(delImageBtn);

		setIdBtn = new JButton("设置ID");
		setIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (imageGroup.size() != 0 && selectIndex != -1) {
					new JTextField().setVisible(true);
					imageGroup.get(selectIndex).setId("" + selectIndex);
					repaint();
				}
			}
		});
		toolBar.add(setIdBtn);

		// 显示选择图片面板，内部类
		imagePanel = new MyPanel();
		defaultColor = imagePanel.getBackground();
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(imagePanel);
		add(scrollPane, BorderLayout.CENTER);
	}

	private void updateView() {
		int maxWidth = 0;
		for (MyImage image : imageGroup) {
			if (image.getImageWidth() > maxWidth) {
				maxWidth = image.getImageWidth();
			}
		}
		if (imageGroup.size() != 0) {
			imagePanel.setBackground(Color.WHITE);
			imagePanel.setPreferredSize(new Dimension(maxWidth, imageGroup.get(
					imageGroup.size() - 1).getImageY()
					+ imageGroup.get(imageGroup.size() - 1).getImageHeight()));
		}else{
			imagePanel.setBackground(defaultColor);
		}
		imagePanel.revalidate();
		repaint();
	}

	class MyPanel extends JPanel {

		public MyPanel() {
			// setPreferredSize
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (imageGroup.size() != 0) {
						for (int i = 0; i < imageGroup.size(); i++) {
							if (imageGroup.get(i).isSelect(e.getX(), e.getY())) {
								selectIndex = i;
								repaint();
								break;
							}
						}
					}
				}
			});
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			for (int i = 0; i < imageGroup.size(); i++) {
				g.drawString(imageGroup.get(i).getID(), imageGroup.get(i)
						.getIdX(), imageGroup.get(i).getIdY());

				if (i == selectIndex) {
					Color temp = g.getColor();
					g.setColor(Color.RED);
					g.drawRect(imageGroup.get(i).getImageX() - 3, imageGroup
							.get(i).getImageY() - 3, imageGroup.get(i)
							.getImageWidth() + 3, imageGroup.get(i)
							.getImageHeight() + 3);
					g.setColor(temp);
				}

				g.drawImage(imageGroup.get(i).getImage(), imageGroup.get(i)
						.getImageX(), imageGroup.get(i).getImageY(), null);
			}
		}
	}

}
