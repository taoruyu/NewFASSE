import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class SearchDicbyid {
public static float sum_relativity = 0;
public static void Search_Dic_by_id(String id,float relativity,int type) {
	// TODO Auto-generated constructor stub
	File file = new File("E:\\workspace\\code\\code\\Dictionary\\dics.txt");
	//Vector row = new Vector(); // ???????????????????add()?????????????????String??Object????งÞ??งเ?new??????????
	//Vector data = new Vector(); // ??????????????????งา????งต????????????????????????????add(row)
	//Vector names = new Vector();// ?????????????????add()???????????
	
	//Login.table = new JTable(rowdata,names);
	
	//names.add("??????");names.add("???????");names.add("?????");names.add("??????");names.add("????");
		
		List<String[]> other;
	    List<String[]> other1;
		try {
			if(type==0) {
				other = Readtxt.idString(file,id,relativity);
				for (int i = 0; i < other.size(); i++) {
					Vector<String> row = new Vector<>(); // ???????????????????add()?????????????????String??Object????งÞ??งเ?new??????????
					row.add(other.get(i)[0]);
					row.add(other.get(i)[1]);
					row.add(Login.textField.getText());
					row.add(other.get(i)[3]);
					row.add(other.get(i)[4]);
					Login.rowdata.add(row);
				}
					//  Login.model.setDataVector(data,names);
				sum_relativity = relativity;
				Login.table.updateUI();
//					Date day = new Date();
//					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//					System.out.println(id + "over  over" + df.format(day));
				}

			else{
				sum_relativity = sum_relativity + (relativity/10);
				other1 = Readtxt.idString(file,id,sum_relativity);
				for (int i = 0; i < other1.size(); i++) {
					Vector<String> row = new Vector<>(); //
					row.add(other1.get(i)[0]);
					row.add(other1.get(i)[1]);
					row.add(Login.str);
					row.add(other1.get(i)[3]);
					row.add(other1.get(i)[4]);
					Login.rowdata.add(row);
				}
			 //  Login.model.setDataVector(data,names);	 
					Login.table.updateUI();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
