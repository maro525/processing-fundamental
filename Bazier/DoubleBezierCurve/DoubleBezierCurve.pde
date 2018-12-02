class BezierCurve {

  PVector P0, P1, P2, P3, P4, P5, P6, P7;
  PVector[] R1,R2;
  int tn;

  BezierCurve() {
    P4 = new PVector(); P4.x =  20; P4.y = 400;
    P3 = new PVector(); P3.x =  80; P3.y = 170;
    P2 = new PVector(); P2.x = 200; P2.y =  50;
    P1 = new PVector(); P1.x = 320; P1.y = 170;
    P0 = new PVector(); P0.x = 380; P0.y = 400;
    P5 = new PVector(); P5.x = 460; P5.y = 700;
    P6 = new PVector(); P6.x = 580; P6.y = 700;
    P7 = new PVector(); P7.x = 700; P7.y = 400;

    tn = 100;
    R1 = new PVector[tn];
    R2 = new PVector[tn];
  }

  void draw() {

    int   i, tt;
    float t1=0.0;
    float t2=0.0;
    float ts = (float)1 / tn;
    float B30t, B31t, B32t, B33t, B34t, B35t, B36t, B37t, B38t;

    stroke(0, 255, 255);
    fill(0, 255, 255, 30);
    line(P0.x, P0.y, P1.x, P1.y);
    line(P1.x, P1.y, P2.x, P2.y);
    line(P2.x, P2.y, P3.x, P3.y);
    line(P3.x, P3.y, P4.x, P4.y);
    line(P0.x, P0.y, P5.x, P5.y);
    line(P5.x, P5.y, P6.x, P6.y);
    line(P6.x, P6.y, P7.x, P7.y);

    fill(0, 255, 255);
    ellipse(P0.x, P0.y, 10, 10);
    ellipse(P1.x, P1.y, 10, 10);
    ellipse(P2.x, P2.y, 10, 10);
    ellipse(P3.x, P3.y, 10, 10);
    ellipse(P4.x, P4.y, 10, 10);
    ellipse(P5.x, P5.y, 10, 10);
    ellipse(P6.x, P6.y, 10, 10);
    ellipse(P7.x, P7.y, 10, 10);

    // text control points
    fill(255, 255, 255);
    text("P0", P0.x+15, P0.y   ); // p0
    text("P1", P1.x,    P1.y-15); // p1
    text("P2", P2.x+10, P2.y-15); // p2
    text("P3", P3.x-30, P3.y   ); // p3
    text("p4", P4.x-30, P4.y   ); // P4
    text("p5", P5.x-30, P5.y   ); // P5
    text("p6", P6.x-30, P6.y   ); // P6
    text("p7", P7.x-30, P7.y   ); // P7

    noFill();
    stroke(255, 255, 255);

    for(tt = 0; tt < tn ; tt+=1) {
        B30t =  (1-t1)*(1-t1)*(1-t1)*(1-t1);
        B31t =  4*(1-t1)*(1-t1)*(1-t1)*t1;
        B32t =  6*(1-t1)*(1-t1)*t1*t1;
        B33t =  4*(1-t1)*t1*t1*t1;
        B34t =  t1*t1*t1*t1;

        R1[tt] = new PVector();
        R1[tt].x = B30t*P0.x + B31t*P1.x + B32t*P2.x + B33t*P3.x + B34t*P4.x;
        R1[tt].y = B30t*P0.y + B31t*P1.y + B32t*P2.y + B33t*P3.y + B34t*P4.y;

      if(tt!=0) line(R1[tt-1].x,R1[tt-1].y,R1[tt].x,R1[tt].y);
      t1 = t1 + ts;
    }
    for(int ttt = 0; ttt < tn ; ttt+=1) {
        B35t =  (1-t2)*(1-t2)*(1-t2);
        B36t =  3*(1-t2)*(1-t2)*t2;
        B37t =  3*(1-t2)*t2*t2;
        B38t =  t2*t2*t2;

        R2[ttt] = new PVector();
        R2[ttt].x = B35t*P0.x + B36t*P5.x + B37t*P6.x + B38t*P7.x ;
        R2[ttt].y = B35t*P0.y + B36t*P5.y + B37t*P6.y + B38t*P7.y ;

      if(ttt!=0) line(R2[ttt-1].x,R2[ttt-1].y,R2[ttt].x,R2[ttt].y);
      t2 = t2 + ts;
    }
  }
}

BezierCurve b0;

void setup() {
  size(800, 800);
  b0 = new BezierCurve();
}

void draw() {
  background(40);

  text("BezierCurve", 10, 20);

  b0.P0.x = mouseX; b0.P0.y = mouseY;

  b0.draw();
}
