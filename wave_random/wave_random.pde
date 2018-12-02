float yoff = 0.0;

void setup() {
  size(1200, 800);
  noStroke();
}

void draw() {
  background(247,152,152);

  fill(255);
  beginShape();
  float xoff = 0;
  for (float x = 0; x <= width; x += 10) {
    float y = map(noise(xoff, yoff), 0, 1, height*0.1,height*0.7);
  //mapは0-1で出力されたnoiseを200-300の間の数に直します。
    vertex(x, y);
    xoff += 0.05;
  }
  yoff += 0.01;
  vertex(width, height);
  vertex(0, height);
  endShape(CLOSE);
}
