size(1200,800);
background(255);
strokeWeight(5);
smooth();

int step = 10;
float lastx = -9990;
float lasty = -9990;
float y = 50;
int borderx = 20;
int bordery = 10;

for (int x = borderx; x <= width - borderx; x += step){
    y = bordery + random(height - 2*bordery);
    if (lastx > -9990){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
}
