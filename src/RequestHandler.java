import java.util.ArrayList;

public class RequestHandler {
    private Database database;

    public RequestHandler() {
        this.database = new Database();
    }

    public ArrayList<String[]> getCurrentData() {
        return database.getAllRecords();
    }

    public void add(String[] record) {
        database.addRecord(record);
    }

    public void update(int index, String[] record) {
        database.updateRecord(index, record);
    }

    public void delete(int index) {
        database.deleteRecord(index);
    }
}
