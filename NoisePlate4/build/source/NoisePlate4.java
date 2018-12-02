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

public class NoisePlate4 extends PApplet {

float xstart, xnoise, ynoise;

public void setup() {

    
    
    background(0);
    xstart = random(10);
    xnoise = xstart;
    ynoise = random(10);

    for (int y = 0; y <= height; y += 5) {
        ynoise += 0.1f;
        xnoise = xstart;
        for (int x = 0; x <= width; x += 5){
            xnoise += 0.1f;
            drawPoint(x, y, noise(xnoise, ynoise));
        }
    }
}

public void drawPoint(float x, float y, float noiseFactor){
    pushMatrix();
    translate(x, y);
    rotate(noiseFactor * radians(540));
    float edgeSize = noiseFactor * 35;
    float grey = 150 + (noiseFactor * 120);
    float alpha = 150 + (noiseFactor * 120);
    noStroke();
    fill(grey, alpha);
    ellipse(0, 0, edgeSize, edgeSize/2);
    popMatrix();
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoisePlate4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
