import com.fazecast.jSerialComm.SerialPort;

public class SerialConnector {

    public static void main(String[] args) {
        try {
            // args = <dbname> <port> <user>
            //if (args.length != 3) {
                // System.out.println("Usage: java SerialConnector <dbname> <port> <user>");
              //  return;
            //}

            pill_box db = new pill_box("postgresql://localhost:5432/pill-db", "psql", "psql");
            SerialPort comPort = SerialPort.getCommPort("/dev/ttyACM1"); // idk
            comPort.setBaudRate(9600);

            if (comPort.openPort()) {
                System.out.println("Connected to Arduino!");
                comPort.addDataListener(new ComPortListener(db));
            } else {
                System.out.println("Failed to open COM port.");
                return;
            }

            //db.loadAllDoses();

            // Keep app alive (so it keeps listening)
            while (true) {
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
