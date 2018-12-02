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

public class NoisePlate5 extends PApplet {

float xstart, xnoise, ystart, ynoise;
float xstartNoise, ystartNoise;

public void setup() {

    
    
    background(0);
    frameRate(24);

    xstartNoise = random(20);
    ystartNoise = random(20);
    xstart = random(10);
    ystart = random(10);
}

public void draw(){
    background(0);

    xstart += 0.01f;
    ystart += 0.01f;

    xnoise = xstart;
    ynoise = ystart;

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
    fill(grey, alpha);
    ellipse(0, 0, edgeSize, edgeSize/2);
    popMatrix();
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoisePlate5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
