float dy; //速度
float y; //位置
float g = 0.9; //重力加速度
float mass = 5; //質量
float stiffness = 0.15; //バネの強さ
float damping = 0.98; //減衰
int r = 5;
float my = 50; //バネの長さ

void setup(){
  size(125,250);
  fill(0);
  y = my;
}

void draw(){
  background(255);
  if(mousePressed){
    y = mouseY;
  } else {
    calcpos();
  }
  line(width/2,0,width/2,y);
  ellipse(width/2,y,r*2,r*2);
}
void calcpos(){
  float forcey = (my-y) * stiffness; //バネに働く力
  float ay = forcey / mass; //バネによる加速度を計算
  dy = damping * (dy + ay + g); //速度計算
  y = y + dy; //y座標を動かす
}
