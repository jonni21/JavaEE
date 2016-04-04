package module1;

import static module1.CollectionType.*;

public class Main {

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.addRow(ARRAY_LIST);
        reportGenerator.addRow(LINKED_LIST);
        reportGenerator.addRow(HASH_SET);
        reportGenerator.addRow(TREE_SET);
        reportGenerator.saveToFile("readme.md");
        reportGenerator.printTable();
    }
}