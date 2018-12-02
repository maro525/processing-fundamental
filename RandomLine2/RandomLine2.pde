size(1200,800);
background(255);
strokeWeight(5);
smooth();

float xstep = 10;
float ystep = 10;
float lastx = 20;    ;
float lasty = height/2;
float y = height/2;

for (int x = 20; x <= width-20; x += xstep){
    ystep = random(height/8) - height/8/2;
    y += ystep;
    line(x, y, lastx, lasty);
    lastx = x;
    lasty = y;
}
