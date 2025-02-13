package org.lwjglx.workaround.env.probe;


//import org.jetbrains.annotations.NotNull;

/***
 * Implementation from Sodium
 * <a href="https://github.com/CaffeineMC/sodium/blob/3af8680fd14e4c8bd8f8f5eadf711ca20ce980cb/common/src/workarounds/java/net/caffeinemc/mods/sodium/client/compatibility/environment/probe/GraphicsAdapterVendor.java">...</a>
 */

public interface GraphicsAdapterInfo {
    /*@NotNull*/ GraphicsAdapterVendor vendor();

    /*@NotNull*/ String name();

    record LinuxPciAdapterInfo(
            /*@NotNull*/ GraphicsAdapterVendor vendor,
            /*@NotNull*/ String name,

                         String pciVendorId,
                         String pciDeviceId
    ) implements GraphicsAdapterInfo {

    }
}
