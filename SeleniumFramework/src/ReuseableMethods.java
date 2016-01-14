import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;





import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebElement;


public class ReuseableMethods {
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	/* Method Name: validateMsg
	 * Method description: Validate actual and expected message
	 * Arguments: obj --> Web object, expectedMsg --> Expected message, objName --> Name of the Object
	 * Created By: Fighter2016
	 * Created Date: Jan 07 2016
	 * Last Modified :Jan 07 2016
	 * */
	public static void validateMsg(WebElement obj, String expectedMsg, String Objname) throws IOException{
		if(obj.isDisplayed()){
			String actMsg = obj.getText();

			if(actMsg.equals(expectedMsg)){
				Update_Report("Pass", "validateMsg", " Expected message matches with actual msg: "+ actMsg);
			}else{
				Update_Report("Fail", "validateMsg", " Expected message '" + expectedMsg + "' did not matche with actual msg: '"+ actMsg + "'");
			}

		}else{
			Update_Report("Fail", "validateMsg", objName + " is not displayed.");
		}
	}

	
	// Technical Method
	/* Method Name:clickButton
	 * Method description: Click the button
	 * Arguments: obj --> Web object,  objName --> Name of the Object
	 * Created By: Fighter2016
	 * Created Date: Jan 07 2016
	 * Last Modified :Jan 07 2016
	 * */
	public static void clickButton(WebElement obj , String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickButton ", objName + " is clicked.");
		}else{
			Update_Report("Fail", "clickButton ", objName + " object is not displayed please check the application.");
		}
	}

	/* Method Name: enterText
	 * Method description: Enter the text in to text box
	 * Arguments: obj --> Web object, textValue --> Text value to be entered in text box, objName --> Name of the Object
	 * Created By: Fighter2016
	 * Created Date: Jan 06 2016
	 * Last Modified :Jan 06 2016
	 * */
	public static void enterText(WebElement obj, String textValue, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textValue);
			Update_Report("Pass", "enterText", "Expected text " + textValue + " is entered in "+ objName + " field ");
		}else{
			Update_Report("Fail", "Enter User Name ", objName + " field does not exist");
		}
	}

	
	/* Method Name: selectCheckBox
	 * Method description: Select check box
	 * Arguments: obj --> Web object,  objName --> Name of the Object
	 * Created By: Fighter2016
	 * Created Date: Jan 11 2016
	 * Last Modified :Jan 11 2016
	 * */
	public static void selectCheckBox(WebElement obj,String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			if(obj.isSelected()){
				Update_Report("Pass","select the box", objName + " is Selected.");
			}
			else{
				Update_Report("Pass","select the box", objName + " is already selected.");
			}
		}
		else{
			Update_Report("Fail","select the box","select box didnot exist ");
		}

	}
	
	/* Method Name: deselectcheckbox
	 * Method description: cancel selection of check box
	 * Arguments: obj --> Web object,  objName --> Name of the Object
	 * Created By: Fighter2016
	 * Created Date: Jan 11 2016
	 * Last Modified :Jan 11 2016
	 * */
	public static void deSelectCheckBox(WebElement obj,String objName) throws IOException{
        if(obj.isDisplayed()){
            obj.click();
            if(!obj.isSelected()){
            Update_Report("Pass","deselect the box",objName+ " check box is deselected");
            }
            else{
            Update_Report("Pass","deselect the box",objName+ " check box is already deselected");
            }
        }
            else{
            Update_Report("Fail","deselect the box","select box not exist");
             }
        }
	
	
	
	public static void validateTextBoxMsg(WebElement obj, String expectedMsg){
		
	}

	/* Method Name: startReport
	 * Method description: Create report as a log for tests results
	 * Arguments: scriptName --> Test being reported,  ReportsPath --> Path to where report will be saved
	 * Created By: Fighter2016
	 * Created Date: Jan 2016
	 * Last Modified :Jan 13 2016
	 * */
	public static void startReport(String scriptName, String ReportsPath) throws IOException{

			String strResultPath = null;
			String testScriptName =scriptName;

			cur_dt = new Date(); 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String strTimeStamp = dateFormat.format(cur_dt);

			if (ReportsPath == "") { 

				ReportsPath = "C:\\";
			}

			if (ReportsPath.endsWith("\\")) { 
				ReportsPath = ReportsPath + "\\";
			}

			strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
			File f = new File(strResultPath);
			f.mkdirs();
			htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
					+ ".html";



			bw = new BufferedWriter(new FileWriter(htmlname));

			bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
					+ "FireFox " + "</B></FONT></TD></TR>");
			bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
			bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
					+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
					+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


		}

	/* Method Name: Update_Report
	 * Method description: Update report(log) used for saving tests results
	 * Arguments: Res_type --> ???,  Action --> ???? , result --
	 * Created By: Fighter2016
	 * Created Date: Jan  2016
	 * Last Modified :Jan 11 2016
	 * */
	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
			String str_time;
			Date exec_time = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			str_time = dateFormat.format(exec_time);
			if (Res_type.startsWith("Pass")) {
				bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
						+ (j++)
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+Action
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+ str_time
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
						+ "Passed"
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
						+ result + "</FONT></TD></TR>");

			} else if (Res_type.startsWith("Fail")) {
				exeStatus = "Failed";
				DriverClass.reportFlag = 1;
				bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
						+ (j++)
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+Action
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
						+ str_time
						+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
						+ "<a href= "
						+ htmlname
						+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

			} 
		}
		
	/*Method Name: readXl
	 *Brief Description: Read the XL sheet content and return xl content through 2-D array
	 *Arguments: dtPath --> Xl Sheet Path, sheetName --> xl Sheet Name
	 *Creation Date: Dec 23 2015
	 *Last Modified: Dec 23 2015
	 *Created by: Fighters2016 Automation Team
	 * */
	public static String[][] readXl(String dtPath, String sheetName) throws IOException{
			
			
			/*Step 1: Get the XL Path*/
			File  xlFile = new File(dtPath);

			/*step2: Access the Xl File*/
			FileInputStream  xlDoc  = new FileInputStream(xlFile);

			/*Step3: Access the work book (POI jar file) */
			HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

			/*Step4: Access the Sheet */
			HSSFSheet sheet = wb.getSheet(sheetName);

			int iRowCOunt = sheet.getLastRowNum()+1;
			int iColCount = sheet.getRow(0).getLastCellNum();

			System.out.println("Total Rows = " + iRowCOunt);
			System.out.println("Total Col = " + iColCount);

			String[][] xlData = new String[iRowCOunt][iColCount];

			for(int i = 0; i < iRowCOunt; i++){
				for(int j = 0; j < iColCount; j++){

					xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();

				}

			}

			return xlData;
			
			
		}
		
	/*Method Name: writeXl
	 *Brief Description: Write text value to xl sheet
	 *Arguments: dtPath --> Xl Sheet Path, sheetName --> xl Sheet Name, iRow --> row number, iCol --> column number, xlData --> text value to be entered
	 *Creation Date: Jan 04 2016
	 *Last Modified: Jan 04 2016
	 *Created by: Fighters2016 Automation Team
	 * */
	public static void writeXl(String abcd, String sheetName, int iRow, int iCol, String xlData ) throws IOException{
			/*Step 1: Get the XL Path*/
			File  xlFile = new File(abcd);

			/*step2: Access the Xl File*/
			FileInputStream  xlDoc  = new FileInputStream(xlFile);

			/*Step3: Access the work book (POI jar file) */
			HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

			/*Step4: Access the Sheet */
			HSSFSheet sheet = wb.getSheet(sheetName);
			
			
			/*Access Row*/
			HSSFRow   row = sheet.getRow(iRow);
			
			/*Access cell*/
			HSSFCell  cell = row.getCell(iCol);
			
			cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(xlData);  // Write the content
			
			
			if(xlData.equals("Pass")){
				HSSFCellStyle titleStyle = wb.createCellStyle();
				titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
				titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(titleStyle);
			}else if(xlData.equals("Fail")){
				HSSFCellStyle titleStyle = wb.createCellStyle();
				titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
				titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(titleStyle);
			}else{
				HSSFCellStyle titleStyle = wb.createCellStyle();
				titleStyle.setFillBackgroundColor(new HSSFColor.LIGHT_BLUE().getIndex());
				titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(titleStyle);
			}
			
			
			FileOutputStream fout = new FileOutputStream(abcd);
			wb.write(fout);
			fout.flush();
			fout.close();
		}

}
