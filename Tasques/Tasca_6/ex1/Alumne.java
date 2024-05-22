package Tasca_6.ex1;

import java.util.ArrayList;
import java.util.List;

public class Alumne
{
	private String			dni;
	private String			nom;
	private String			correu;
	private List<Double>	notes;

	public Alumne(String dni, String nom)
	{
		this.dni = dni;
		this.nom = nom;
		this.correu = null;
		notes = new ArrayList<Double>();
	}

	public Alumne(String dni, String nom, String correu)
	{
		this.dni = dni;
		this.nom = nom;
		this.correu = correu;
		notes = new ArrayList<Double>();
	}

	public String getDni() {
		return dni;
	}

	public String getNom() {
		return nom;
	}

	public String getCorreu() {
		return correu;
	}

	public Iterable<Double> getNotes()
	{
		return notes;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public boolean afegirNota(double nota)
	{
		return (this.notes.add(nota));
	}

	public double calcularMitjana()
	{
		double	mitjana = 0;

		if (notes.isEmpty())
			return (0.0);
		for (double n: notes)
		{
			mitjana += n;
		}
		return (mitjana / notes.size());
	}
}