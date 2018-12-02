Spot sp1, sp2, sp3; //３つのオブジェクトを宣言
void setup(){
  size(400,400);
  smooth();
  noStroke();
  sp1 = new Spot(100,200,80,2);
  sp2 = new Spot(200,200,20,5);
  sp3 = new Spot(300,50,60,3);
}

void draw(){
  fill(0,15);
  rect(0,0,width,height);
  fill(255);
  sp1.move();
  sp2.move();
  sp3.move();
  sp1.display();
  sp2.display();
  sp3.display();
}

class Spot {
  float x, y;
  float diameter;
  float speed;
  int direction = 1;
  Spot(float xpos, float ypos, float dia, float sp){
    x = xpos;
    y = ypos;
    diameter = dia;
    speed = sp;
  }
  void move(){
    y += (speed * direction);
    if( ( y>(height-diameter/2) ) || ( y<diameter/2) ) {
      direction *= -1;
    }
  }
  void display(){
    ellipse(x,y,diameter,diameter);
  }
}
