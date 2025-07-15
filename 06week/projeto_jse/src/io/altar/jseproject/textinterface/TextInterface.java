package io.altar.jseproject.textinterface;
import java.util.Scanner;

public class TextInterface {
	private Scanner sc = new Scanner(System.in);
	
	public void ecraInicio() {
		//TODO add list
		
		switch (sc.nextLine()) {
		case "1":
			ecraProduto();
			break;
			
		default:
			ecraPrateleira();
			break;
		}
	}
	
	public int ecraProduto() {
		switch (sc.nextLine(int valor)){
			switch (valor) {
			case 1:
				return 1;
				
				default:
					return -1;
			}
			//TODO add list
		}
		
		public void ecaPrateleira () {
			
		}
	}
}
