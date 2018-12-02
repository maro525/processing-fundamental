
float Friction = 0.99;
float x,y,spx,spy;
int radius = int(random(10,60));


void setup(){
  size(400,400);
  colorMode(HSB,100);
  background(99);
  noStroke();
  frameRate(15);
  spx = random(-30,30);
  spy = random(-30,30);
  x = random(0,width);
  y = random(0,height);
}

void draw(){
  white();
  cal();
  bounce();
  fill(randomcolor());
  ellipse(x,y,radius*2,radius*2);
}

color randomcolor(){
  color c = color(random(100),random(100),random(100));
  return c;
}

void white(){
  noStroke();
  fill(99,80);
  rectMode(CORNER);
  rect(0,0,width,height);
}

void cal(){
  spx *=Friction;
  spy *=Friction;
  x += spx;
  y += spy;
}

void bounce(){
  float bounceminx = radius;
  float bouncemaxx  = width - radius;
  float bounceminy = radius;
  float bouncemaxy = height - radius;

  if(x<bounceminx || x>bouncemaxx){
    spx *= -0.8;
    if(x<bounceminx) x = bounceminx-(x-bounceminx);
    if(x>bouncemaxx) x = bouncemaxx-(x-bouncemaxx);
  }

  if(y<bounceminy || y>bouncemaxy){
    spy *= -0.9;
    if(y<bounceminy) y = bounceminy-(y-bounceminy);
    if(y>bouncemaxy) y = bouncemaxy-(y-bouncemaxy);
  }
}
