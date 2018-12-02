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

public class LineFade extends PApplet {
  public void setup() {

background(180);
strokeWeight(4);
strokeCap(SQUARE);

for(int h = 10; h <= (height - 15); h += 10){
    stroke(0, 255-h);
    line(10, h, width - 20, h);
    stroke(255, h);
    line(10, h+4, width-20, h+4);
}
    noLoop();
  }

  public void settings() { size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "LineFade" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
