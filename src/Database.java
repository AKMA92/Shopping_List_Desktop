import java.util.ArrayList;

public class Database {
    private ArrayList<String[]> records;

    public Database() {
        records = new ArrayList<>();
    }

    public void addRecord(String[] record) {
        records.add(record);
    }

    public ArrayList<String[]> getAllRecords() {
        return new ArrayList<>(records);
    }

    public void updateRecord(int index, String[] newRecord) {
        if (index >= 0 && index < records.size()) {
            records.set(index, newRecord);
        }
    }

    public void deleteRecord(int index) {
        if (index >= 0 && index < records.size()) {
            records.remove(index);
        }
    }
}
