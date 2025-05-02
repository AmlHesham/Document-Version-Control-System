public class VersionNode {
    int versionID;
    String content;
    String timestamp;
    VersionNode next;

    public VersionNode(int versionID, String content, String timestamp) {
        this.versionID = versionID;
        this.content = content;
        this.timestamp = timestamp;
        this.next = null;
    }
}


