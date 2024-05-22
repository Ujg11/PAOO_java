package Tasca_7.Tasca_7B;

import java.time.LocalDateTime;

public abstract class Multa
{
	private long			numDenuncia;
	private LocalDateTime	diaIHora;
	private String			llocInfraccio;
	private String			matricula;
	private String			codiInfraccio;
	private String			descripcio;
	private double			importAPagar;
	private String			estat;
	private static String[] estats = {"pendent de pagament", "pagada", "anul·lada"};

	public Multa(long num, LocalDateTime diaHora, String lloc, String mat, String cod, String d, double imp)
	{
		this.numDenuncia = num;
		this.diaIHora = diaHora;
		this.llocInfraccio = lloc;
		this.matricula = mat;
		this.codiInfraccio = cod;
		this.descripcio = d;
		this.importAPagar = imp;
		this.estat = estats[0];
	}

	public abstract int puntsPerduts();

	public String toString() {
		return "Multa: numDenuncia = " + numDenuncia + "\ndiaIHora = " + diaIHora + "llocInfraccio = " + llocInfraccio
				+ "\nmatricula = " + matricula + "\ncodiInfraccio = " + codiInfraccio + "\ndescripcio = " + descripcio
				+ "\nimportAPagar = " + importAPagar + "\nestat = " + estat;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multa other = (Multa) obj;
		if (numDenuncia != other.numDenuncia)
			return false;
		return true;
	}

	public long getNumDenuncia() {
		return numDenuncia;
	}

	public LocalDateTime getDiaIHora() {
		return diaIHora;
	}

	public void setDiaIHora(LocalDateTime diaIHora) {
		this.diaIHora = diaIHora;
	}

	public String getLlocInfraccio() {
		return llocInfraccio;
	}

	public void setLlocInfraccio(String llocInfraccio) {
		this.llocInfraccio = llocInfraccio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCodiInfraccio() {
		return codiInfraccio;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public double getImportAPagar() {
		return importAPagar;
	}

	public void setImportAPagar(double importAPagar) {
		this.importAPagar = importAPagar;
	}

	public String getEstat() {
		return estat;
	}

	public boolean multaPagada()
	{
		if (this.estat.equals(estats[1]))
			return (true);
		return (false);
	}

	public boolean multaAnulada()
	{
		if (this.estat.equals(estats[2]))
			return (true);
		return (false);
	}

	public boolean multaPendent()
	{
		if (this.estat.equals(estats[0]))
			return (true);
		return (false);
	}

	public void setEstatPagada() {
		this.estat = estats[1];
	}

	public void setEstatAnulada() {
		this.estat = estats[2];
	}

	public static String[] getEstats() {
		return estats;
	}

	public static void setEstats(String[] estats) {
		Multa.estats = estats;
	}

}
