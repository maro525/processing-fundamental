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

public class SlowlyBoucingBall extends PApplet {

Spot sp;

public void setup(){
  
  
  noStroke();
  sp = new Spot(150,200,100,3); //\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u3092\u751f\u6210
}

public void draw(){
  fill(0,15);
  rect(0,0,width,height);
  fill(255);
  sp.move();
  sp.display();
}

class Spot {
  float x, y;
  float diameter;
  float speed;
  int direction = 1; //\u52d5\u304d\u306e\u5411\u304d\uff08\uff11\u3000\u964d\u4e0b\u3001\u3000\u2212\uff11\u3000\u4e0a\u6607)

  //\u30b3\u30f3\u30b9\u30c8\u30e9\u30af\u30bf\u30fc
  Spot(float xpos,float ypos, float dia ,float sp) {
    x = xpos;
    y = ypos;
    diameter = dia;
    speed = sp;
  }

  public void move(){
    y += (speed * direction);
    if ( (y > (height - diameter / 2) ) || ( y < diameter /2 ) ) {
      direction *= -1;

  }
  }


  public void display(){
    ellipse(x,y,diameter,diameter);
  }
}
  public void settings() {  size(400,400);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "SlowlyBoucingBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
