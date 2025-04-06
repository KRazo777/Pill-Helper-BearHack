#define trigPin 7
#define echoPin 6
#define led1 9
#define buzzer 3

int sound = 250;
bool alreadySent = false;

void setup() {
  Serial.begin (9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(led1, OUTPUT);
  pinMode(buzzer, OUTPUT);
 
}

void loop() {
  long duration, distance;
  digitalWrite(trigPin, LOW); 
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = (duration/2) / 29.1;
 

  if (distance >= 12 && !alreadySent) {
    Serial.println("TAKEN");   
    alreadySent = true;
    digitalWrite(led1, HIGH);
    sound = 750;
}
   if (distance < 12 || distance <= 0){
    Serial.println("Out of range");
    noTone(buzzer);
    alreadySent = false;
  }
  else {
    Serial.print(distance);
    Serial.println(" cm");
    tone(buzzer, sound);
   
  }
  delay(500);
}