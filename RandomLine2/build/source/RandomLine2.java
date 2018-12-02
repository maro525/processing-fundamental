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

public class RandomLine2 extends PApplet {
  public void setup() {

background(255);
strokeWeight(5);


float xstep = 10;
float ystep = 10;
float lastx = 20;    ;
float lasty = height/2;
float y = height/2;

for (int x = 20; x <= width-20; x += xstep){
    ystep = random(height/8) - height/8/2;
    y += ystep;
    line(x, y, lastx, lasty);
    lastx = x;
    lasty = y;
}
    noLoop();
  }

  public void settings() { size(1200,800); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomLine2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
