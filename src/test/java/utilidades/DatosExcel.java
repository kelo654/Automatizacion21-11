package utilidades;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class DatosExcel {
	public static Object[][] leerExcel(String ruta, String nombreHoja) throws Exception {
		// Creo es tipo de archivo con clase estandar para manejo de archivos.
		FileInputStream file = new FileInputStream(new File(ruta));

		// Creo el objeto para manejo de archivos Excel .xlsx
		XSSFWorkbook libroExcel = new XSSFWorkbook(file);
		
		// Creo el objeto para manejo de Hojas de archivos Excel .xlsx
		XSSFSheet Hoja = libroExcel.getSheet(nombreHoja);

		// Creo el objeto para manejo de Filas de archivos Excel .xlsx
		XSSFRow fila;

		// Obtengo la cantidad de filas con datos
		int filas = Hoja.getPhysicalNumberOfRows();

		// Obtengo la cantidad de columnas con datos
		int columnas = Hoja.getRow(0).getPhysicalNumberOfCells();

		// Creo el Objeto Object que guardará los datos necesarios en forma de matriz.
		Object cellValue[][] = new Object[filas - 1][columnas];

		// Imprimiendo en consola Datos de Excel
		System.out.println("Leyendo Excel.." + "\n");
		System.out.println("Ruta de arhivo: " + ruta);
		System.out.println("Nombre de Hoja: " + nombreHoja);
		System.out.println("Total de filas: " + (filas));
		System.out.println("Cantidad de Filas con datos: " + (filas-1));
		System.out.println("Cantidad de Columnas con datos: " + columnas);

		// Recorro las filas y columnas con datos para asignar a nuestro objeto Object
		// que asignara los datos para retornarlos.
		for (int r = 1; r < filas; r++) {
			fila = Hoja.getRow(r);
			if (fila == null) {
				break;
			} else {
				System.out.println("\n");
				System.out.print("Valores Fila: " + r + " > ");
				System.out.println("\n");
				for (int c = 0; c < columnas; c++) {
					cellValue[r - 1][c] = Hoja.getRow(r).getCell(c).getStringCellValue();
					System.out.println("Columna " + c + ": " + cellValue[r - 1][c]);

				}

			}

		}

		/*Retorno el valor de objeto Object con datos asignados. Cada vez que se
		ejecute el metodo DatosExcel.leerExcel() este devolvera este Object[][] completo.*/
		return cellValue;

	}
}