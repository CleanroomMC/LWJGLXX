package org.lwjglx.workaround;

import com.sun.jna.Platform;
import com.sun.jna.platform.unix.LibC;
import org.lwjglx.workaround.env.probe.GraphicsAdapterProbe;
import org.lwjglx.workaround.env.probe.GraphicsAdapterVendor;

/***
 * Implementation from Sodium
 * <a href="https://github.com/CaffeineMC/sodium/blob/3af8680fd14e4c8bd8f8f5eadf711ca20ce980cb/common/src/workarounds/java/net/caffeinemc/mods/sodium/client/compatibility/workarounds/nvidia/NvidiaWorkarounds.java">...</a>
 */

public class NvidiaWorkaround {
    public static boolean isNvidiaGraphicsCardPresent() {
        return GraphicsAdapterProbe.getAdapters()
                .stream()
                .anyMatch(adapter -> adapter.vendor() == GraphicsAdapterVendor.NVIDIA);
    }

    static public void apply() {
        try {
            if (Platform.isLinux() || Platform.isOpenBSD() || Platform.isFreeBSD() || Platform.isNetBSD() || Platform.isDragonFlyBSD() || Platform.iskFreeBSD()) {
                LibC.INSTANCE.setenv("__GL_THREADED_OPTIMIZATIONS", "0", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
