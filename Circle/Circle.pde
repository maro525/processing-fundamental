Spot sp;

void setup(){
  size(400,400);
  smooth();
  noStroke();
  sp = new Spot(150,200,100); //オブジェクトを生成
}

void draw(){
  background(0);
  sp.display();
}

class Spot {
  float x, y, diameter;

  Spot(float xpos, float ypos, float dia){
    x = xpos; // xに150を設定
    y = ypos; // yに200を設定
    diameter = dia; // 直径に100を設定
  }

  void display(){
    ellipse(x,y,diameter,diameter);
  }
}
