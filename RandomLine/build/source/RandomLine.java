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

public class RandomLine extends PApplet {
  public void setup() {

background(255);
strokeWeight(5);


int step = 10;
float lastx = -9990;
float lasty = -9990;
float y = 50;
int borderx = 20;
int bordery = 10;

for (int x = borderx; x <= width - borderx; x += step){
    y = bordery + random(height - 2*bordery);
    if (lastx > -9990){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
}
    noLoop();
  }

  public void settings() { size(1200,800); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomLine" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
