float x,y,cx,cy;

void setup(){
  size(600,600);
  cx = width/2;
  cy = height/2;
}

void draw(){
  background(255);
  for(int i=0; i<18; i++){
    x = cx + ( 250*cos(radians(20*i)) );
    y = cy + ( 250*sin(radians(20*i)) );
    line(mouseX,mouseY,x,y);
  }
}
