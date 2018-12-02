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

public class BezierAndCurveCornersCalculator extends PApplet {

/*
 *  Title: Bezier And Curve Corners Calculator
 *  Built With Processing
 *
 *  Created by Shin Nakamura  (Basic Werk)
 *  Copyright 2011 Tokyo JAPAN. All rights reserved.
 *
 */

float[] x = new float[4];
float[] y = new float[4];
int cnt = -1;
boolean ch = false;

public void setup() {
  
  background(255);
  
  noLoop();

  //randomize corner positions when reloaded
  float w = width, h = height;
  float xR = random(-w/10,w/10);
  float yR = random(-h/10,h/10);

  x[0] = w/3 + xR;
  y[0] = h/3 + yR;
  x[1] = w/1.6f - xR;
  y[1] = h/4.2f - yR;
  x[2] = w/8 - xR;
  y[2] = h/1.25f - yR;
  x[3] = w/1.16f + xR;
  y[3] = h/1.4f + yR;
}

public void draw() {
  background(255);

  //draw bezier, curve and lines
  noFill();
  stroke(0);
  strokeWeight(3);
  bezier(x[0],y[0],x[1],y[1],x[2],y[2],x[3],y[3]);
  stroke(200,0,0);
  curve(x[0],y[0],x[1],y[1],x[2],y[2],x[3],y[3]);
  stroke(222);
  strokeWeight(0.5f);
  line(x[0],y[0],x[1],y[1]);
  line(x[1],y[1],x[3],y[3]);
  line(x[3],y[3],x[2],y[2]);
  line(x[2],y[2],x[0],y[0]);

  //numbering corners
  textSize(18);
  textAlign(CORNER);
  fill(0,199);
  for (int i = 0; i < 4; i++) {
    text(i + 1,x[i],y[i]);
  }

  //text area
  float tAlp = 119;
  textSize(16);
  fill(19,29,59,tAlp);
  text("Click or Drag Corners 1 ~ 4", 10, 20);
  fill(0,tAlp);
  String pos = round(x[0]) + ", " + round(y[0]) + ", "
    + round(x[1]) + ", " + round(y[1]) + ", "
    + round(x[2]) + ", " + round(y[2]) + ", "
    + round(x[3]) + ", " + round(y[3]);
  text("bezier(" + pos + ");",10,40);
  fill(200,0,0,tAlp);
  text("curve(" + pos + ");",10,60);

  //point next corner
  if (ch == false) {
    cnt++;
  }
  if (cnt > 3) {
    cnt = 0;
  }
  noStroke();
  fill(28,119,249,99);
  float cx = x[cnt],cy = y[cnt];
  ellipse(cx,cy,20,20);

  //draw end
  noLoop();
}

public void mouseReleased() {
  if (cnt >= 0) {
    x[cnt] = mouseX;
    y[cnt] = mouseY;
    //change to next corner
    ch = false;
    loop();
  }
}

public void mouseDragged() {
  if (cnt >= 0) {
    x[cnt] = mouseX;
    y[cnt] = mouseY;
    //Do Not change to next corner
    ch = true;
    loop();
  }
}

public void keyPressed() {

  if (key == 's') {
    save("SN_P5_BCC_" + year() + month() + day() + hour() + minute() + second() + ".png"); //save image
  }

}
  public void settings() {  size(400,500);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BezierAndCurveCornersCalculator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
