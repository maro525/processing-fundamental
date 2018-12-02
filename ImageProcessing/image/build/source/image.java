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

public class image extends PApplet {

// \u30ad\u30e3\u30f3\u30d0\u30b9\u30b5\u30a4\u30ba
PImage img;
int threshold = 250;
int point_sum;
int sum;

public void setup (){
  img = loadImage("ocean.jpg");
  
  noLoop();
  background(0xffffffee);
}


public void draw(){
	fill(0xffd0d0f0);
	img.filter(THRESHOLD, 0.9f);
	image(img, 0, 0);
	toSuji();
	save("sample1256a.png");
	println("point_sum = " + point_sum + " out of " + sum);
}

public void toSuji() {
  for (int y=0; y < img.height; y++) {
    for (int x=0; x < img.width; x++) {
      int br = PApplet.parseInt(brightness(img.get(x, y)));
	  sum += 1;

	  if(br >= threshold) {
		  point_sum +=1;
	  }
    }
  }
}
  public void settings() {  size(1016,586); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "image" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
