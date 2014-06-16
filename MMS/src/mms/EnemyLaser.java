package mms;


import static org.lwjgl.opengl.GL11.*;


import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import entities.AbstractMoveableEntity;
import entities.Entity;
	
public class EnemyLaser extends AbstractMoveableEntity{
	private Texture texture = null; 
	
	public EnemyLaser(double x, double y, double width, double height) {
		super(x, y, width, height);
		try{
			this.texture = TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/laser.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public boolean intersects(Entity other) {
		hitbox.setBounds((int)((x < other.getX()) ? x - width/2 : x) , (int)( y - height/2), (int) width, (int) height);
		return hitbox.intersects(other.getX(), other.getY(), (other.getX() < x ) ? other.getWidtH()-other.getWidtH()/2 : other.getWidtH(),
				other.getHeight()-other.getHeight()/5);
	}

	@Override
	public void draw() {
		texture.bind();
		
		glLoadIdentity();
		glTranslated(x, y, 0);
		glBegin(GL_QUADS);
//		glBegin(G_)
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f((float)width, 0);
		glTexCoord2f(1, 1);
		glVertex2f((float)width, (float)height);
		glTexCoord2f(0, 1);
		glVertex2f(0, (float)height);
		glEnd();
		glLoadIdentity();	
		
//		glColor3f(0, 1, 0);
//		glBegin(GL_QUADS);
//		glVertex2d(x, y);
//		glVertex2d(x + width, y);
//		glVertex2d(x + width, y + height);
//		glVertex2d(x, y + height);
//		glEnd();
	}

}

