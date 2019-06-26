import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrearRevistas {
	static final String RUTA = "C:\\temp\\MisRevistas.txt";
	static final int OPCION_CREAR = 1;
	static final int OPCION_LISTAR = 2;
	static final int OPCION_GUARDAR = 3;
	static String titulo;
	static String formato;
	static Long isbn;
	static Integer paginas;
	static Integer opcion;
	static ArrayList<Revista> revistas = new ArrayList<Revista>();


	public static void main(String[] args) throws FileNotFoundException, IOException {

		
		Scanner teclado=new Scanner(System.in);
		
		do {
			mensaje();
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case OPCION_CREAR:
				crearRevista();
				break;
			case OPCION_LISTAR:
				listarRevistas();
				break;
			case OPCION_GUARDAR:
				guardarRevista();
				break;
			default:
				System.out.println("Adios!");
				break;
			}
		} while (opcion != 0);
		sc.close();
	}

	private static void listarRevistas() throws FileNotFoundException, IOException {
		ordenarRevistas();
		for (int i = 0; i < revistas.size(); i++) {
			System.out.println(revistas.get(i).toString());
		}
	}

	private static void ordenarRevistas() throws FileNotFoundException, IOException {
		Revista aux;
		for (int i = 0; i < revistas.size(); i++) {
			for (int j = 0; j < revistas.size(); j++) {
				if (revistas.get(j).getNumeroPaginas() < revistas.get(i).getNumeroPaginas()) {
					aux = revistas.get(i);
					revistas.set(i, revistas.get(j));
					revistas.set(j, aux);
				}
			}
		}
	}

	private static void crearRevista() {
		try {
			pedirTit();

			pedirIsbn();

			pedirPaginas();

			pedirFormato();
			System.out
					.println("Titulo: " + titulo + " ISBN: " + isbn + " Paginas: " + paginas + " Formato: " + formato);
			System.out.println("Estas de acuerdo con los datos introducidos? S/N");
			String resp = sc.nextLine().toLowerCase().trim();
			if (resp.equals("s") || resp.equals("si")) {
				Revista r = new Revista(titulo, isbn, paginas, formato);
				revistas.add(r);
			} else {
				System.out.println("Vuelva a introducir los datos");
				crearRevista();
			}

		} catch (Exception e) {
			System.out.println("ALGO HA FALLADO, VUELVA A INTRODUCIR LOS DATOS");
			e.printStackTrace();
			crearRevista();
		}
	}

	private static void guardarRevista() throws FileNotFoundException, IOException {
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA, true));
		try {
			for (int i = 0; i < revistas.size(); i++) {
				oos.writeObject(revistas.get(i));
				oos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pedirTit() {
		Revista sup = new Revista();
		System.out.print("\nIntroduce un titulo: ");
		titulo = sc.nextLine();
		try {
			sup.setTitulo(titulo);
		} catch (Exception e) {
			System.out.println("TITULO INCORRECTO, INTRODUZCA UNO VALIDO(MIN 3 MAS 150 CARACTERES)");
			pedirTit();
		}
	}

	private static void pedirIsbn() {
		Revista sup = new Revista(formato, opcion, opcion, opcion);
		System.out.print("\nIntroduce un ISBN: ");
		isbn = Long.parseLong(sc.nextLine());
		try {
			sup.setIsbn(isbn);
		} catch (Exception e) {
			System.out.println("ISBN INCORRECTO, INTRODUZCA UNO VALIDO(10 CARACTERES)");
			pedirIsbn();
		}
	}

	private static void pedirPaginas() {
		Revista sup = new Revista(formato, opcion, opcion, opcion);
		System.out.print("\nIntroduce numero de paginas: ");
		paginas = Integer.parseInt(sc.nextLine());
		try {
			sup.setNumeroPag(paginas);
		} catch (Exception e) {
			System.out.println("PAGINAS INCORRECTAS, INTRODUZCA Nº VALIDO(PAGINAS >= 1)");
			pedirPaginas();
		}
	}

	private static void pedirFormato() {
		Revista sup = new Revista(formato, opcion, opcion, opcion);
		System.out.print("\nIntroduce un formato: ");
		formato = sc.nextLine();
		try {
			sup.setFormato(formato);
		} catch (Exception e) {
			System.out.println("FORMATO INCORRECTO, INTRODUZCA UNO VALIDO(PAPEL/DIGITAL)");
			pedirFormato();
		}
	}

	public static void mensaje() {
		System.out.println("==============MENU==============");
		System.out.println("================================\n");
		System.out.println("Opcion 1 - Crear  Revista");
		System.out.println("Opcion 2 - Listar Revistas");
		System.out.println("Opcion 2 - Guardar Revistas");
		System.out.println("Opcion 0 - S A L I R");

		System.out.print("\nIntroduce una opcion: ");
	}

}
