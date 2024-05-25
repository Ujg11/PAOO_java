import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ControladorCentreLudic
{
	private IModelCentreLudic	model;
	private IVistaCentreLudic	vista;

	public ControladorCentreLudic(IVistaCentreLudic v, IModelCentreLudic m)
	{
		this.model = m;
		this.vista = v;

		initListeners();
		iniciarVista();
	}

	protected void iniciarVista()
	{
		Iterable<Activitat> llistaActivitats = model.consultarActivitats(1, 0, null);
		vista.mostrarLlistaActivitats(llistaActivitats);
	}

	protected void initListeners()
	{
		vista.addListenerCrearActivitatEsportiva(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaInserirActivitatEsportivaPulsada();
			}
		});
		vista.addListenerCrearActivitatCultural(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaInserirActivitatCulturalPulsada();
			}
		});
		vista.addListenerCrearActivitatFormativa(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaInserirActivitatFormativaPulsada();
			}
		});
		vista.addListenerConsultarActivitat(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaConsultarActivitatPulsada();
			}
		});
		vista.addListenerEliminarActivitat(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaEliminarActivitatPulsada();
			}
		});
		vista.addListenerAplicarFiltresLlistaActivitats(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaFiltresLlistaActivitatsPulsada();
			}
		});
		vista.addListenerInscriureParticipant(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				teclaInscriureParticipantPulsada();
			}
		});
		vista.addListenerCancelarInscripcio(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.out.println("Entra");
				teclaCancelarInscripcioPulsada();
			}
		});
	}

	protected void teclaInserirActivitatEsportivaPulsada()
	{
		ActivitatEsportiva a = vista.getActivitatEsportivaNova();

		if (a != null)
		{
			if (!model.crearNovaActivitat(a))
				vista.mostrarMissatgeError("Ja existeix una activitat amb aquest nom, probi un altre", "Error!");
			if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
				vista.mostrarMissatgeWarning("La informació no s'ha pogut desar correctament", "Error al guardar automaticament");
		}
	}

	protected void teclaInserirActivitatCulturalPulsada()
	{
		ActivitatCultural a = vista.getActivitatCulturalNova();

		if (a != null)
		{
			if (!model.crearNovaActivitat(a))
				vista.mostrarMissatgeError("Ja existeix una activitat amb aquest nom, probi un altre", "Error!");
			if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
				vista.mostrarMissatgeWarning("La informació no s'ha pogut desar correctament", "Error al guardar automaticament");
		}
	}

	protected void teclaInserirActivitatFormativaPulsada()
	{
		ActivitatFormativa a = vista.getActivitatFormativaNova();

		if (a != null)
		{
			if (!model.crearNovaActivitat(a))
				vista.mostrarMissatgeError("Ja existeix una activitat amb aquest nom, probi un altre", "Error!");
			if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
				vista.mostrarMissatgeWarning("La informació no s'ha pogut desar correctament", "Error al guardar automaticament");
		}
	}

	//Busca entre les activitats si existeix la que hi ha escrita a la vista.
	//Ha de mostrar els atributs de l'activitat i la llista dels seus participants
	protected void teclaConsultarActivitatPulsada()
	{
		String nomActivitat = vista.getNomActivitatABuscar();

		if (nomActivitat == null)
			vista.mostrarMissatgeError("Introdueix el nom de la Activitat", "Error al buscar activitat");
		else
		{
			Activitat a = model.trobarActivitat(nomActivitat);
			if (a == null)
				vista.mostrarMissatgeError("Activitat no trobada", "Error al buscar activitat");
			else
			{
				vista.mostrarInformacioActivitat(a);
				Iterable<Persona> inscrits = model.consultarInscripcionsActivitat(nomActivitat);
				vista.mostrarLlistaParticipants(inscrits);
			}
		}
	}

	protected void teclaEliminarActivitatPulsada()
	{
		String nomActivitat = vista.getNomActivitatABuscar();

		if (nomActivitat != null)
		{
			if (model.eliminarActivitat(nomActivitat))
			{
				vista.mostrarMissatgeSuccess("Activitat eliminada correctament", "Administrador");
				if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
					vista.mostrarMissatgeWarning("La informació no s'ha pogut desar correctament", "Error al guardar automaticament");
			}
			else
				vista.mostrarMissatgeError("La activitat a borrar no s'ha trobat", "Error al borrar activitat");
		}
	}

	protected void teclaFiltresLlistaActivitatsPulsada()
	{
		int		admetInscripcions = vista.getFiltreInscripcions();
		int		tipusActivitat = vista.getFiltreTipusActivitat();
		String	poblacio = vista.getFiltrePoblacio();
		
		if (poblacio != null && !model.poblacioCorrecte(poblacio))
			vista.mostrarMissatgeError("No hi ha cap activitat en aquesta població", "Error al filtrar per Població");
		Iterable<Activitat> ll = model.consultarActivitats(admetInscripcions, tipusActivitat, poblacio);
		vista.mostrarLlistaActivitats(ll);
	}

	protected void teclaInscriureParticipantPulsada()
	{
		String nomActivitat = "";
		String dni = ""; 
		String telefon = "";
		model.inscriurePersonaActivitat(nomActivitat, dni, telefon);

		//if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
		//	mostrar_error();
	}

	protected void teclaCancelarInscripcioPulsada()
	{
		String nomActivitat = "";
		String dni = ""; 
		model.cancelarInscripcioPersonaActivitat(nomActivitat, dni);

		//if (!model.desar(AplicacioCentreLudic.getNOM_FITXER()))
		//	mostrar_error();
	}

	
}
