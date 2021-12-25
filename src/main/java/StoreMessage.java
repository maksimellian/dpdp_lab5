public class StoreMessage {
    private final String url;
    private final float avgTime;

    public StoreMessage(String url, float avgTime) {
        this.url = url;
        this.avgTime = avgTime;
    }

    public String getUrl() {
        return this.url;
    }

    public float getAvgTime() {
        return avgTime;
    }
}
