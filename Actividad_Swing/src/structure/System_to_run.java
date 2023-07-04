package structure;

import java.awt.Dimension;
import java.awt.Toolkit;

public class System_to_run {

	private int widthcenter;
	private int heighcenter;

	public System_to_run() {

		// ADAPTACION DEL PROGRAMA A LA RESOLUCION DEL TIPO DE SISTEMA QUE LO EJECUTA
		// PARA PONERLO EN EL MEDIO DE LA PANTALLA
		Toolkit myScreen = Toolkit.getDefaultToolkit(); // almacenamos el sistema nativo

		Dimension sizeScreen = myScreen.getScreenSize(); // guardamos la resolucion nativa del sistema

		this.widthcenter = sizeScreen.width; // el ancho de la resolucion de la pantalla principal
		this.heighcenter = sizeScreen.height; // el alto de la resolucion de la pantalla principal

	
	}
public  int heighCenterSystem() {
	
	return this.heighcenter/4;
}

public  int widthCenterSystem() {
	
	return this.widthcenter/4;
	
}
	public int getWidthcenter() {
		return widthcenter;
	}

	public void setWidthcenter(int widthcenter) {
		this.widthcenter = widthcenter;
	}

	public int getHeighcenter() {
		return heighcenter;
	}

	public void setHeighcenter(int heighcenter) {
		this.heighcenter = heighcenter;
	}

}
