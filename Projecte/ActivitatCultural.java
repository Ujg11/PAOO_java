//import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.LocalTime;

public class ActivitatCultural extends Activitat
{
	private double preu;
	private LocalDateTime horariActivitat;

	public ActivitatCultural(String nom, String descripcio, int maximParticipants, int personesInscrites, String adresa, String poblacio,
							double preu, LocalDateTime horari)
	{
		super(nom, descripcio, maximParticipants, personesInscrites, adresa, poblacio);
		this.preu = preu;
		this.horariActivitat = horari;
	}

	public boolean esPossibleInscriures()
	{
		LocalDateTime dataActual = LocalDateTime.now();
		return (dataActual.isBefore(this.horariActivitat.minusHours(48)));//restem 48 h a l'hora d'inici i mirem si es pot
	}

	public boolean ferInscripcio(Persona p)
	{
		if (esPossibleInscriures() && llocPerInscripcio())
		{
			for (int i = 0; i < getPersonesInscrites() - 1; i++)
			{
				if (inscrits[i].getDNI().equals(p.getDNI()))
					return (false);
			}
			inscrits[getPersonesInscrites()] = p;
			setPersonesInscrites(getPersonesInscrites() + 1);
			return (true);
		}
		return (false);
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public LocalDateTime getHorariActivitat() {
		return horariActivitat;
	}

	public void setHorariActivitat(LocalDateTime horariActivitat) {
		this.horariActivitat = horariActivitat;
	}
}
