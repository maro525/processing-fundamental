void setup(){
  size(250,250);
}

void draw(){
    background(255);
    translate(width/2,height/2);
    for(int i=0; i<18; i++){
      rotate(PI/9);
      line(mouseX-width/2,mouseY-height/2,100,0);
    }
}

  
