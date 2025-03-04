package org.lwjglx.opengl;

public class NVFence {

    public static final int GL_ALL_COMPLETED_NV = (int) 34034;
    public static final int GL_FENCE_CONDITION_NV = (int) 34036;
    public static final int GL_FENCE_STATUS_NV = (int) 34035;

    public static void glDeleteFencesNV(int fence) {
        org.lwjgl3.opengl.NVFence.glDeleteFencesNV(fence);
    }

    public static void glDeleteFencesNV(java.nio.IntBuffer piFences) {
        org.lwjgl3.opengl.NVFence.glDeleteFencesNV(piFences);
    }

    public static void glFinishFenceNV(int fence) {
        org.lwjgl3.opengl.NVFence.glFinishFenceNV(fence);
    }

    public static int glGenFencesNV() {
        return org.lwjgl3.opengl.NVFence.glGenFencesNV();
    }

    public static void glGenFencesNV(java.nio.IntBuffer piFences) {
        org.lwjgl3.opengl.NVFence.glGenFencesNV(piFences);
    }

    public static void glGetFenceivNV(int fence, int pname, java.nio.IntBuffer piParams) {
        org.lwjgl3.opengl.NVFence.glGetFenceivNV(fence, pname, piParams);
    }

    public static boolean glIsFenceNV(int fence) {
        return org.lwjgl3.opengl.NVFence.glIsFenceNV(fence);
    }

    public static void glSetFenceNV(int fence, int condition) {
        org.lwjgl3.opengl.NVFence.glSetFenceNV(fence, condition);
    }

    public static boolean glTestFenceNV(int fence) {
        return org.lwjgl3.opengl.NVFence.glTestFenceNV(fence);
    }
}
