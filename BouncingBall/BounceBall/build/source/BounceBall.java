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

public class BounceBall extends PApplet {

Calc cal;
Display disp;
Calcbounce calb;

public void setup() {
  
  colorMode(RGB,256);
  background(255);
  
  noStroke();
  Spot sp = new Spot(random(20,width-20),30,random(10,50));
  Spot sp2 = new Spot(random(20,width-20),30,random(10,50));
  cal = new Calc(sp);
  disp = new Display(sp);
  calb = new Calcbounce(sp);
  cal = new Calc(sp2);
  disp = new Display(sp2);
  calb = new Calcbounce(sp2);
}

public void draw() {
  disp.white();
  cal.calcu();
  disp.circle();
}

class Spot {
  public float x, y, diameter, speed;
  public float r = random(255),g = random(255),b= random(255);
  public float acx = random(-20,20),acy = random(-30,0);
  public float grav = 3,fric = 0.8f;

  Spot(float xx, float yy, float dia) {
    x = xx;
    y = yy;
    diameter = dia;
  }
}

private class Calc {
  Spot csp;

  Calc(Spot cspn) {
    csp = cspn;
  }

  public void calcu() {
    csp.x += csp.acx;
    csp.acy += csp.grav;
    csp.y += csp.acy;
    calb.bounce();
  }
}

private class Calcbounce {
  Spot cbsp;

  Calcbounce(Spot cbspn){
    cbsp = cbspn;
  }

  public void bounce(){
    if((cbsp.x<cbsp.diameter/2)||(cbsp.x>(width-cbsp.diameter/2))){
      cbsp.acx = -cbsp.acx*cbsp.fric;
      cbsp.r += random(5.20f);
      cbsp.g += random(5.20f);
      cbsp.b += random(5.20f);
      if(cbsp.x<cbsp.diameter/2) cbsp.x = cbsp.diameter/2-(cbsp.x-cbsp.diameter/2);
      if(cbsp.x>(width-cbsp.diameter/2)) cbsp.x = (width-cbsp.diameter/2)-(cbsp.x-(width-cbsp.diameter/2));
    }

    if((cbsp.y<cbsp.diameter/2)||(cbsp.y>(width-cbsp.diameter/2))){
      cbsp.acy = -cbsp.acy*cbsp.fric;
      cbsp.r += random(5.20f);
      cbsp.g += random(5.20f);
      cbsp.b += random(5.20f);
      if(cbsp.y<cbsp.diameter/2) cbsp.y = cbsp.diameter/2-(cbsp.y-cbsp.diameter/2);
      if(cbsp.y>(width-cbsp.diameter/2)) cbsp.y = (width-cbsp.diameter/2)-(cbsp.y-(width-cbsp.diameter/2));
    }
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
    String[] appletArgs = new String[] { "BounceBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
