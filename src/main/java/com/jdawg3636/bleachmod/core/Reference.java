package com.jdawg3636.bleachmod.core;

public class Reference
{

    public enum ModItems {

        // Enum Contents
        EMPTYBLEACHBOTTLE("emptyBleachBottle", "emptyBleachBottle"),
        BLEACHBOTTLE("bleachBottle", "bleachBottle"),
        EMPTYWINDEXBOTTLE("emptyWindexBottle", "emptyWindexBottle"),
        WINDEXBOTTLE("windexBottle", "windexBottle");

        // Vars for each member
        private String unlocalizedName;
        private String registryName;

        // Private constructor for members
        ModItems(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        /* Member accessor methods */

        public String getRegistryName() {
            return this.registryName;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

    }

    public enum ModBlocks
    {
        SOLIDBLEACH("solidBleach", "solidBleach");

        private String unlocalizedName;
        private String registryName;

        private ModBlocks(String unlocalizedName, String registryName)
        {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getRegistryName()
        {
            return this.registryName;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }
    }
}
