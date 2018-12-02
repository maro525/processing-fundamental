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

public class GrowingCircle2 extends PApplet {

public void setup(){
  
  noFill();
  frameRate(10);
}

int d = 0;
int e = width;

public void draw(){
  background(40);
  if(d <= width){
    d = d + 1;
    for(int i=0; i<10; i++){
      for(int g=0; g<10; g++){
        stroke(255);
        ellipse(10+i*20,10+g*20,d,d);
      }
    }
  }
  if (d > width){
      e = e - 1;
      for(int i=0; i<10; i++){
        for(int g=0; g<10; g++){
          stroke(255);
          ellipse(10+i*20,10+g*20,e,e);
        }
      }
   }
    if (e <= 0 ){
      d = 0;
      e = width;
    }
}
  public void settings() {  size(200,200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "GrowingCircle2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
