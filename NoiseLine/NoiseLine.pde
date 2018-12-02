int step = 1;
float lastx = 0;
float lasty = 0;
float ynoise = random(10);
float y;
int border = 20;

void setup(){
    size(1200,800);
    frameRate(3);
    smooth();
}


void draw(){
    background(255);

    strokeWeight(5);
    stroke(0, 50);
    line(0, height/2, width, height/2);

    stroke(20, 50, 70);
    for (int x = border; x <= width-border; x += step){
        y = border + noise(ynoise) * (height-border*2);
        if (x != border){
                line(x, y, lastx, lasty);
        }
        lastx = x;
        lasty = y;
        ynoise += 0.01;
    }
}
