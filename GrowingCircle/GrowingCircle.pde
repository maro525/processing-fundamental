void setup(){
size(200,200);
noFill();
frameRate(10);
}

int d = 10;

void draw(){
  background(255);
  d = d + 1 ;
  for(int i=0; i<10; i++){
    for(int g=0; g<10; g++){
      ellipse(10+i*20,10+g*20,d,d);
    }
  }
}
