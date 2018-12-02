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

public class Spring extends PApplet {

float dy; //\u901f\u5ea6
float y; //\u4f4d\u7f6e
float g = 0.9f; //\u91cd\u529b\u52a0\u901f\u5ea6
float mass = 5; //\u8cea\u91cf
float stiffness = 0.15f; //\u30d0\u30cd\u306e\u5f37\u3055
float damping = 0.98f; //\u6e1b\u8870
int r = 5;
float my = 50; //\u30d0\u30cd\u306e\u9577\u3055

public void setup(){
  
  fill(0);
  y = my;
}

public void draw(){
  background(255);
  if(mousePressed){
    y = mouseY;
  } else {
    calcpos();
  }
  line(width/2,0,width/2,y);
  ellipse(width/2,y,r*2,r*2);
}
public void calcpos(){
  float forcey = (my-y) * stiffness; //\u30d0\u30cd\u306b\u50cd\u304f\u529b
  float ay = forcey / mass; //\u30d0\u30cd\u306b\u3088\u308b\u52a0\u901f\u5ea6\u3092\u8a08\u7b97
  dy = damping * (dy + ay + g); //\u901f\u5ea6\u8a08\u7b97
  y = y + dy; //y\u5ea7\u6a19\u3092\u52d5\u304b\u3059
}
  public void settings() {  size(125,250); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Spring" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
