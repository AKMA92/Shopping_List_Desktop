import java.util.ArrayList;

public class RequestHandler {

	public ArrayList<String> getCurrentdata(){
		System.out.println("Aktualisieren");
		ArrayList<String> list = new ArrayList<>();	
		return list;
	}

	public void update(String[] a){
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);	
		}
	}
	
	public void add(String[] a){
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void delete(){
		System.out.println("Löschen");
	}
	
}
