import java.util.ArrayList;

public class RequestHandler {

	public ArrayList<String> getCurrentdata(){
		System.out.println("Aktualisieren");
		ArrayList<String> list = new ArrayList<>();	
		return list;
	}

	public void update(String[] a){
		System.out.println("Ändern");
	}
	
	public void add(String[] a){

	}
	
	public void delete(){
		System.out.println("Löschen");
	}
	
}
