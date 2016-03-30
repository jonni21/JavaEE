package module1;

import static module1.CollectionType.*;

public class Main {

    public static void main(String[] args) {

        ReportGenerator rp = new ReportGenerator();
        rp.addRow(ARRAY_LIST);
        rp.addRow(LINKED_LIST);
        rp.addRow(HASH_SET);
        rp.addRow(TREE_SET);
        rp.saveToFile("report.txt");
        rp.printTable();
    }
}