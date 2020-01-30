package uiLibrary;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;

public class Button{
	int x, y, width, height;
	BufferedImage[] images;
	Rectangle bounds;
	ClickListener clicker;
	UIManager uiManager;
	
	public Mouse mouse;
	public Button(int x, int y, int width, int height, BufferedImage[] images, ClickListener clicker, Mouse mouse) {
		bounds = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.images = images;
		this.clicker = clicker;
		this.mouse = mouse;
	}
	public boolean onButton() {
		if(bounds.contains(mouse.getMouseX(), mouse.getMouseY())) {
			return true;
		}
		return false;
	}
	public boolean isPressed() {
		if(onButton()) {
			if(mouse.leftPressed || mouse.rightPressed) {
				if(clicker != null)
				clicker.onClick();
				
				return true;
			}
	}
		return false;
}
	
	
	///////////////////////////
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BufferedImage[] getImages() {
		return images;
	}
	public void setImages(BufferedImage[] images) {
		this.images = images;
	}
	
}
