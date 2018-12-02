void setup(){
    size(1200, 900);
    background(255);
    strokeWeight(5);
    smooth();

    float radius = 200;

    stroke(0, 30);
    noFill();
    ellipse(width/2, height/2, radius*2, radius*2);

    stroke(20, 50, 70);
    strokeWeight(1);

    float x, y;
    float noiseVal = random(10);
    float radVariance, thisRadius, rad;
    beginShape();
    fill(20, 50, 70, 50);
    for(float ang = 0; ang <= 360; ang += 1){
        noiseVal += 0.1;
        radVariance = 60 * customNoise(noiseVal);

        thisRadius = radius + radVariance;
        rad = radians(ang);
        x = width/2 +  (thisRadius * cos(rad));
        y = height/2 + (thisRadius * sin(rad));

        curveVertex(x,y);
    }
    endShape();
}

float customNoise(float value){
    int count = int((value % 12));
    float retValue = pow(sin(value), count);
    return retValue;
}
