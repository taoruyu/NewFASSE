import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import  java.util.Arrays;
public class Readtxt {
    /**
     * ��ȡtxt�ļ�������
     * @param file ��Ҫ��ȡ���ļ�����
     * @return �����ļ�����
     * @throws IOException 
     */
	
	
	
    public static List<String[]> keywordString(File file,String k) throws IOException{
            //StringBuilder result = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            int flag =0;

            List<String[]> other =new ArrayList<>();
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��

                String [] r = s.split("keyword");
                for (int i = 0; i < r.length-1; i++) {

                	if(r[i].equals(k))
                	{
                		//System.out.println(r[i]+"   "+k);
                		flag++;
                		other.add(r[r.length-1].split("alice"));
                		//break;
                	}
				}
                //System.out.println("===============");
            }
            br.close();
//            for (int i = 0; i < other.size(); i++) {
//
//					System.out.println(other.get(i)[0]+"**"+other.get(i)[1]+"**"+other.get(i)[2]+"**"+other.get(i)[3]);
//
//			}
            if(flag==0)
            {
            	JOptionPane.showMessageDialog(null, "�Բ����ֵ��в��޸ùؼ��ʼ�¼�������볢��ʹ����ǿ����", "Sorry", JOptionPane.ERROR_MESSAGE);
            	Login.buttonre.setEnabled(true);
            }


            return other;
       // return result.toString();

    }
	
    
    
    public static List<String[]> idString(File file,String id, float relativity) throws IOException{
        // StringBuilder result = new StringBuilder();
        
             BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
             String s = null;
             //int flag =0;
             //String [][] other={};
             List<String[]> other =new ArrayList<>();
             //Vector<String> v =  new Vector<>();
             while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��

                 String [] r = s.split("keyword");
                 String ID = r[r.length-1].split("alice")[0];
                 
                 
                 	if(ID.equals(id))
                 	{
                 	//	System.out.println("���ֵ����ҵ�����Ӧ�ļ�¼������");
                 		//flag++;
                 		String[] tem = new String[5];
                 		//String keyword = r[0]+","+r[1]+","+r[2]+","+r[3]+","+r[4];
                 		tem[2] = Login.textField.getText();
                 		tem[0] = ID;
                 		tem[1] = new String (EncDec.AESDncode("alicelovebob", EncDec.parseHexStr2Byte(r[r.length-1].split("alice")[1])));
                 		//System.out.println("========="+tem[1]);
                 		tem[3] = r[r.length-1].split("alice")[2];
                 		tem[4] = relativity+"";
                 		other.add(tem);
                 		//continue;
                 	}
 				
                 //System.out.println("===============");
             }
             br.close(); 
             
        
             
             
             return other;
        // return result.toString();
         
     }
    
    
    public static String txt2String(File file) throws FileNotFoundException{
    	StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
                result.append(s+System.lineSeparator());
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


    public static List<String[]> inAllkeywordsearch_String(File file,String k,String[] id) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
        String s = null;
        int flag =0;

        List<String[]> other =new ArrayList<>();
        while((s = br.readLine())!=null)
        {
            //ʹ��readLine������һ�ζ�һ��
            String [] r = s.split("keyword");
            String [] allkw = {"","","","","",""};
            for(int aa=0;aa<r.length-1;aa++)
                allkw[aa] = r[aa];



            for (int i = 0; i < r.length-1; i++) {
                if(id[i].equals(r[r.length-1].split("alice")[0])) {
                  // Arrays.asList(array).contains("xx");
                    if (Arrays.asList(allkw).contains(k)) {
                        //System.out.println(r[i]+"   "+k);
                        flag++;
                        other.add(r[r.length - 1].split("alice"));
                        //break;
                    }
                }
            }
            //System.out.println("===============");
        }
        br.close();
//            for (int i = 0; i < other.size(); i++) {
//
//					System.out.println(other.get(i)[0]+"**"+other.get(i)[1]+"**"+other.get(i)[2]+"**"+other.get(i)[3]);
//
//			}
        if(flag==0)
        {
            JOptionPane.showMessageDialog(null, "�Բ����ֵ��в��޸ùؼ��ʼ�¼�������볢��ʹ����ǿ����_Filter", "Sorry", JOptionPane.ERROR_MESSAGE);
            Login.buttonre.setEnabled(true);
            return  null;

        }


        return other;
        // return result.toString();

    }


    public static void main(String[] args){
        
       File file = new File("z");
     
    }
}



