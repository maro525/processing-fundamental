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

public class RandomCircle2 extends PApplet {
  public void setup() {

background(255);
strokeWeight(5);


float radius = 100;
float centx = width/2;
float centy = height/2;

stroke(0,30);
noFill();
ellipse(centx, centy, radius*2, radius*2);

stroke(20, 50, 70);
float x, y;
float lastx = -999;
float lasty = -999;

radius = 10;
float radiusNoise = random(10);

for(float ang = 0; ang <= 360*4; ang += 5){
    radius += 0.5f;
    radiusNoise += 0.05f;
    float thisRadius = radius + (noise(radiusNoise) * 200) - 100;
    float rad = radians(ang);
    x = centx + (thisRadius * cos(rad));
    y = centy + (thisRadius * sin(rad));
    if(lastx > -999){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
}
    noLoop();
  }

  public void settings() { size(500,300); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomCircle2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
