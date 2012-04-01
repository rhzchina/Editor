package com.yingli.rhz.gameengine.util;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {

	private int imageX;
	private int imageY;
	private int idX;
	private int idY;

	private Image image;
	private String id = "";

	public MyImage(File f, int x, int y) {
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageX = x;
		idX = x;
		idY = y + 20;
		imageY = idY + 5;
	}

	public Image getImage() {
		return image;
	}

	public String getID() {
		return id;
	}

	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}

	public int getIdX() {
		return idX;
	}

	public int getIdY() {
		return idY;
	}
	
	public int getImageWidth(){
		return image.getWidth(null);
	}
	
	public int getImageHeight(){
		return image.getHeight(null);
	}
	
	public int getTotalHeight(){
		return imageY + image.getHeight(null) - idY + 20;
	}
	
	public void setId(String s){
		id = s;
	}
	
	public void setX(int x){
		imageX = x;
		idX = x;
	}
	
	public void setY(int y){
		idY = y;
		imageY = idY + 5;
	}
	

	public boolean isSelect(int x, int y) {
		return new Rectangle(imageX, imageY,image.getWidth(null),image.getHeight(null)).contains(x, y);
	}

}
