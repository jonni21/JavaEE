package module1;

public class Main {

    public static void main(String[] args) {

        ReportGenerator rp = new ReportGenerator();
        rp.addRow(CollectionType.ARRAY_LIST);
        rp.addRow(CollectionType.LINKED_LIST);
        rp.addRow(CollectionType.HASH_SET);
        rp.addRow(CollectionType.TREE_SET);
        rp.saveToFile("report.txt");
        rp.printTable();

    }
}
