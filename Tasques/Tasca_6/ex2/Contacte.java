package Tasca_6.ex2;

import java.util.HashSet;
import java.util.Set;

public class Contacte
{
	private String		nom;
	private String		correu;
	private Set<String>	telefons;

	Contacte(String nom)
	{
		this.nom = nom;
		this.correu = null;
		this.telefons = new HashSet<>();
	}

	Contacte(String nom, String correu)
	{
		this.nom = nom;
		this.correu = correu;
		this.telefons = new HashSet<>();
	}

	Contacte(String nom, String correu, String tel)
	{
		this.nom = nom;
		this.correu = correu;
		this.telefons = new HashSet<>();
		this.telefons.add(tel);
	}

	public String getNom() {
		return nom;
	}

	public String getCorreu() {
		return correu;
	}

	public Iterable<String> getTelefons()
	{
		return (telefons);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public boolean afegirTelefon(String tel)
	{
		return (this.telefons.add(tel));
	}

	public boolean existeixTelefon(String tel)
	{
		return (this.telefons.contains(tel));
	}

	public boolean esborrarTelefon(String tel)
	{
		return (this.telefons.remove(tel));
	}

}
