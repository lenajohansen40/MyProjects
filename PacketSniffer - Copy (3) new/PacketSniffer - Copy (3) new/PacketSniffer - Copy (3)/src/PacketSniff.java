/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rajus
 */

import java.net.Inet4Address;
import java.sql.SQLException;
import jpcap.*;
import jpcap.packet.*;
import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class PacketSniff implements PacketReceiver, Runnable{
    //class PacketSniff implements JpcapHandler {

	public static long datalen=0;
        NetworkInterface[] lists;
        NewJFrame jframe;
        int index;

	public PacketSniff(NewJFrame jframe) {

                this.jframe=jframe;

		//String []lists=Jpcap.getDeviceDescription();
		 lists=jpcap.JpcapCaptor.getDeviceList();

		System.out.println("Packet Sniffer");
		System.out.println("");
		System.out.println("List of detected Network Interface Card");

		//for (String x:lists)
		for(NetworkInterface x:lists)
		{
			//System.out.println(x);
			System.out.println("Name: " + x.name +"\nDescription: " + x.description);
                        jframe.NICSelectComboBoxAddItem(x.description);
		}

                


		System.out.println("==================");

		

	}

        public void startMonitor(int index) {
            this.index=index;

        }

        public void run(){



		System.out.println("Started capturing on: "+ lists[index].description);
		try {


				//Jpcap jpcap=Jpcap.openDevice(Jpcap.getDeviceList()[index],65535,false,20);
				//JpcapCaptor jpcap=JpcapCaptor.openDevice(JpcapCaptor.getDeviceList()[0],1000,false,20);
				JpcapCaptor jpcap=JpcapCaptor.openDevice(lists[index],1000,false,20);

				jpcap.loopPacket(-1,this);
		}

		catch(Exception e){
			System.out.println("An exception occured: "+e);
		}
        }
//	public void handlePacket(Packet packet) {
	public void receivePacket(Packet packet) {

                System.out.println("================xxxxxxxx==============xxxxxx==================xxxxxxxx================");

		System.out.print("Packet Length: ");
		System.out.println(packet.len);
		System.out.println("Data Length "+packet.data.length);
		System.out.println("Header Data: "+packet.header);

		System.out.println(packet);

		datalen += packet.len;
                analysePacket(packet);
	}


        public void analysePacket(Packet packet) {

            InetAddress dest = null,src=null;
            String []packetinfo=new String[7];
            StringBuffer sb = new StringBuffer();
            packetinfo[3]=new Integer(packet.len).toString();
            packetinfo[5]=new Integer(packet.data.length).toString();
            System.out.println("second"+packet.usec);

           long second2 =packet.sec*1000000+packet.usec;
           packetinfo[6]=String.valueOf(second2);
            int month,year,date;
            String am_pm;
            DateFormat dformat = DateFormat.getInstance();


            if (packet instanceof IPPacket) {
                     IPPacket ipp = (IPPacket)packet;
                     dest = ipp.dst_ip;
                    src = ipp.src_ip;
            
                    System.out.println("DATA: by loop char");
                    for(int i=0;i<ipp.data.length;i++) {

                        System.out.print((char)ipp.data[i]);
                        //char ch=;
                        if(String.valueOf((char)ipp.data[i]).equals("'"))
                        {

                            //sb.append("'");
                            System.out.println("Char equals to : "+(char)ipp.data[i]);
                        }


                        sb.append((char)ipp.data[i]);
                     }


                    System.out.println("");
                // System.out.println(new String(ipp.data));
            
                  if( dest!=null && src!=null&& dest instanceof Inet4Address && src instanceof Inet4Address){
                  
                       packetinfo[1] = ipp.src_ip.toString();
                        packetinfo[2]=ipp.dst_ip.toString();
                      packetinfo[4]= String.valueOf(ipp.protocol);
                           
                      Date d=new Date(second2/1000);
                           System.out.println("date"+d);
                            Calendar c = Calendar.getInstance();
                            c.setTime(d);
                         month= c.get(Calendar.MONTH) + 1;
                           date= c.get(Calendar.DAY_OF_MONTH);
                            year= c.get(Calendar.YEAR);
                            int hour =c.get(Calendar.HOUR);
                            int minute = c.get(Calendar.MINUTE);
                            int second = c.get(Calendar.SECOND);
                            int ms=c.get(Calendar.MILLISECOND);

                            if(c.get(Calendar.AM_PM) == 0)
                                    am_pm = "AM";
                            else
                                    am_pm = "PM";
                            System.out.println("DATE: "+ date+" "+month+" "+year+" "+hour+":"+minute+":"+second+" "+am_pm);
                                packetinfo[0]=date+"/"+month+"/"+year+" "+hour+":"+minute+":"+second+" "+am_pm;
                            System.out.println(dformat.format(d));

                            jframe.PacketInfoAddItem(packetinfo);
                  //  jframe.PacketDataTextAreaSetText(sb);
                            jframe.IPTableAddItem(packetinfo[1]);
                            jframe.IPTableAddItem(packetinfo[2]);

                            FileHandler fh=new FileHandler();
                            fh.fileCreator("packetdata/"+String.valueOf(second2), sb.toString());

                    try {
                    //   String q="insert into Packet Info values("+packetinfo[0]+",'"+packetinfo[1]+"','"+packetinfo[2]+"',"+packetinfo[3]+","+packetinfo[4]+","+packetinfo[5]+",'"+sb.toString()+"')";
                      int i = MainThread.stmt.executeUpdate("insert into PacketInfo values("+second2+",'"+packetinfo[1]+"','"+packetinfo[2]+"',"+packetinfo[3]+","+packetinfo[4]+","+packetinfo[5]+")");
                       System.out.println("Insert Result: "+i);
                        
                    }
                   catch (SQLException ex) {
                        System.out.println("SQLError: "+ex);
                      }
                            finally
                                    
                        { 
                    try {
                        MainThread.conn.commit();
                    } catch (SQLException ex) {
                        System.out.println("CommitSQLError: "+ex);
                        //Logger.getLogger(PacketSniff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            }



                   }                              
            }
                            // if (dest.equals(InetAddress.getLocalHost())) {
                            //jframe.PacketInfoAddItem("In",packet.len,"protocol","srcport","dstport",packet.data.length);
                            //}
        }

}






