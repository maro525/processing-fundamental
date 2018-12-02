void conbcal(int a,int b,int c){
  int A;
  for(int aa = 0; aa<a; a++){
    A *= (A - aa);
  }

class ControlPoints {         //制御点
  int   Bn;                   //ベジエ曲線の次数
  PVector[] B;                //制御点のベクトルデータ
  int[] Bno;                  //制御点のナンバー

  int   Bn1   =  1;            //コンビネーション計算の分子
  int   tn    =  500;
  float t     =  0.0;
  float ts    =  (float)1/tn;

  ControlPoints(int bnn) {
    Bn = bnn;
    B  = new PVector[Bn];
  }

    for (int x=0; x<Bn; x++){
      Bno[x] = x;
    }
    for (Bno = 0; Bno < Bn; Bno+=1) {
      B[Bno] = new PVector();
      float rad = (PI*Bno) / (2*Bn);
      float len = (width/2) - 10;
      B[Bno].x = width/2  + cos(radians(PI/2 + rad)) * len;      //制御点のx座標
      B[Bno].y = height/4 + sin(radians(PI/2 + rad)) * len;      //制御点のy座標
    }
  }

  void CpDraw() {
    fill(0, 255, 255);
    stroke(0, 255, 255);
    for (int ee = 0; ee < Bn; ee+=1) {
      ellipse(B[ee].x, B[ee].y, 10, 10);                           //制御点
      if (ee!=0) line(B[ee-1].x, B[ee-1].y, B[ee].x, B[ee].y);     //制御点同士を結ぶ直線
    }
  }





class BezierCalc{                   //点を式で表したときの各項の係数計算＝コンビネーション計算(ｎCi)
  ControlPoints CP1;

  BezierCalc(ControlPoints CP1a){
    CP1 = CP1a;
  }

  void calc(){                      //コンビネーションの定義に帰って計算＝n!/( i!*(n-i)! )
    for(int a=0; a<CP1.Bn; a+=1){   //コンビネーションの分子部分の計算(n!)
      CP1.Bn1 *= (CP1.Bn-a);
    }
    for(int b1=0; b1<CP1.Bno; b1+=1){  //コンビネーションの分母部分の計算①(i!)
      for(int b2=0; b2<CP1.Bn; b2+=1){
        CP1.Bno[b2] *= (CP1.Bno[b2]-b1);
    }
    for(int c=0; c<CP1.Bn2; c+=1){  //コンビネーションの分母部分の計算②( (n-i)! )
      CP1.Bn2 *= (CP1.Bn2-c);
    }
  }
}

class BezierCurve {
  ControlPoints CP2;

  BezierCurve(ControlPoints CP2a){
    CP2 = CP2a;
  }

  void draw(){
    for(int tt=0; tt<CP2.tn; tt+=1){
    }
  }
}





ControlPoints C0;
BezierCalc    B0;

void setup(){
  size(800, 800);
  C0 = new ControlPoints(10);
  B0 = new BezierCalc(bez1);
}

void draw() {
  background(40);

  text("BezierCurve", 10, 20);

  C0.B[0].x = mouseX;
  C0.B[0].y = mouseY;

  C0.CpDraw();
}
}
