package net.minecraftforge.common.config;

public @interface Config {
    public static enum Type {
        INSTANCE(true);

        private boolean isStatic = true;

        private Type(boolean isStatic) {
            this.isStatic = isStatic;
        }

        public boolean isStatic() {
            return this.isStatic;
        }
    }
}
