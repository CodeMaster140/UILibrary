package uiLibrary;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;


public class UIManager {
	ArrayList<Button> buttons= new ArrayList<Button>();
	int index, currentButton;
	boolean removing = false;
	public Mouse mouse;
	public UIManager(Mouse mouse) {
		this.mouse = mouse;
	}
	public void update(Graphics g){
		if(!removing && buttons.size() > 0)
			for(int i = 0;i<buttons.size();i++) {
				if(buttons.get(i).onButton()) {
					currentButton = i;
					g.drawImage(buttons.get(i).images[0], buttons.get(i).x, buttons.get(i).y, buttons.get(i).width, buttons.get(i).height, null);
					buttons.get(i).isPressed();
				} else {
					g.drawImage(buttons.get(i).images[1], buttons.get(i).x, buttons.get(i).y, buttons.get(i).width, buttons.get(i).height, null);
				}
				
				
			}
		if(removing) {
			buttons.remove(index);
			removing = false;
			}
	}
	public void addButton(int x, int y, int width, int height, BufferedImage[] images, String id, ClickListener clicker) {
		buttons.add(new Button(x, y, width, height, images, clicker, mouse));
		
	}
	public void removeButton(int index, String id) {
		removing = true;
		this.index = index;
	}
	public void removeButton() {
		removing = true;
		index = currentButton;
	}
	public void clearButton() {
		System.out.println("INCOMPLETE");
	}
	
}
