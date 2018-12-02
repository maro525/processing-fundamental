size(500,300);
background(255);
strokeWeight(5);
smooth();

float radius = 100;
float centx = width/2;
float centy = height/2;

stroke(0,30);
noFill();
ellipse(centx, centy, radius*2, radius*2);

stroke(20, 50, 70);
float x, y;
float lastx = -999;
float lasty = -999;

radius = 10;
float radiusNoise = random(10);

for(float ang = 0; ang <= 360*4; ang += 5){
    radius += 0.5;
    radiusNoise += 0.05;
    float thisRadius = radius + (noise(radiusNoise) * 200) - 100;
    float rad = radians(ang);
    x = centx + (thisRadius * cos(rad));
    y = centy + (thisRadius * sin(rad));
    if(lastx > -999){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
}
