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

public class RandomlyApearingBoxes extends PApplet {

public void rectLine(int x, int y, int w, int h){
  line(x,y,x+w,y);
  line(x,y,x,y+h);
  line(x+w,y,x+w,y+h);
  line(x,y+h,x+w,y+h);
}

public int randomRGBcolor(){
  int c = color(random(256),random(256),random(256));
  return c;
}

public void setup(){
  
  background(255);
  colorMode(RGB,256);
  frameRate(10);
}

public void draw(){
  background(255);
  stroke( randomRGBcolor() );
  int x = PApplet.parseInt(random(width));
  int y = PApplet.parseInt(random(height));
  rectLine(x,y,30,30);
}
  public void settings() {  size(200,200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RandomlyApearingBoxes" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
