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

public class RandomCircle3 extends PApplet {
  public void setup() {

background(255);
strokeWeight(0.5f);


float centx = width/2;
float centy = height/2;

float x, y;
for (int i = 0; i < 100; i++){
    float lastx = -999;
    float lasty = -999;
    float radiusNoise = random(10);
    float radius = 10;
    stroke(random(20), random(50), random(70), 80);
    int startangle = PApplet.parseInt(random(360));
    int endangle =  1440 + PApplet.parseInt(random(1440));
    int anglestep = 5 + PApplet.parseInt(random(3));

    for(float ang = startangle; ang <= endangle; ang += anglestep){
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
}
    noLoop();
  }

  public void settings() { size(1200,900); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomCircle3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
