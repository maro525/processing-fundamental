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

public class MovingBouceBall3 extends PApplet {

Calc cal;
Display disp;

public void setup() {
  
  colorMode(RGB,256);
  background(255);
  
  noStroke();
  Spot sp = new Spot(random(20,width-20),random(20,height-20),random(20,100),3,random(255),random(255),random(255));
  cal = new Calc(sp);
  disp = new Display(sp);
}

public void draw() {
  disp.white();
  cal.calcu();
  disp.circle();
}

public class Spot {
  public float x, y, diameter, speed;
  public int directionx=1, directiony=1;
  public float r,g,b;
  public boolean exp1,exp2;

  Spot(float xx, float yy, float dia, float spd, float colR,float colG,float colB) {
    x = xx;
    y = yy;
    diameter = dia;
    speed = spd;
    r = colR; g = colG; b = colB;
  }
}

private class Calc {
  Spot csp;

  Calc(Spot cspn) {
    csp = cspn;
  }

  public void calcu() {
    float x = csp.x;
    float y = csp.y;
    float speed = csp.speed;
    int directionx = csp.directionx;
    int directiony = csp.directiony;
    float diameter = csp.diameter;
    x += (speed*directionx);
    y += (speed*directiony);
    if ( (x>(width-diameter/2)) || (x<diameter/2)) {
      directionx *= -1;
      y += random(-20,20);
      csp.r = random(1,255);
      csp.g = random(1,255);
      csp.b = random(1,255);
      csp.exp1 = true;
    }
    if ( (y>(height-diameter/2)) || (y<diameter/2)) {
      directiony *= -1;
      speed +=random(-1,1);
      csp.r = random(1,255);
      csp.g = random(1,255);
      csp.b = random(1,255);
      csp.exp2 = true;
    }
    csp.x = x;
    csp.y = y;
    csp.speed = speed;
    csp.directionx = directionx;
    csp.directiony = directiony;
    csp.diameter = diameter;
  }
}

private class Display {
  Spot dsp;

  Display(Spot spn) {
    dsp = spn;
  }

  public void circle() {
    float x = dsp.x;
    float y = dsp.y;
    float diameter = dsp.diameter;
    fill(dsp.r,dsp.g,dsp.b);
    ellipse(x, y, diameter, diameter);
  }



  public void white() {
    noStroke();
    fill(255, 30);
    rectMode(CORNER);
    rect(0, 0, width, height);
  }
}
  public void settings() {  size(400, 400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "MovingBouceBall3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
