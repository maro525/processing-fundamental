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

public class MovingBox extends PApplet {

float X,Y;
float SpX,SpY;

public void setup(){
  
  colorMode(RGB,100);
  background(99);
  frameRate(15);

  //\u4f4d\u7f6e\u3068\u30b9\u30d4\u30fc\u30c9\u306e\u521d\u671f\u5316
  X = 0;
  Y = height;
  SpX = 1;
  SpY = -2;
}

public void draw(){
  fadetowhite();

  //\u4f4d\u7f6e\u306e\u8a08\u7b97
  X = X + SpX;
  Y = Y + SpY;

  //\u63cf\u753b
  noStroke();
  fill(0);
  rectMode(CENTER);
  rect(X,Y,10,10);
}

public void fadetowhite(){
  noStroke();
  fill(99,30);
  rectMode(CORNER);
  rect(0,0,width,height);
}
  public void settings() {  size(200,200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "MovingBox" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
