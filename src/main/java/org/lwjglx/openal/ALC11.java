package org.lwjglx.openal;

public class ALC11 {

    public static final int ALC_ALL_DEVICES_SPECIFIER = (int) 4115;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = (int) 785;
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = (int) 784;
    public static final int ALC_CAPTURE_SAMPLES = (int) 786;
    public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = (int) 4114;
    public static final int ALC_MONO_SOURCES = (int) 4112;
    public static final int ALC_STEREO_SOURCES = (int) 4113;

    public static boolean alcCaptureCloseDevice(ALCdevice device) {

        boolean returnValue = org.lwjgl.openal.ALC11.alcCaptureCloseDevice(device.device);

        return returnValue;
    }

    public static ALCdevice alcCaptureOpenDevice(java.lang.String arg0, int arg1, int frequency,
                                                 int format) {

        ALCdevice returnValue = new ALCdevice(
                org.lwjgl.openal.ALC11.alcCaptureOpenDevice(arg0, arg1, frequency, format));

        return returnValue;
    }

    public static void alcCaptureSamples(ALCdevice device, java.nio.ByteBuffer buffer, int samples) {

        org.lwjgl.openal.ALC11.alcCaptureSamples(device.device, buffer, samples);
    }

    public static void alcCaptureStart(ALCdevice device) {

        org.lwjgl.openal.ALC11.alcCaptureStart(device.device);
    }

    public static void alcCaptureStop(ALCdevice device) {

        org.lwjgl.openal.ALC11.alcCaptureStop(device.device);
    }
}
