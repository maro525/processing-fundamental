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

float dy; //速度
float y; //位置
float g = 0.9f; //重力加速度
float mass = 5; //質量
float stiffness = 0.15f; //バネの強さ
float damping = 0.98f; //減衰
int r = 5;
float my = 50; //バネの長さ

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
  float forcey = (my-y) * stiffness; //バネに働く力
  float ay = forcey / mass; //バネによる加速度を計算
  dy = damping * (dy + ay + g); //速度計算
  y = y + dy; //y座標を動かす
}
  public void settings() {  size(125,250); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Spring" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
