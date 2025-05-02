public class Main {
    public static void main(String[] args) {
        DocumentVersionControlSystem system = new DocumentVersionControlSystem();

        // create new document
        system.createDocument("doc1");

        // add different versions
        system.addVersion("doc1", "This is the first version of the document.", "2024-12-11 10:00");
        system.addVersion("doc1", "This is the updated version of the document.", "2024-12-11 11:00");

        // upload cpecific version
        system.getVersion("doc1", 1);

        // compare between two version
        system.compareVersions("doc1", 1, 2);

        // edit any version
        system.updateVersion("doc1", 1, "This is the modified first version of the document.", "2024-12-11 12:00");

        //  upload any version
        system.getVersion("doc1", 1);

        // delete version
        system.deleteVersion("doc1", 1);

        // retrive deleting version
        system.getVersion("doc1", 1);
    }
}
