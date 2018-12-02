int diam = 10;
float centX, centY;

void setup(){
    size(1200, 800);
    frameRate(24);

    smooth();
    background(108);
    centX = width / 2;
    centY = height / 2;
    stroke(0);
    strokeWeight(1);
    fill(255, 25);
}

void draw(){
    if (diam <= 800){
        ellipse(centX, centY, diam, diam);
        diam += 10;
    }
}
