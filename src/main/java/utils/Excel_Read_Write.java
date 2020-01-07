package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_Write {

	public ArrayList<ArrayList<String>> Excel_Read(String FilePath, String FileName, String Sheet_Name)
			throws Exception {

		FileInputStream file = new FileInputStream(FilePath + FileName);
		XSSFWorkbook WBook;
		XSSFSheet Sheet;
		WBook = new XSSFWorkbook(file);
		Sheet = WBook.getSheet(Sheet_Name.toString().toLowerCase());

		Iterator<Row> rowIterator = Sheet.iterator();
		ArrayList<ArrayList<String>> TotalData = new ArrayList<ArrayList<String>>();
		TotalData.add(new ArrayList<String>());

		int i = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			int a = 0;
			while (a >= 0) {

				if (cellIterator.hasNext()) {
					// String Sample =
					// Formatter.formatCellValue(row.getCell(a));
					String Sample = row.getCell(a).getStringCellValue();
					TotalData.get(i).add(Sample);
					a++;
					cellIterator.next();
				} else
					break;
			}
			i++;
			if (rowIterator.hasNext()) {
				TotalData.add(new ArrayList<String>());
			}
		}
		return TotalData;
	}

	public void Excel_Write(String FilePath, String FileName, String Sheet_Name, ArrayList<String> Status_List,
			int Cell_No) throws Exception {

		FileInputStream file = new FileInputStream(FilePath + FileName);

		XSSFWorkbook WBook = new XSSFWorkbook(file);
		XSSFSheet Sheet = WBook.getSheet(Sheet_Name.toString().toLowerCase());
		XSSFRow Row = null;
		XSSFCell Cell;
		int iRowcnt = 0;

		iRowcnt = Sheet.getLastRowNum();
		for (int i = 1; i <= iRowcnt; i++) {

			Row = Sheet.getRow(i);

			//Cell = Row.getCell(Cell_No, Row.);

			//if (Cell == null) {
				Cell = Row.createCell(Cell_No);
			//}

			Cell.setCellValue(Status_List.get(i - 1));

		}
		FileOutputStream fileOut = new FileOutputStream(FilePath + FileName);
		WBook.write(fileOut);
		fileOut.close();
	}



}