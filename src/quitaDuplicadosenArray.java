/** Este programa quita valores duplicados en un array dado de n x n
 * @author juanjosecolin
 *
 */

import java.util.*;
import java.util.Collections;

public class quitaDuplicadosenArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arreglo de entrada
		int[] myArray = {2,3,4,2,2};
		
		//Impresion de Resultados
		System.out.println("Arreglo de entrada "+java.util.Arrays.toString((myArray)));
		System.out.println("Arreglo de salida "+java.util.Arrays.toString((getRidOfDuplicates(myArray))));

	}
	
	public static Integer[] getRidOfDuplicates(int arrayx[]) {
				
		//Declaramos un array list para copiar y ordernar valores
		ArrayList<Integer> copyofArray = new ArrayList<>();
		
		//Copiamos los elementod del Arreglo al ArrayList
		for(int i=0;i < arrayx.length;i++) {
			copyofArray.add(arrayx[i]);
		}
		
		//Ordenamos el arreglo
		Collections.sort(copyofArray); 
		
		//Incrementamos valores duplicados
		for(int k=0; k<copyofArray.size();k++) {
			for(int j=k; j< copyofArray.size() - 1;j++) {
				if(copyofArray.get(k)==copyofArray.get(j+1)) {
					copyofArray.set(j+1, copyofArray.get(j+1) + 1);
				}
			}
		}
		
		//Copiamos el arrayList con los resultados en un array.
		Integer[] arrayClean = copyofArray.toArray(new Integer [copyofArray.size()]);
		
		//Regresamos el arreglo de resultados		
		return arrayClean;
	}

}
