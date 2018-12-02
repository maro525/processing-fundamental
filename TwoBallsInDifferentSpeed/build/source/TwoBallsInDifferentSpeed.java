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

public class TwoBallsInDifferentSpeed extends PApplet {

Circle c1,c2; //moveCircle\u30af\u30e9\u30b9\u306e\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\uff08\u30a4\u30f3\u30b9\u30bf\u30f3\u30b9\uff09\u3092\u5ba3\u8a00

public void setup()
{
  
   //\u56f3\u5f62\u306e\u8f2a\u90ed\u3092\u304d\u308c\u3044\u306b\u63cf\u753b
  fill(0);  //\u9ed2\u3067\u63cf\u753b

  c1 = new Circle(20.0f,10,1.0f); //\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u3092\u4f5c\u6210
  c2 = new Circle(150.0f,40,3.5f);
}

public void draw(){
  background(255); //\u80cc\u666f\u306f\u767d
  c1.update(); //c1,c2\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u306eupdate\u30e1\u30bd\u30c3\u30c9\u3092\u5b9f\u884c
  c2.update();
}


//Circle\u30af\u30e9\u30b9\u306e\u5ba3\u8a00
class Circle{
  float xPos,yPos,speed;
  int eSize;

 Circle(float y,int es,float sp){ //\u521d\u671f\u5316\u7528\u306e\u30e1\u30be\u30c3\u30c8
    xPos = 0.0f; //x\u5ea7\u6a19\u306e\u521d\u671f\u5024\u306f0.0
    yPos = y;  //y\u5ea7\u6a19\u306e\u521d\u671f\u5024\u306f\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u3092\u5ba3\u8a00\u3057\u305f\u969b\u306e\u5f15\u6570\u306b\u306a\u308b
    eSize = es;
    speed = sp; //speed\u306e\u521d\u671f\u5024\u3082\u30aa\u30d6\u30b8\u30a7\u30af\u30c8\u5ba3\u8a00\u306e\u969b\u306e\u5f15\u6570
  }

  //\u5186\u306e\u4f4d\u7f6e\u3092\u66f4\u65b0\u3059\u308b\u30e1\u30be\u30c3\u30c9
  public void update(){
    xPos += speed; //speed\u5206\u306ex\u5ea7\u6a19\u3092\u79fb\u52d5
    if(xPos > width){ //\u5186\u306ex\u5ea7\u6a19\u304c\u30a6\u30a4\u30f3\u30c9\u30a6\u306e\u5e45\u3092\u8d85\u3048\u305f\u3089\u3001
      xPos = 0;       //\u4f4d\u7f6e\u3092\uff10\u306b\u623b\u3059
    }
    ellipse(xPos,yPos,eSize,eSize); //\u5186\u3092\u63cf\u304f
  }
}
  public void settings() {  size(200,200);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "TwoBallsInDifferentSpeed" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
