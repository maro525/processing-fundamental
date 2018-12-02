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

public class Object_Circle extends PApplet {

int _num = 10;
Circle[] _circleArr = {};

public void setup(){
    
    background(255);
    
    strokeWeight(1);
    fill(150, 50);
    drawCircles();
}

public void draw(){
    background(255);
    for (int i = 0; i < _circleArr.length; i++) {
        Circle thisCirc = _circleArr[i];
        thisCirc.updateMe();
    }
}

public void mouseReleased(){
    drawCircles();
}

public void drawCircles(){
    for(int i = 0; i < _num; i++){
        Circle thisCirc = new Circle();
        // thisCirc.drawMe();
        thisCirc.updateMe();
        _circleArr = (Circle[])append(_circleArr, thisCirc);
    }
}


//================================JSONObject
class Circle {
    float x, y;
    float radius;
    int linecol, fillcol;
    float alph;
    float xmove, ymove;

    Circle () {
        x = random(width);
        y = random(height);
        radius = random(100) + 10;
        linecol = color(random(255), random(255), random(255));
        // linecol = 10;
        fillcol = color(random(255), random(255), random(255));

        alph = random(255);
        xmove = random(10) - 5;
        ymove = random(10) - 5;
    }

    public void drawMe() {
        noStroke();
        fill(fillcol, alph);
        // noFill();
        ellipse(x, y, radius*2, radius*2);
        stroke(linecol, 150);
        noFill();
        ellipse(x, y, 10, 10);
    }

    public void updateMe(){
        x += xmove;
        y += ymove;
        if (x > (width + radius)) { x = 0 - radius; }
        if (x < (0 - radius)) { x = width + radius; }
        if (y > (height + radius)) { y = 0 - radius; }
        if (y < (0 - radius)) { y = height + radius; }

        for (int i = 0; i < _circleArr.length; i++){
            Circle otherCirc = _circleArr[i];
            if (otherCirc != this) {
                float dis = dist(x, y, otherCirc.x, otherCirc.y);
                float overlap = dis - radius - otherCirc.radius;
                if (overlap < 0) {
                    float midx, midy;
                    midx = (x + otherCirc.x) / 2;
                    midy = (y + otherCirc.y) / 2;
                    stroke(0, 100);
                    noFill();
                    overlap *= -1;
                    ellipse(midx, midy, overlap, overlap);
                }
            }
        }

        // drawMe();
    }
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Object_Circle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
