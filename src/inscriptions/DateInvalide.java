package inscriptions;

public class DateInvalide extends RuntimeException
{
	public DateInvalide(){
		System.out.println("Date Invalide");
	}
	
	public String toString(){
		return "La date doit �tre avant la date fatidique";
	}
}
