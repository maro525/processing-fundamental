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

public class Circle extends PApplet {

Spot sp;

public void setup(){
  
  
  noStroke();
  sp = new Spot(150,200,100); //\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u3092\u751f\u6210
}

public void draw(){
  background(0);
  sp.display();
}

class Spot {
  float x, y, diameter;

  Spot(float xpos, float ypos, float dia){
    x = xpos; // x\u306b150\u3092\u8a2d\u5b9a
    y = ypos; // y\u306b200\u3092\u8a2d\u5b9a
    diameter = dia; // \u76f4\u5f84\u306b100\u3092\u8a2d\u5b9a
  }

  public void display(){
    ellipse(x,y,diameter,diameter);
  }
}
  public void settings() {  size(400,400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Circle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
