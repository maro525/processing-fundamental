void setup(){
  size(200,200);
  colorMode(HSB,100);
  background(99);
  frameRate(15);

  X = Y = 0;
  Spx = Spy = 0;
  Acx = Acy = 0.5;
}

float X,Y;
float Spx,Spy;
float Acx,Acy;

void draw(){
  fadetowhite();

  Spx = Spx + Acx;
  Spy = Spy + Acy;
  if(Spx > Max) Spx = Max;
  if(Spy > Max) Spy = Max;
  X = X + Spx;
  Y = Y + Spy;

  noStroke();
  fill(0);
  rectMode(CENTER);
  rect(X,Y,10,10);
}

float Max = 10;

void fadetowhite(){
  noStroke();
  fill(99,30);
  rectMode(CORNER);
  rect(0,0,width,height);
}
