package gg.zffu.skyblockessentials.gui.elements;

public abstract class GuiElement {

    public boolean enabled;
    public int heigth;
    public int width;

    public GuiElement() {

    }

    public abstract void render();

}
