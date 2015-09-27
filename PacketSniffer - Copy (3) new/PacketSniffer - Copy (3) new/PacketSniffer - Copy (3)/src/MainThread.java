/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rajus
 */
import java.util.*;
import java.sql.*;




class SpeedThread extends TimerTask {

	double speed;

	public void run() {

			speed=PacketSniff.datalen/1.0f;

			System.out.println("Speed: "+speed*8);
                        MainThread.jframe.speedSet(speed*8);
			PacketSniff.datalen=0;
	}

	public SpeedThread() {

		Timer t=new Timer();
		t.schedule(this,1000,1000);

	}


}

class MainThread {

        public static NewJFrame jframe;
        public static Connection conn;
        public static Statement stmt;

	public static void main(String s[] ) {

            try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                conn=DriverManager.getConnection("jdbc:odbc:Packet");
                 stmt= conn.createStatement();
//                ResultSet rs=
            }
            catch(Exception e) {

                System.out.println("MainThreadError:"+e);

            }
                jframe=new NewJFrame();

                jframe.setSize(910, 700);
                jframe.setResizable(false);
                jframe.setTitle("NetIPSniffer");
		System.out.println("Execution begins");
		SpeedThread st=new SpeedThread();
		PacketSniff ps=new PacketSniff(jframe);
                jframe.startMethod(ps);

                 


/*		Timer t =new Timer();
		t.schedule(st,1000,1000);

	*/
	}
}