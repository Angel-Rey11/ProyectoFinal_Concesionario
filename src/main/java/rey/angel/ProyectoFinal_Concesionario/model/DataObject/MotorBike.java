package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

public class MotorBike extends Coche{
	public MotorBike() {
		super();
	}
	
	public MotorBike(String matricula, String marca, String modelo, String ano, String color, String kilometros,
			String precio, String cilindrada) {
		super(matricula, marca, modelo, ano, color, kilometros,
				precio, cilindrada);
	}

}
