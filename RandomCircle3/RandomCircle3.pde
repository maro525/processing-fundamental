float init_radius = 50;
float r_speed = 0.05;
float r_diff = 0.1;

int init_noiselen = 500;
int noise_speed = -50;
int noise_diff = -1;

boolean noise_change = false;

void setup(){
size(1200, 900);
background(255);
strokeWeight(1);
smooth();
}

void draw(){
  
  
background(255);
  
float centx = width/2;
float centy = height/2;

float x, y;
for (int i = 0; i < 100; i++) {
  float lastx = -999;
  float lasty = -999;
  
  float radiusNoise = random(200);
  r_diff += r_speed;
  float radius = init_radius + r_diff;
  if(radius > 200) {
    r_diff = 0.1;
    noise_change = true;
  }
  
  stroke(random(10), random(40), random(90), 80);
  int startangle = int(random(360));
  int endangle =  720 + int(random(720));
  int anglestep = 5 + int(random(3));
 
  int noise_len = init_noiselen + noise_diff;
  println(noise_len);
  if(noise_change == true){
    noise_diff += noise_speed;
    noise_change = false;
  }
  if(noise_len < 10) noise_diff = -1;

  for (float ang = startangle; ang <= endangle; ang += anglestep) {
    radius += 0.5;
    radiusNoise += 0.01;
    float thisRadius = radius + (noise(radiusNoise) * noise_len) - noise_len/2;
    float rad = radians(ang);
    x = centx + (thisRadius * cos(rad));
    y = centy + (thisRadius * sin(rad));
    if (lastx > -999) {
      line(x, y, lastx, lasty);
    }
    lastx = x;
    lasty = y;
  }
}
}
