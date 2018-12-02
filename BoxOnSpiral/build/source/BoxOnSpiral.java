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

public class BoxOnSpiral extends PApplet {
  public void setup() {

colorMode(HSB,100);
background(99);
noStroke();

noFill();
rectMode(CENTER);

translate(100,100);
int angle = 30;
int x = 3;

for(int i =0; i<50; i++){
  stroke(i+10,299,299);

  pushMatrix();
  rotate(radians(angle*i));
  translate(i*x,0);
  rect(0,0,10,10);
  popMatrix();
}
    noLoop();
  }

  public void settings() { size(200,200); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BoxOnSpiral" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
