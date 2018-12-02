Calc cal;
Display disp;
Calcbounce calb;

void setup() {
  size(400, 400);
  colorMode(RGB,256);
  background(255);
  smooth();
  noStroke();
  Spot sp = new Spot(random(20,width-20),30,random(10,50));
  Spot sp2 = new Spot(random(20,width-20),30,random(10,50));
  cal = new Calc(sp);
  disp = new Display(sp);
  calb = new Calcbounce(sp);
  cal = new Calc(sp2);
  disp = new Display(sp2);
  calb = new Calcbounce(sp2);
}

void draw() {
  disp.white();
  cal.calcu();
  disp.circle();
}

class Spot {
  public float x, y, diameter, speed;
  public float r = random(255),g = random(255),b= random(255);
  public float acx = random(-20,20),acy = random(-30,0);
  public float grav = 3,fric = 0.8;

  Spot(float xx, float yy, float dia) {
    x = xx;
    y = yy;
    diameter = dia;
  }
}

private class Calc {
  Spot csp;

  Calc(Spot cspn) {
    csp = cspn;
  }

  void calcu() {
    csp.x += csp.acx;
    csp.acy += csp.grav;
    csp.y += csp.acy;
    calb.bounce();
  }
}

private class Calcbounce {
  Spot cbsp;

  Calcbounce(Spot cbspn){
    cbsp = cbspn;
  }

  void bounce(){
    if((cbsp.x<cbsp.diameter/2)||(cbsp.x>(width-cbsp.diameter/2))){
      cbsp.acx = -cbsp.acx*cbsp.fric;
      cbsp.r += random(5.20);
      cbsp.g += random(5.20);
      cbsp.b += random(5.20);
      if(cbsp.x<cbsp.diameter/2) cbsp.x = cbsp.diameter/2-(cbsp.x-cbsp.diameter/2);
      if(cbsp.x>(width-cbsp.diameter/2)) cbsp.x = (width-cbsp.diameter/2)-(cbsp.x-(width-cbsp.diameter/2));
    }

    if((cbsp.y<cbsp.diameter/2)||(cbsp.y>(width-cbsp.diameter/2))){
      cbsp.acy = -cbsp.acy*cbsp.fric;
      cbsp.r += random(5.20);
      cbsp.g += random(5.20);
      cbsp.b += random(5.20);
      if(cbsp.y<cbsp.diameter/2) cbsp.y = cbsp.diameter/2-(cbsp.y-cbsp.diameter/2);
      if(cbsp.y>(width-cbsp.diameter/2)) cbsp.y = (width-cbsp.diameter/2)-(cbsp.y-(width-cbsp.diameter/2));
    }
  }
}

private class Display {
  Spot dsp;

  Display(Spot spn) {
    dsp = spn;
  }

  void circle() {
    float x = dsp.x;
    float y = dsp.y;
    float diameter = dsp.diameter;
    fill(dsp.r,dsp.g,dsp.b);
    ellipse(x, y, diameter, diameter);
  }

  void white() {
    noStroke();
    fill(255, 30);
    rectMode(CORNER);
    rect(0, 0, width, height);
  }
}
