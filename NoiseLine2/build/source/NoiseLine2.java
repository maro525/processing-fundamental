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

public class NoiseLine2 extends PApplet {
  public void setup() {

background(255);
strokeWeight(5);


float xstep = 1;
float lastx = -999;
float lasty = -999;
float angle = 0;
float y = 50;
int border = 20;

// float customRandom(){
//     float retValue = 1 - pow(random(1), 5);
//     return retValue;
// }


for (int x = border; x <= width - border; x += xstep){
    float rad = radians(angle);
    // y = height/2 + (pow(sin(rad), 3) * 40);
    // y = height/2 + (pow(sin(rad), 3) * noise(rad*2) * 40);
    // y = height/2 + (customRandom() * 40); // \u30a8\u30e9\u30fc\u304c\u51fa\u308b
    y = height/2 + (1 - pow(random(1), 5)) * 40;
    if ( lastx > -999){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
    angle++;
}
    noLoop();
  }

  public void settings() { size(1000,200); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "NoiseLine2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
