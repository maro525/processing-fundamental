void rectLine(int x, int y, int w, int h){
  line(x,y,x+w,y);
  line(x,y,x,y+h);
  line(x+w,y,x+w,y+h);
  line(x,y+h,x+w,y+h);
}

color randomRGBcolor(){
  color c = color(random(256),random(256),random(256));
  return c;
}

void setup(){
  size(200,200);
  background(255);
  colorMode(RGB,256);
  frameRate(10);
}

void draw(){
  background(255);
  stroke( randomRGBcolor() );
  int x = int(random(width));
  int y = int(random(height));
  rectLine(x,y,30,30);
}
