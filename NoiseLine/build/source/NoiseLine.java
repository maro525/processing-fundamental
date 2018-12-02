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

public class NoiseLine extends PApplet {

int step = 1;
float lastx = 0;
float lasty = 0;
float ynoise = random(10);
float y;
int border = 20;

public void setup(){
    
    frameRate(3);
    
}


public void draw(){
    background(255);

    strokeWeight(5);
    stroke(0, 50);
    line(0, height/2, width, height/2);

    stroke(20, 50, 70);
    for (int x = border; x <= width-border; x += step){
        y = border + noise(ynoise) * (height-border*2);
        if (x != border){
                line(x, y, lastx, lasty);
        }
        lastx = x;
        lasty = y;
        ynoise += 0.01f;
    }
}
  public void settings() {  size(1200,800);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoiseLine" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
