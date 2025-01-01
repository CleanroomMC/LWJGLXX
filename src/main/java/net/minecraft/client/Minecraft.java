package net.minecraft.client;

public class Minecraft {
    private static final Minecraft minecraft = new Minecraft();
    public static Minecraft getMinecraft() { return minecraft; }
    public void resize(int width, int height){}
}
