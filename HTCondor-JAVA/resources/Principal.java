public class Principal {

	public static void main(String[] args) {
		long  a=0, b=0, c=0, d = 0,i;
		a=Long.parseLong(args[0]);
		b = Long.parseLong(args[1]);
	c = Long.parseLong(args[2]);
		//a = 1234567;
		//b = 5;
		//c = 128;
		if (a != 0 && b == 0 && c == 0) {
			for (i = 2; i < a; i++) {
				if ((a % i) == 0) {
					d++;
				}
			}
			if (d == 0) {
				System.out.println(a + "\t es un numero primo \n");
			} else {
				System.out.println("Estaba en el numero " + d + " del numero "
						+ a + "\n");
			}
		} else if (b != 0 && c != 0) {
			
			for (i = b; i < c; i++) {
				if ((a % i) == 0) {
					break;
				}
			}
			if (c == (a - 1)) {
				if (i == c) {
					System.out.println("en este rango no se encontro factor para "	+ a	+ "como es el ultimo rango puede ser que " + a + " sea primo");
				} else {
					System.out.println("No es un numero primo ya que " + i + " es factor de " + a);
				}
			} else {
				if (i == c) {
					System.out.println("en este rango no se encontro factor de " + a);
				} else {
					System.out.println("No es un numero primo ya que " + i + " es factor de " + a);
				}
			}
		}
		return;
	}
}
