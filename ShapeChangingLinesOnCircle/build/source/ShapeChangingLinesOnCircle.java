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

public class ShapeChangingLinesOnCircle extends PApplet {

public void setup(){
  
}

public void draw(){
    background(255);
    translate(width/2,height/2);
    for(int i=0; i<18; i++){
      rotate(PI/9);
      line(mouseX-width/2,mouseY-height/2,100,0);
    }
}

  
  public void settings() {  size(250,250); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ShapeChangingLinesOnCircle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
