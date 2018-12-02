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

public class MovingBouceBall2 extends PApplet {


float Friction = 0.99f;
float x,y,spx,spy;
int radius = PApplet.parseInt(random(10,60));


public void setup(){
  
  colorMode(HSB,100);
  background(99);
  noStroke();
  frameRate(15);
  spx = random(-30,30);
  spy = random(-30,30);
  x = random(0,width);
  y = random(0,height);
}

public void draw(){
  white();
  cal();
  bounce();
  fill(randomcolor());
  ellipse(x,y,radius*2,radius*2);
}

public int randomcolor(){
  int c = color(random(100),random(100),random(100));
  return c;
}

public void white(){
  noStroke();
  fill(99,80);
  rectMode(CORNER);
  rect(0,0,width,height);
}

public void cal(){
  spx *=Friction;
  spy *=Friction;
  x += spx;
  y += spy;
}

public void bounce(){
  float bounceminx = radius;
  float bouncemaxx  = width - radius;
  float bounceminy = radius;
  float bouncemaxy = height - radius;

  if(x<bounceminx || x>bouncemaxx){
    spx *= -0.8f;
    if(x<bounceminx) x = bounceminx-(x-bounceminx);
    if(x>bouncemaxx) x = bouncemaxx-(x-bouncemaxx);
  }

  if(y<bounceminy || y>bouncemaxy){
    spy *= -0.9f;
    if(y<bounceminy) y = bounceminy-(y-bounceminy);
    if(y>bouncemaxy) y = bouncemaxy-(y-bouncemaxy);
  }
}
  public void settings() {  size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "MovingBouceBall2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
