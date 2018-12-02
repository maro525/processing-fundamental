Spot sp;

void setup(){
  size(400,400);
  smooth();
  noStroke();
  sp = new Spot(150,200,100,3); //オブジェクトを生成
}

void draw(){
  fill(0,15);
  rect(0,0,width,height);
  fill(255);
  sp.move();
  sp.display();
}

class Spot {
  float x, y;
  float diameter;
  float speed;
  int direction = 1; //動きの向き（１　降下、　−１　上昇)

  //コンストラクター
  Spot(float xpos,float ypos, float dia ,float sp) {
    x = xpos;
    y = ypos;
    diameter = dia;
    speed = sp;
  }

  void move(){
    y += (speed * direction);
    if ( (y > (height - diameter / 2) ) || ( y < diameter /2 ) ) {
      direction *= -1;

  }
  }


  void display(){
    ellipse(x,y,diameter,diameter);
  }
}
