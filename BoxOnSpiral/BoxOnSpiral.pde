size(200,200);
colorMode(HSB,100);
background(99);
noStroke();
smooth();
noFill();
rectMode(CENTER);

translate(100,100);
int angle = 30;
int x = 3;

for(int i =0; i<50; i++){
  stroke(i+10,299,299);

  pushMatrix();
  rotate(radians(angle*i));
  translate(i*x,0);
  rect(0,0,10,10);
  popMatrix();
}
