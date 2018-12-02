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

public class RandomCircle4 extends PApplet {

public void setup(){
    
    background(255);
    strokeWeight(5);
    

    float radius = 200;

    stroke(0, 30);
    noFill();
    ellipse(width/2, height/2, radius*2, radius*2);

    stroke(20, 50, 70);
    strokeWeight(1);

    float x, y;
    float noiseVal = random(10);
    float radVariance, thisRadius, rad;
    beginShape();
    fill(20, 50, 70, 50);
    for(float ang = 0; ang <= 360; ang += 1){
        noiseVal += 0.1f;
        radVariance = 60 * customNoise(noiseVal);

        thisRadius = radius + radVariance;
        rad = radians(ang);
        x = width/2 +  (thisRadius * cos(rad));
        y = height/2 + (thisRadius * sin(rad));

        curveVertex(x,y);
    }
    endShape();
}

public float customNoise(float value){
    int count = PApplet.parseInt((value % 12));
    float retValue = pow(sin(value), count);
    return retValue;
}
  public void settings() {  size(1200, 900);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "RandomCircle4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
