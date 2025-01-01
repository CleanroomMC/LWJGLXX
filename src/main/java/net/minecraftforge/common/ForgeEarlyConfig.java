package net.minecraftforge.common;


public class ForgeEarlyConfig {

    public static boolean RAW_INPUT = true;

    //TODO : make CATEGORY?
    //TODO : make the config display name lowcase?

    public static boolean WINDOW_START_MAXIMIZED = false;
    public static boolean WINDOW_START_FOCUSED = true;
    public static boolean WINDOW_START_ICONIFIED = false;

    public static boolean WINDOW_CENTERED = true;

    public static boolean WINDOW_DECORATED = true;

    public static boolean WINDOW_BORDERLESS_REPLACES_FULLSCREEN = false;

    public static boolean WINDOW_BORDERLESS_WINDOWS_COMPATIBILITY = true;

    public static boolean OPENGL_DEBUG_CONTEXT = false;

    public static boolean OPENGL_SRGB_CONTEXT = false;

    public static boolean OPENGL_DOUBLEBUFFER = true;

    public static boolean OPENGL_CONTEXT_NO_ERROR = false;

    public static boolean DECORATED = true;

    public static boolean INPUT_INVERT_WHEEL = false;

    public static double INPUT_SCROLL_SPEED = 1.0;

    public static boolean INPUT_CTRL_ALT_TEXT = false;

    public static boolean INPUT_ALTGR_ESCAPE_CODES = false;

    public static String X11_CLASS_NAME = "minecraft";

    public static String COCOA_FRAME_NAME = "minecraft";

    public static String CONFIG_ANY_TIME_VERSION = "3.0";
    public static String MIXIN_BOOTER_VERSION = "10.2";


    public static String[] LOADING_PLUGIN_BLACKLIST = new String[] {
            "com.cleanroommc.configanytime.ConfigAnytimePlugin",
            "zone.rong.mixinbooter.MixinBooterPlugin",
            "ilib.asm.Loader",
            "org.dimdev.jeid.JEIDLoadingPlugin",
            "lain.mods.skins.init.forge.asm.Plugin",
            "advancedshader.core.Core",
            "net.shadowfacts.forgelin.preloader.ForgelinPlugin",
    };

    public static CategoryOpenAlContext OPENAL_CONTEXT = new CategoryOpenAlContext();
    public static class CategoryOpenAlContext{
        public boolean ENABLE_HRTF = false;
    }


}
