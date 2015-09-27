import java.io.*;
 class FileHandler {
     public void fileCreator(String timestamp,String data){
        try {
            File file =new File(timestamp);
            file.createNewFile();
            Writer output = null;
            output = new BufferedWriter(new FileWriter(file));
            output.write(data);
            output.close();

       /*     FileWriter fw = new FileWriter(timestamp);
            fw.write(data);
            fw.close(); */
        } catch (IOException ex) {
            //Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("File Handler Exception:" +ex);
        }
     }
     public String fileReader(String filename){
     //Reader rd=null;
         StringBuffer strContent = new StringBuffer("");
        try {
           FileInputStream fstream = new FileInputStream("packetdata/"+filename);
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String str;
      while ((str = br.readLine()) != null) {
        System.out.println(str);
        strContent.append(str);
        strContent.append("\n");
      }
      in.close();
        } catch (Exception ex) {
           // Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        System.out.print("file ReadException:"+ex);
        }
         return strContent.toString();
     }

 }
     
 