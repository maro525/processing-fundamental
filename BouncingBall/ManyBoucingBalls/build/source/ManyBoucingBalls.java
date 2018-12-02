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

public class ManyBoucingBalls extends PApplet {

float GRAVITY = 3;
float FRICTION = 0.8f;
int Length = 50;

float[] X = new float[Length];
float[] Y = new float[Length];
float[] Spx = new float[Length];
float[] Spy = new float[Length];
float[] Radius = new float[Length];

public void setup(){
  
  colorMode(HSB,Length);
  background(Length);
  frameRate(10);

  //\u914d\u5217\u306e\u521d\u671f\u5316
  for(int i = 0; i < Length; i++){
    X[i] = width/2;
    Y[i] = 10;
    Spx[i] = random(-20,20);
    Spy[i] = random(-30,0);
    Radius[i] = random(5,20);
  }
}

public void draw(){
  fadetowhite();

  //\u3059\u3079\u3066\u306e\u30dc\u30fc\u30eb\u3092\u52d5\u304b\u3059
  moveBalls();

  //\u63cf\u753b
  for(int i=0; i<Length; i++){
    noStroke();
    fill(i, Length*0.6f, Length - 1);
    ellipse(X[i],Y[i],Radius[i]*2,Radius[i]*2);
  }
}

//\u3059\u3079\u3066\u306e\u30dc\u30fc\u30eb\u3092\u52d5\u304b\u3059
public void moveBalls(){
  for(int i=0; i<Length; i++){
    Spy[i] = Spy[i] + GRAVITY; //\u91cd\u529b\u3092\u304b\u3051\u308b
    X[i] = X[i] + Spx[i];
    Y[i] = Y[i] + Spy[i];

    //\u8df3\u306d\u8fd4\u308a\u5224\u5b9a
    bounce(i);
  }
}

//\u8df3\u306d\u8fd4\u308a\u5224\u5b9a
public void bounce(int i){
  float bounceMinX = Radius[i];
  float bounceMaxX = width - Radius[i];
  float bounceMinY = Radius[i];
  float bounceMaxY = height - Radius[i];

  //\u6a2a\u65b9\u5411\u306e\u885d\u7a81\u5224\u5b9a
  if(X[i] < bounceMinX || X[i] > bounceMaxX){
    Spx[i] = -Spx[i] * FRICTION; //\u30b9\u30d4\u30fc\u30c9\u53cd\u8ee2\u3057\u3066\u6e1b\u8870\u3055\u305b\u308b
    if(abs(Spx[i]) < 1) Spx[i] = 0; //\u30b9\u30d4\u30fc\u30c9\u304c\u5c0f\u3055\u304f\u306a\u3063\u305f\u3089\u6b62\u3081\u308b
    if(X[i] < bounceMinX) X[i] = bounceMinX - (X[i] - bounceMinX);
    if(X[i] > bounceMaxX) X[i] = bounceMaxX - (X[i] - bounceMaxX);
  }

  //\u6a2a\u65b9\u5411\u306e\u885d\u7a81\u5224\u5b9a
  if(Y[i] < bounceMinY || Y[i] > bounceMaxY){
    Spy[i] = -Spy[i] * FRICTION;//\u30b9\u30d4\u30fc\u30c9\u53cd\u8ee2\u3057\u3066\u6e1b\u8870\u3055\u305b\u308b
    if(abs(Spy[i]) < GRAVITY) Spy[i] = 0; //\u30b9\u30d4\u30fc\u30c9\u304c\u5c0f\u3055\u304f\u306a\u3063\u305f\u3089\u6b62\u3081\u308b
    if(Y[i] < bounceMinY) Y[i] = bounceMinY - (Y[i] - bounceMinY);
    if(Y[i] > bounceMaxY) Y[i] = bounceMaxY - (Y[i] - bounceMaxY);
  }
}

public void fadetowhite(){
  noStroke();
  fill(Length - 1, Length*0.3f);
  rectMode(CORNER);
  rect(0,0,width,height);
}
  public void settings() {  size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ManyBoucingBalls" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
