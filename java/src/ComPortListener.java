import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class ComPortListener implements SerialPortDataListener {
    private pill_box db;
    private static String bufferReadToString = ""; // empty, but not null
    private static int cutoffASCII = 10; // ASCII code of the character used for cut-off between received messages

    public ComPortListener(pill_box dbInstance) {
        this.db = dbInstance;
    }
    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; 
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
        event.getSerialPort().readBytes(buffer, buffer.length);

        String input = new String(buffer);
        bufferReadToString += input; 

        if (bufferReadToString.indexOf(cutoffASCII) != -1) {
            String message = bufferReadToString.trim();
            System.out.println("Received from Arduino: " + message);

            if (message.equalsIgnoreCase("TAKEN")) {
                db.markDoseAsTaken();  
            }

            bufferReadToString = ""; 
        }
    }
   }



   /*void setup() {
  if (distance > 10 && !alreadySent) {
    Serial.println("TAKEN");   
    alreadySent = true;
  }

  if (distance <= 10) {
    alreadySent = false;
  }

  delay(500);


  void setup() {
  Serial.begin(9600);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
}

*/