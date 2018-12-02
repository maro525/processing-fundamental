void setup(){
  size(200,200);
  noFill();
  frameRate(10);
}

int d = 0;
int e = width;

void draw(){
  background(40);
  if(d <= width){
    d = d + 1;
    for(int i=0; i<10; i++){
      for(int g=0; g<10; g++){
        stroke(255);
        ellipse(10+i*20,10+g*20,d,d);
      }
    }
  }
  if (d > width){
      e = e - 1;
      for(int i=0; i<10; i++){
        for(int g=0; g<10; g++){
          stroke(255);
          ellipse(10+i*20,10+g*20,e,e);
        }
      }
   }
    if (e <= 0 ){
      d = 0;
      e = width;
    }
}
