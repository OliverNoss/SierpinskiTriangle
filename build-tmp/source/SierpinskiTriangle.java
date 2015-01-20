import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int n = 243;
public void setup()
{
	size(486,486);
	background(0);
	// stroke(0,100,255);
	// strokeWeight(2);
	fill(255);
}
public void draw()
{
	background(0);
	sierpinski(162,162,162);
}
public void keyPressed()//optional
{
	if (key==CODED)
	{
		if (keyCode == UP && n>3)
			n/=3;
		if (keyCode == DOWN && n<243)
			n*=3;
	}
}
public void sierpinski(int x, int y, int side) //for carpet, x,y is upper left corner
{
	
	 
	if (side>=2*n)
	{
		sierpinski(x+side/3,y-side*2/3,side/3);
		sierpinski(x+side/3,y+side+side*1/3,side/3);
		sierpinski(x-2*side/3,y+side/3,side/3);
		sierpinski(x+4*side/3,y+side/3,side/3);
		sierpinski(x+4*side/3,y-2*side/3,side/3);
		sierpinski(x+4*side/3,y+4*side/3,side/3);
		sierpinski(x-2*side/3,y+side/3,side/3);
		sierpinski(x-2*side/3,y-2*side/3,side/3);
		sierpinski(x-2*side/3,y+4*side/3,side/3);
		
		rect(x,y,side,side);
	}
	else {
			rect(x, y, side,side);
			}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
