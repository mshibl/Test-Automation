//akshay.kumar@tekArch.com  skype ID ( 9 to 5 PST)
// Compare two XL sheet content having similar rows and column
// Read the data form web table and compare with Xl sheet
// SF Test cases 15 test cases Automate it, 5 rest 10 automate 
// Consider two identical xl Sheet, compare two sheets and for match make green and for no match make red in second xl sheet
/* WJP program to compare two xl sheet by using a controller , for comparision make red or green depends on match or no match
for no comparison make it yellow
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;


public class readXLSheet {

	public static void main(String[] args) throws IOException {
		String dtPath = "/Users/Shibl/Desktop/xl1.xls";
		String dtPathNew = "/Users/Shibl/Desktop/xl2.xls";
		
		String[][] recData1 = readXl(dtPath, "Sheet1");
		String[][] recData2 = readXl(dtPathNew, "Sheet1");
		
		for(int i = 0; i <recData1.length; i++){
			for(int j = 0; j <recData1[0].length; j++){
//				System.out.println(recData1[i][j]);
//				System.out.println(recData2[i][j]);
				
				if(recData1[i][j].equals(recData2[i][j])){
					writeXl(dtPathNew, "Sheet1", i, j, "Pass");
				}else{
					writeXl(dtPathNew, "Sheet1", i, j, "Fail");
				}
			}
		}
		
		String dtPathTest = "/Users/Shibl/Desktop/xl3.xls";
		
		writeXl(dtPathTest, "Sheet1", 2, 1, "Hello");
		writeXl(dtPathTest, "Sheet1", 1, 1, "Thank you");
		writeXl(dtPathTest, "Sheet1", 0, 1, "Same here");
		writeXl(dtPathTest, "Sheet1", 1, 0, "Happy New Year..");
		
//		String[][] recData = readXl(dtPath, "Sheet1");
//		
//		
//		 dtPathNew = "C:/Users/Abhi/Desktop/ConfigurationFileCopy1.xls";
//		String[][] recDataNew = readXl(dtPathNew, "Sheet1");
//		
//		
//		for(int i =0; i <recData.length; i++){
//			for(int j =0; j<recData[0].length; j++){
//				
//				if(recData[i][j] == recDataNew[i][j]){
//					System.out.println("Pass");
//				}else{
//					System.out.println("Fail");
//				}
//			}
//		}
//		
//		for(int i =0; i <recData.length; i++){
//			for(int j =0; j<recData[0].length; j++){
//				System.out.print(recData[i][j] + " ");
//			}
//			System.out.println();
//		}

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
		if(row == null){
			sheet.createRow(iRow);
			row = sheet.getRow(iRow);
		}
		
		/*Access cell*/
		HSSFCell  cell = row.getCell(iCol);
		if(cell == null){
			row.createCell(iCol).setCellValue("");
			cell = row.getCell(iCol);
		}
		
		//cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(xlData);  // Write the content
		
		
		if(xlData.equals("Pass")){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else{
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}
		
		
		FileOutputStream fout = new FileOutputStream(abcd);
		wb.write(fout);
		fout.flush();
		fout.close();
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
	
	
}
