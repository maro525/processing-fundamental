Spot sp;

void setup() {
  size(400, 400);
  smooth();
  noStroke();
  sp = new Spot(40, 160, 50, 3);
}

void draw() {
  fill(0,30);
  sp.white();
  sp.cal();
  sp.display();
}


class Spot {
  float x, y;
  float diameter;
  float speed;
  int directionx = 1;
  int directiony = 1;

  Spot(float xx, float yy, float dia, float sp) {
    x = xx;
    y = yy;
    diameter = dia;
    speed = sp;
  }

  void white() {
    rect(0, 0, width, height);
    fill(255);
  }

  void cal() {
    x += (speed*directionx);
    y += (speed*directiony);
    text("x"+x,10,20);
    if ( (x>(width-diameter/2)) || (x<diameter/2)) {
      directionx *= -1;
    }
    if ( (y>(height-diameter/2)) || (y<diameter/2)) {
      directiony *= -1;
    }
    text("x"+x,10,30);
  }

  void display() {
    ellipse(x, y, diameter, diameter);
  }
}
