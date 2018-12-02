// キャンバスサイズ
PImage img;
int threshold = 250;
int point_sum;
int sum;

void setup (){
  img = loadImage("ocean.jpg");
  size(1016,586);
  noLoop();
  background(#ffffee);
}


void draw(){
	fill(#d0d0f0);
	img.filter(THRESHOLD, 0.9);
	image(img, 0, 0);
	toSuji();
	save("sample1256a.png");
	println("point_sum = " + point_sum + " out of " + sum);
}

void toSuji() {
  for (int y=0; y < img.height; y++) {
    for (int x=0; x < img.width; x++) {
      int br = int(brightness(img.get(x, y)));
	  sum += 1;

	  if(br >= threshold) {
		  point_sum +=1;
	  }
    }
  }
}
