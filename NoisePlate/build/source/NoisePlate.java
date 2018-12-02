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

public class NoisePlate extends PApplet {
  public void setup() {


background(255);
float xstart = random(10);
float xnoise = xstart;
float ynoise = random(10);

for (int y = 0; y <= height; y += 1) {
    ynoise += 0.01f;
    xnoise = xstart;
    for (int x = 0; x <= width; x += 1){
        xnoise += 0.01f;
        int alph = PApplet.parseInt(noise(xnoise) * 255);
        stroke(0, alph);
        line(x, y, x+1, y+1);
    }
}
    noLoop();
  }

  public void settings() { size(1200, 900); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoisePlate" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
