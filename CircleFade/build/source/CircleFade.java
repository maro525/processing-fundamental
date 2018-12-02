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

public class CircleFade extends PApplet {

int diam = 10;
float centX, centY;

public void setup(){
    
    frameRate(24);

    
    background(108);
    centX = width / 2;
    centY = height / 2;
    stroke(0);
    strokeWeight(1);
    fill(255, 25);
}

public void draw(){
    if (diam <= 800){
        ellipse(centX, centY, diam, diam);
        diam += 10;
    }
}
  public void settings() {  size(1200, 800);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "CircleFade" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
