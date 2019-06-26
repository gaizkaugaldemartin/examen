public class Revista implements Comparable<Revista> {

	private static final int LONGITUD_MIN_TITULO = 3;
	private static final int LONGITUD_MAX_TITULO = 150;
	private static final int LONGITUD_CODIGO = 10;
	private String titulo;
	private Long isbn;
	private int numeroPaginas;
	private String formato;
	private String codigo;

	public Revista(String titulo, Long isbn2, int numeroPaginas, String formato2) {
		super();
		this.titulo = titulo;
		this.isbn = isbn2;
		this.numeroPaginas = numeroPaginas;
		this.formato = formato2;
	}

	private String getTitulo() {
		return titulo;
	}

	Long getIsbn() {
		return isbn;
	}

	private void setIsbn(int isbn) {
		this.isbn = (long) isbn;
	}

	int getNumeroPaginas() {
		return numeroPaginas;
	}

	private void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	private String getFormato() {
		return formato;
	}

	void setFormato(String formato2) {
		this.formato = formato2;
	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", isbn=" + isbn + ", numeroPaginas=" + numeroPaginas + ", formato="
				+ formato + "]";
	}

	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getNumVecesLeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Revista o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTitulo(String titulo) throws Exception {

		if (titulo != null && titulo.length() >= LONGITUD_MIN_TITULO && titulo.length() <= LONGITUD_MAX_TITULO) {

			this.titulo = titulo;

		} else {

			String msg = "Titulo debe tener longitud entre " + LONGITUD_MIN_TITULO + " y " + LONGITUD_MAX_TITULO;
			throw new Exception(msg);
		}

	}

	public String getCodigo() {
		return getCodigo();
	}

	public void setCodigo(String codigo) throws Exception {

		if (codigo != null && codigo.length() == LONGITUD_CODIGO) {

			this.codigo = codigo;

		} else {

			throw new Exception("Longitud codigo debe ser " + LONGITUD_CODIGO);

		}
	}

	public void setNumeroPag(Integer paginas) {
		// TODO Auto-generated method stub
		
	}

}
