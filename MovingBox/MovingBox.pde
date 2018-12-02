float X,Y;
float SpX,SpY;

void setup(){
  size(200,200);
  colorMode(RGB,100);
  background(99);
  frameRate(15);

  //位置とスピードの初期化
  X = 0;
  Y = height;
  SpX = 1;
  SpY = -2;
}

void draw(){
  fadetowhite();

  //位置の計算
  X = X + SpX;
  Y = Y + SpY;

  //描画
  noStroke();
  fill(0);
  rectMode(CENTER);
  rect(X,Y,10,10);
}

void fadetowhite(){
  noStroke();
  fill(99,30);
  rectMode(CORNER);
  rect(0,0,width,height);
}
