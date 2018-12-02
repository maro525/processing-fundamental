size(1000,200);
background(255);
strokeWeight(5);
smooth();

float xstep = 1;
float lastx = -999;
float lasty = -999;
float angle = 0;
float y = 50;
int border = 20;

// float customRandom(){
//     float retValue = 1 - pow(random(1), 5);
//     return retValue;
// }


for (int x = border; x <= width - border; x += xstep){
    float rad = radians(angle);
    // y = height/2 + (pow(sin(rad), 3) * 40);
    // y = height/2 + (pow(sin(rad), 3) * noise(rad*2) * 40);
    // y = height/2 + (customRandom() * 40); // エラーが出る
    y = height/2 + (1 - pow(random(1), 5)) * 40;
    if ( lastx > -999){
        line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
    angle++;
}
