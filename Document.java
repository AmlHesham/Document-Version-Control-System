class Document {
    String docID;
    VersionNode head;  // رأس الـ Linked List
    int versionCount;

    public Document(String docID) {
        this.docID = docID;
        this.head = null;
        this.versionCount = 0;
    }

    // add new version
    public void addVersion(String content, String timestamp) {
        versionCount++;
        VersionNode newVersion = new VersionNode(versionCount, content, timestamp);
        if (head == null) {
            head = newVersion;
        } else {
            VersionNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVersion;
        }
        System.out.println("Version " + versionCount + " added for document " + docID);
    }

    // upload cpecific version
    public VersionNode getVersion(int versionID) {
        VersionNode temp = head;
        while (temp != null) {
            if (temp.versionID == versionID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // edit on the content
    public void updateVersion(int versionID, String newContent, String timestamp) {
        VersionNode temp = head;
        while (temp != null) {
            if (temp.versionID == versionID) {
                temp.content = newContent;
                temp.timestamp = timestamp;
                System.out.println("Version " + versionID + " updated for document " + docID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Version " + versionID + " not found for document " + docID);
    }

    // delete any version
    public void deleteVersion(int versionID) {
        if (head == null) {
            System.out.println("No versions to delete.");
            return;
        }

        if (head.versionID == versionID) {
            head = head.next;
            System.out.println("Version " + versionID + " deleted for document " + docID);
            return;
        }

        VersionNode temp = head;
        while (temp.next != null) {
            if (temp.next.versionID == versionID) {
                temp.next = temp.next.next;
                System.out.println("Version " + versionID + " deleted for document " + docID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Version " + versionID + " not found for document " + docID);
    }
}
