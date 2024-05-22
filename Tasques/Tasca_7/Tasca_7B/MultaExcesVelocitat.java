package Tasca_7.Tasca_7B;

import java.time.LocalDateTime;

public class MultaExcesVelocitat extends MultaCirculacio
{
	private int	velocitatMaxima;
	private int	velocitatVehicle;

	MultaExcesVelocitat(int num, LocalDateTime diaHora, String lloc, String mat, String cod, String d, double imp, int velMax, int velVe)
	{
		super(num, diaHora, lloc, mat, cod, d, imp);
		this.velocitatMaxima = velMax;
		this.velocitatVehicle = velVe;
	}

	private double calcularVelPercentatge(double p)
	{
		return (velocitatMaxima * (1 + p / 100));
	}

	public int puntsPerduts()
	{
		if (velocitatVehicle < calcularVelPercentatge(10))
			return (0);
		else if (velocitatVehicle >= calcularVelPercentatge(10) && velocitatVehicle <= calcularVelPercentatge(35))
			return (0);
		else if (velocitatVehicle >= calcularVelPercentatge(36) && velocitatVehicle <= calcularVelPercentatge(50))
			return (2);
		else if (velocitatVehicle >= calcularVelPercentatge(51) && velocitatVehicle <= calcularVelPercentatge(60))
			return (4);
		else
			return (6);
	}

	public String toString()
	{
		String s = super.toString();

		s += "\nVelocitat a la que circulaba: " + velocitatVehicle;
		s += "\nPunts retirats: " + puntsPerduts();
		return (s);
	}

	public int getVelocitatMaxima() {
		return velocitatMaxima;
	}

	public void setVelocitatMaxima(int velocitatMaxima) {
		this.velocitatMaxima = velocitatMaxima;
	}

	public int getVelocitatVehicle() {
		return velocitatVehicle;
	}

	public void setVelocitatVehicle(int velocitatVehicle) {
		this.velocitatVehicle = velocitatVehicle;
	}

}
