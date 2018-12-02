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

public class NoisePlate2 extends PApplet {

float xstart, xnoise, ynoise;

public void setup() {

    
    
    background(255);
    float xstart = random(10);
    float xnoise = xstart;
    float ynoise = random(10);

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
    float len = 10 * noiseFactor;
    rect(x, y, len, len);
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoisePlate2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
