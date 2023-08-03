package gg.zffu.skyblockessentials.versioning;

public enum BuildType {

    RELEASE("Release"),
    DEV("Dev"),
    BETA("Beta Release");

    private String display;
    private BuildType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return this.display;
    }


}
