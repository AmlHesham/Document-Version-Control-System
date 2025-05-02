import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class DocumentVersionControlSystem {
    HashMap<String, Document> documentMap;

    public DocumentVersionControlSystem() {
        documentMap = new HashMap<>();
    }

    // add new document
    public void createDocument(String docID) {
        if (documentMap.containsKey(docID)) {
            System.out.println("Document with ID " + docID + " already exists.");
        } else {
            documentMap.put(docID, new Document(docID));
            System.out.println("Document " + docID + " created.");
        }
    }

    // add new version of document
    public void addVersion(String docID, String content, String timestamp) {
        Document doc = documentMap.get(docID);
        if (doc == null) {
            System.out.println("Document with ID " + docID + " does not exist.");
        } else {
            doc.addVersion(content, timestamp);
        }
    }

    // upload specific version
    public void getVersion(String docID, int versionID) {
        Document doc = documentMap.get(docID);
        if (doc == null) {
            System.out.println("Document with ID " + docID + " does not exist.");
        } else {
            VersionNode version = doc.getVersion(versionID);
            if (version == null) {
                System.out.println("Version " + versionID + " not found for document " + docID);
            } else {
                System.out.println("Document ID: " + docID + ", Version: " + versionID);
                System.out.println("Content: " + version.content);
                System.out.println("Timestamp: " + version.timestamp);
            }
        }
    }

    // compare between two version
    public void compareVersions(String docID, int version1ID, int version2ID) {
        Document doc = documentMap.get(docID);
        if (doc == null) {
            System.out.println("Document with ID " + docID + " does not exist.");
        } else {
            VersionNode version1 = doc.getVersion(version1ID);
            VersionNode version2 = doc.getVersion(version2ID);
            if (version1 == null || version2 == null) {
                System.out.println("One or both versions not found for document " + docID);
            } else {
                System.out.println("Differences between Version " + version1ID + " and Version " + version2ID + ":");

                Set<String> words1 = new HashSet<>();
                Set<String> words2 = new HashSet<>();

                for (String word : version1.content.split(" ")) {
                    words1.add(word);
                }
                for (String word : version2.content.split(" ")) {
                    words2.add(word);
                }

                // words that added
                Set<String> addedWords = new HashSet<>(words2);
                addedWords.removeAll(words1);
                for (String word : addedWords) {
                    System.out.println("- Added: " + word);
                }

                // words that deleted
                Set<String> removedWords = new HashSet<>(words1);
                removedWords.removeAll(words2);
                for (String word : removedWords) {
                    System.out.println("- Removed: " + word);
                }
            }
        }
    }

    // edit any version
    public void updateVersion(String docID, int versionID, String newContent, String timestamp) {
        Document doc = documentMap.get(docID);
        if (doc == null) {
            System.out.println("Document with ID " + docID + " does not exist.");
        } else {
            doc.updateVersion(versionID, newContent, timestamp);
        }
    }

    // deleting any version
    public void deleteVersion(String docID, int versionID) {
        Document doc = documentMap.get(docID);
        if (doc == null) {
            System.out.println("Document with ID " + docID + " does not exist.");
        } else {
            doc.deleteVersion(versionID);
        }
    }
}
