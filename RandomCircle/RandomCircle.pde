size(1200,800);
background(255);
strokeWeight(5);
smooth();

float radius = 300;

stroke(0,30);
noFill();
ellipse(width/2, height/2, radius*2, radius*2);

stroke(20, 50, 70);
float x, y;
float lastx = -999;
float lasty = -999;

for(float ang = 0; ang <= 360; ang += 5){
    float rad = radians(ang);
    x = width/2 + (radius * cos(rad));
    y = height/2 + (radius * sin(rad));
    point(x, y);
}
