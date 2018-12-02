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

public class wave_random extends PApplet {

float yoff = 0.0f;

public void setup() {
  
  noStroke();
}

public void draw() {
  background(247,152,152);

  fill(255);
  beginShape();
  float xoff = 0;
  for (float x = 0; x <= width; x += 10) {
    float y = map(noise(xoff, yoff), 0, 1, height*0.1f,height*0.7f);
  //map\u306f0-1\u3067\u51fa\u529b\u3055\u308c\u305fnoise\u3092200-300\u306e\u9593\u306e\u6570\u306b\u76f4\u3057\u307e\u3059\u3002
    vertex(x, y);
    xoff += 0.05f;
  }
  yoff += 0.01f;
  vertex(width, height);
  vertex(0, height);
  endShape(CLOSE);
}
  public void settings() {  size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "wave_random" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
