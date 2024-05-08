import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatEsportiva extends Activitat
{
	private String[] dies;
	private LocalDate dataIcici;
	private LocalDate dataFi;
	private LocalTime[] horaInici;
	private LocalTime[] horaFi;

	public ActivitatEsportiva(String nom, String des, int maxPart, int persIns, String a, String p, String[] dies, LocalDate dataIcici,
						LocalDate dataFi, LocalTime[] horaInici, LocalTime[] horaFi)
	{
		super(nom, des, maxPart, persIns, a, p);
		this.dies = dies;
		this.dataIcici = dataIcici;
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

	public boolean ferInscripcio(Persona p)
	{
		LocalDate dataActual = LocalDate.now();
		if (esPossibleInscriures(dataActual) && this.llocPerInscripcio())
		{
			for (int i = 0; i < this.getPersonesInscrites() - 1; i++)
			{
				if (this.inscrits[i].getDNI().equals(p.getDNI()))
					return (false);
			}
			inscrits[this.getPersonesInscrites()] = p;
			this.setPersonesInscrites(getPersonesInscrites() + 1);
			return (true);
		}
		return (false);
	}

	public String[] getDies() {
		return dies;
	}

	public void setDies(String[] dies) {
		this.dies = dies;
	}

	public LocalDate getDataIcici() {
		return dataIcici;
	}

	public void setDataIcici(LocalDate dataIcici) {
		this.dataIcici = dataIcici;
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
