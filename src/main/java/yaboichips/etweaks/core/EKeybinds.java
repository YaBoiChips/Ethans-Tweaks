package yaboichips.etweaks.core;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class EKeybinds {
        public static KeyBinding POCKET_KEY = new KeyBinding("Open Pocket", GLFW.GLFW_KEY_H, "Ethans Tweaks");
        public static KeyBinding ROCKET_KEY = new KeyBinding("Rocket Boots", GLFW.GLFW_KEY_R, "Ethans Tweaks");

        public static void register() {
            ClientRegistry.registerKeyBinding(POCKET_KEY);
            ClientRegistry.registerKeyBinding(ROCKET_KEY);
        }
    }

