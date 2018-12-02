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

public class RandomCircle5 extends PApplet {

float _angnoise, _radiusnoise;
float _xnoise, _ynoise;
float _angle = -PI/2;
float _radius;
float _strokeCol = 254;
int _strokeChange = -1;

public void setup(){

    
    
    frameRate(30);
    background(255);
    noFill();

    _angnoise = random(10);
    _radiusnoise = random(10);
    _xnoise = random(10);
    _ynoise = random(10);
}

public void draw(){

    background(255);

    _radiusnoise += 0.005f;
    _radius = (noise(_radiusnoise) * 900) + 1;

    _angnoise += 0.005f;
    _angle += (noise(_angnoise) * 6) - 3;
    if (_angle > 360) { _angle -= 360; }
    if (_angle < 0) { _angle += 360; }

    _xnoise += 0.01f;
    _ynoise += 0.01f;
    float centerx = width/2 + (noise(_xnoise) * 200) - 100;
    float centery = height/2 + (noise(_ynoise) * 200) - 100;

    float rad = radians(_angle);
    float x1 = centerx + (_radius * cos(rad));
    float y1 = centery + (_radius * sin(rad));
    float opprad = rad + PI;
    float x2 = centerx + (_radius * cos(opprad));
    float y2 = centery + (_radius * sin(opprad));

    _strokeCol += _strokeChange;
    if(_strokeCol > 254) { _strokeChange = -1; }
    if(_strokeCol < 0) { _strokeChange = 1; }
    // stroke(_strokeCol, 60);
    // strokeWeight(1);
    // line(x1, y1, x2, y2);

    beginShape();
    fill(20, 50, 70, 50);
    for(float ang = 0; ang <= 361; ang += 1){
        // noiseVal += 0.1;
        // radVariance = 60 * customNoise(noiseVal);

        // thisRadius = radius + radVariance;
        rad = radians(ang);
        float x = centerx + (_radius * cos(rad));
        float y = centery + (_radius * sin(rad));

        curveVertex(x,y);
    }
    endShape();
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomCircle5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
