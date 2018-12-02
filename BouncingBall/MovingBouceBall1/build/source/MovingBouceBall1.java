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

public class MovingBouceBall1 extends PApplet {

Spot sp;

public void setup() {
  
  
  noStroke();
  sp = new Spot(40, 160, 50, 3);
}

public void draw() {
  fill(0,30);
  sp.white();
  sp.cal();
  sp.display();
}


class Spot {
  float x, y;
  float diameter;
  float speed;
  int directionx = 1;
  int directiony = 1;

  Spot(float xx, float yy, float dia, float sp) {
    x = xx;
    y = yy;
    diameter = dia;
    speed = sp;
  }

  public void white() {
    rect(0, 0, width, height);
    fill(255);
  }

  public void cal() {
    x += (speed*directionx);
    y += (speed*directiony);
    text("x"+x,10,20);
    if ( (x>(width-diameter/2)) || (x<diameter/2)) {
      directionx *= -1;
    }
    if ( (y>(height-diameter/2)) || (y<diameter/2)) {
      directiony *= -1;
    }
    text("x"+x,10,30);
  }

  public void display() {
    ellipse(x, y, diameter, diameter);
  }
}
  public void settings() {  size(400, 400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "MovingBouceBall1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
