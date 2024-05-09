import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActivitatFormativa extends Activitat
{
	// Inicializar con una fecha y hora específicas (año, mes, día, hora, minuto, segundo)
	//LocalDateTime fechaHoraEspecifica = LocalDateTime.of(2022, 5, 8, 14, 30, 0);
	private LocalDateTime diaIHora;
	private LocalDate dataLimit;
	private double duradaActivitat;


	public ActivitatFormativa(String nom, String descripcio, int maximParticipants, int personesInscrites,
			String adresa, String poblacio, LocalDateTime data, LocalDate limit, double durada)
	{
		super(nom, descripcio, maximParticipants, personesInscrites, adresa, poblacio);
		this.diaIHora = data;
		this.dataLimit = limit;
		this.duradaActivitat = durada;
	}

	public boolean esPossibleInscriures()
	{
		LocalDate dataActual = LocalDate.now();

		if (dataActual.isBefore(this.dataLimit) || dataActual.isEqual(this.dataLimit))
			return (true);
		return (false);
	}

	public boolean ferInscripcio(Persona p)
	{
		if (esPossibleInscriures() && llocPerInscripcio())
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

	public LocalDateTime getDiaIHora() {
		return diaIHora;
	}

	public void setDiaIHora(LocalDateTime diaIHora) {
		this.diaIHora = diaIHora;
	}

	public LocalDate getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(LocalDate dataLimit) {
		this.dataLimit = dataLimit;
	}

	public double getDuradaActivitat() {
		return duradaActivitat;
	}

	public void setDuradaActivitat(double duradaActivitat) {
		this.duradaActivitat = duradaActivitat;
	}
}
