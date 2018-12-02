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

public class ShapeChangingLinesOnCircle2 extends PApplet {

float x,y,cx,cy;

public void setup(){
  
  cx = width/2;
  cy = height/2;
}

public void draw(){
  background(255);
  for(int i=0; i<18; i++){
    x = cx + ( 250*cos(radians(20*i)) );
    y = cy + ( 250*sin(radians(20*i)) );
    line(mouseX,mouseY,x,y);
  }
}
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "ShapeChangingLinesOnCircle2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
