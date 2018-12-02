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

public class ThreeBoucingBallsInDifferentSpeed extends PApplet {

Spot sp1, sp2, sp3; //\uff13\u3064\u306e\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u3092\u5ba3\u8a00
public void setup(){
  
  
  noStroke();
  sp1 = new Spot(100,200,80,2);
  sp2 = new Spot(200,200,20,5);
  sp3 = new Spot(300,50,60,3);
}

public void draw(){
  fill(0,15);
  rect(0,0,width,height);
  fill(255);
  sp1.move();
  sp2.move();
  sp3.move();
  sp1.display();
  sp2.display();
  sp3.display();
}

class Spot {
  float x, y;
  float diameter;
  float speed;
  int direction = 1;
  Spot(float xpos, float ypos, float dia, float sp){
    x = xpos;
    y = ypos;
    diameter = dia;
    speed = sp;
  }
  public void move(){
    y += (speed * direction);
    if( ( y>(height-diameter/2) ) || ( y<diameter/2) ) {
      direction *= -1;
    }
  }
  public void display(){
    ellipse(x,y,diameter,diameter);
  }
}
  public void settings() {  size(400,400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "ThreeBoucingBallsInDifferentSpeed" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
