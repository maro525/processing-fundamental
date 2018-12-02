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

public class AcceleratingBox extends PApplet {

public void setup(){
  
  colorMode(HSB,100);
  background(99);
  frameRate(15);

  X = Y = 0;
  Spx = Spy = 0;
  Acx = Acy = 0.5f;
}

float X,Y;
float Spx,Spy;
float Acx,Acy;

public void draw(){
  fadetowhite();

  Spx = Spx + Acx;
  Spy = Spy + Acy;
  if(Spx > Max) Spx = Max;
  if(Spy > Max) Spy = Max;
  X = X + Spx;
  Y = Y + Spy;

  noStroke();
  fill(0);
  rectMode(CENTER);
  rect(X,Y,10,10);
}

float Max = 10;

public void fadetowhite(){
  noStroke();
  fill(99,30);
  rectMode(CORNER);
  rect(0,0,width,height);
}
  public void settings() {  size(200,200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "AcceleratingBox" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
