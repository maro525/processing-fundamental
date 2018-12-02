Circle c1,c2; //moveCircleクラスのオブジェクト（インスタンス）を宣言

void setup()
{
  size(200,200);
  smooth(); //図形の輪郭をきれいに描画
  fill(0);  //黒で描画

  c1 = new Circle(20.0,10,1.0); //オブジェクトを作成
  c2 = new Circle(150.0,40,3.5);
}

void draw(){
  background(255); //背景は白
  c1.update(); //c1,c2オブジェクトのupdateメソッドを実行
  c2.update();
}


//Circleクラスの宣言
class Circle{
  float xPos,yPos,speed;
  int eSize;

 Circle(float y,int es,float sp){ //初期化用のメゾット
    xPos = 0.0; //x座標の初期値は0.0
    yPos = y;  //y座標の初期値はオブジェクトを宣言した際の引数になる
    eSize = es;
    speed = sp; //speedの初期値もオブジェクト宣言の際の引数
  }

  //円の位置を更新するメゾッド
  void update(){
    xPos += speed; //speed分のx座標を移動
    if(xPos > width){ //円のx座標がウインドウの幅を超えたら、
      xPos = 0;       //位置を０に戻す
    }
    ellipse(xPos,yPos,eSize,eSize); //円を描く
  }
}
