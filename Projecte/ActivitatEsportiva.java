import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatEsportiva extends Activitat
{
	private String[] dies;

	// Inicializar con una fecha específica (año, mes, día)
	//LocalDate fechaEspecifica = LocalDate.of(2022, 5, 8);
	private LocalDate dataInici;
	private LocalDate dataFi;

	// Inicializar con una hora específica (hora, minuto, segundo)
	//LocalTime horaEspecifica = LocalTime.of(14, 30, 0);
	private LocalTime[] horaInici;
	private LocalTime[] horaFi;

	public ActivitatEsportiva(String nom, String des, int maxPart, String a, String p, String[] dies, LocalDate dataIcici,
						LocalDate dataFi, LocalTime[] horaInici, LocalTime[] horaFi)
	{
		super(nom, des, maxPart, a, p);
		this.dies = dies;
		this.dataInici = dataIcici;
		this.dataFi = dataFi;
		this.horaInici = horaInici;
		this.horaFi = horaFi;
	}

	public boolean esPossibleInscriures(LocalDate data)
	{
		if (data.isAfter(this.dataFi))
			return (false);
		return (true);
	}

	public boolean admetInscripcio()
	{
		LocalDate dataActual = LocalDate.now();

		if (esPossibleInscriures(dataActual) && this.llocPerInscripcio())
			return (true);
		return (false);
	}

	public boolean ferInscripcio(Persona p)
	{
		LocalDate dataActual = LocalDate.now();
		
		if (p == null)
			return (false);
		if (esPossibleInscriures(dataActual) && this.llocPerInscripcio())
		{
			if (!this.inscrits.containsKey(p.getDNI()))
			{
				this.inscrits.put(p.getDNI(), p);
				this.personesInscrites++;
				return (true);
			}
		}
		return (false);
	}

	public int tipusActivitat()
	{
		return (1);
	}

	public String[] getDies() {
		return dies;
	}

	public void setDies(String[] dies) {
		this.dies = dies;
	}

	public LocalDate getDataInici() {
		return dataInici;
	}

	public void setDataInici(LocalDate dataIcici) {
		this.dataInici = dataIcici;
	}

	public LocalDate getDataFi() {
		return dataFi;
	}

	public void setDataFi(LocalDate dataFi) {
		this.dataFi = dataFi;
	}

	public LocalTime[] getHoraInici() {
		return horaInici;
	}

	public void setHoraInici(LocalTime[] horaInici) {
		this.horaInici = horaInici;
	}

	public LocalTime[] getHoraFi() {
		return horaFi;
	}

	public void setHoraFi(LocalTime[] horaFi) {
		this.horaFi = horaFi;
	}
}
