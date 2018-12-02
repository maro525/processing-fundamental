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

public class RandomCircle extends PApplet {
  public void setup() {

background(255);
strokeWeight(5);


float radius = 300;

stroke(0,30);
noFill();
ellipse(width/2, height/2, radius*2, radius*2);

stroke(20, 50, 70);
float x, y;
float lastx = -999;
float lasty = -999;

for(float ang = 0; ang <= 360; ang += 5){
    float rad = radians(ang);
    x = width/2 + (radius * cos(rad));
    y = height/2 + (radius * sin(rad));
    point(x, y);
}
    noLoop();
  }

  public void settings() { size(1200,800); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomCircle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
